package test.commerce.api.seller.signup;

import java.util.UUID;

public class PasswordGenerator {

    public static String generatePassword() {
        return "password" + UUID.randomUUID();
    }
}
