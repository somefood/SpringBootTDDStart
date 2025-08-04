package commerce.api.controller;

import commerce.Shopper;
import commerce.ShopperRepository;
import commerce.view.ShopperMeView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

@RestController
public record ShopperMeController(
    ShopperRepository repository
) {
    
    @GetMapping("/shopper/me")
    ShopperMeView me(Principal user) {
        UUID uuid = UUID.fromString(user.getName());
        Shopper shopper = repository.findById(uuid).orElseThrow();
        return new ShopperMeView(uuid, shopper.getEmail(), shopper.getUsername());
    }
}
