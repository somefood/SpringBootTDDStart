package commerce.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record SellerProductsController() {

    @PostMapping("/seller/products")
    ResponseEntity<?> registerProduct() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
