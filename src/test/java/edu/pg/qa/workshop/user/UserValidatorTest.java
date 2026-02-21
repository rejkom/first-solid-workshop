package edu.pg.qa.workshop.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private final UserValidator validator = new UserValidator();

    @Test
    void shouldAcceptValidEmailAndPassword() {
        assertDoesNotThrow(() -> {
            validator.validateEmail("john.doe@example.com");
            validator.validatePassword("StrongPass1");
        });
    }

    @Test
    void shouldRejectInvalidEmail() {
        assertThrows(UserValidationException.class,
                () -> validator.validateEmail("invalid-email"));
    }

    @Test
    void shouldRejectTooShortPassword() {
        assertThrows(UserValidationException.class,
                () -> validator.validatePassword("Abc1"));
    }

    @Test
    void shouldRejectPasswordWithoutUppercase() {
        assertThrows(UserValidationException.class,
                () -> validator.validatePassword("weakpass1"));
    }

    @Test
    void shouldRejectPasswordWithoutDigit() {
        assertThrows(UserValidationException.class,
                () -> validator.validatePassword("WeakPass"));
    }
}
