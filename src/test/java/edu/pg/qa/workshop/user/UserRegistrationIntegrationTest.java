package edu.pg.qa.workshop.user;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserRegistrationIntegrationTest {

    @Test
    void shouldRegisterUserEndToEnd() {
        UserValidator validator = new UserValidator();
        InMemoryUserRepository repository = new InMemoryUserRepository();
        EmailSender emailSender = mock(EmailSender.class);
        AuditLogger auditLogger = mock(AuditLogger.class);
        PasswordHasher passwordHasher = raw -> "HASH_" + raw;

        UserRegistrationService service = new UserRegistrationService(
                validator,
                repository,
                emailSender,
                auditLogger,
                passwordHasher
        );

        String email = "john.doe@example.com";
        String password = "StrongPass1";

        User user = service.register(email, password);

        // Minimalne asercje end-to-end
        Optional<User> fromRepo = repository.findByEmail(email);
        assertTrue(fromRepo.isPresent());
        assertEquals(email, fromRepo.get().getEmail());

        verify(emailSender).sendWelcomeEmail(email);
        verify(auditLogger).log(eq("USER_REGISTERED"), eq(email));
    }
}
