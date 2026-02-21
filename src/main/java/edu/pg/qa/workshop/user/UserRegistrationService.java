package edu.pg.qa.workshop.user;

import java.util.Objects;

public class UserRegistrationService {

    private final UserValidator validator;
    private final UserRepository userRepository;
    private final EmailSender emailSender;
    private final AuditLogger auditLogger;
    private final PasswordHasher passwordHasher;

    public UserRegistrationService(UserValidator validator,
                                   UserRepository userRepository,
                                   EmailSender emailSender,
                                   AuditLogger auditLogger,
                                   PasswordHasher passwordHasher) {
        this.validator = Objects.requireNonNull(validator);
        this.userRepository = Objects.requireNonNull(userRepository);
        this.emailSender = Objects.requireNonNull(emailSender);
        this.auditLogger = Objects.requireNonNull(auditLogger);
        this.passwordHasher = Objects.requireNonNull(passwordHasher);
    }

    public User register(String email, String password) {
        validator.validateEmail(email);
        validator.validatePassword(password);

        if (userRepository.existsByEmail(email)) {
            throw new UserValidationException("Użytkownik o takim emailu już istnieje");
        }

        String passwordHash = passwordHasher.hash(password);
        User user = new User(email, passwordHash);
        userRepository.save(user);

        emailSender.sendWelcomeEmail(email);
        auditLogger.log("USER_REGISTERED", email);

        return user;
    }
}
