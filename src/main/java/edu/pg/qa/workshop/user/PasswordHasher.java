package edu.pg.qa.workshop.user;

public interface PasswordHasher {
    String hash(String rawPassword);
}
