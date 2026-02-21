package edu.pg.qa.workshop.user;

import java.util.regex.Pattern;

public class UserValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new UserValidationException("Email nie może być pusty");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new UserValidationException("Email ma nieprawidłowy format");
        }
    }

    public void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new UserValidationException("Hasło nie może być puste");
        }
        if (password.length() < 8) {
            throw new UserValidationException("Hasło musi mieć co najmniej 8 znaków");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new UserValidationException("Hasło musi zawierać wielką literę");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new UserValidationException("Hasło musi zawierać cyfrę");
        }
    }

}
