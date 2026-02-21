package edu.pg.qa.workshop.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserRepositoryTest {

    private InMemoryUserRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryUserRepository();
    }

    @Test
    void shouldSaveAndFindUserByEmail() {
        User user = new User("john.doe@example.com", "HASH");
        repository.save(user);

        Optional<User> result = repository.findByEmail("john.doe@example.com");

        assertTrue(result.isPresent());
        assertEquals("john.doe@example.com", result.get().getEmail());
    }

    @Test
    void shouldReturnEmptyWhenUserNotFound() {
        Optional<User> result = repository.findByEmail("unknown@example.com");
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldDetectExistingEmail() {
        User user = new User("john.doe@example.com", "HASH");
        repository.save(user);

        assertTrue(repository.existsByEmail("john.doe@example.com"));
        assertFalse(repository.existsByEmail("other@example.com"));
    }
}
