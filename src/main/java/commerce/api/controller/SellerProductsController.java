package commerce.api.controller;

import java.net.URI;
import java.security.Principal;
import java.util.UUID;

import commerce.SellerRepository;
import commerce.command.RegisterProductCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record SellerProductsController(SellerRepository repository) {

    @PostMapping("/seller/products")
    ResponseEntity<?> registerProduct(
        Principal user,
        @RequestBody RegisterProductCommand command
    ) {
        UUID id = UUID.fromString(user.getName());
        if (repository.findById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else if (isValidUri(command.imageUri()) == false) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private boolean isValidUri(String value) {
        try {
            URI uri = URI.create(value);
            return uri.getHost() != null;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
