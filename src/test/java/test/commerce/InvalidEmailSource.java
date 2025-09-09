package test.commerce;

import org.junit.jupiter.params.provider.MethodSource;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@MethodSource("test.commerce.TestDataSource#invalidEmails")
public @interface InvalidEmailSource {
}
