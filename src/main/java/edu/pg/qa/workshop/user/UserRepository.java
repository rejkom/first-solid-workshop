package edu.pg.qa.workshop.user;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
