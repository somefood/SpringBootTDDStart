package test.commerce.api.seller.signup;

import java.util.UUID;

public class EmailGenerator {
    
    public static String generateEmail() {
        return UUID.randomUUID() + "@test.com";
    }
}
