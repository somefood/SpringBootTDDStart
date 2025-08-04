package commerce.api.controller;

import java.security.Principal;
import java.util.UUID;

import commerce.SellerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record SellerProductsController(SellerRepository repository) {

    @PostMapping("/seller/products")
    ResponseEntity<?> registerProduct(Principal user) {
        UUID id = UUID.fromString(user.getName());
        if (repository.findById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
