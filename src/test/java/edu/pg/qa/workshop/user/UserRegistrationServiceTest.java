package edu.pg.qa.workshop.user;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserRegistrationServiceTest {

    private final UserValidator validator = mock(UserValidator.class);
    private final UserRepository userRepository = mock(UserRepository.class);
    private final EmailSender emailSender = mock(EmailSender.class);
    private final AuditLogger auditLogger = mock(AuditLogger.class);
    private final PasswordHasher passwordHasher = raw -> "HASH_" + raw;

    private final UserRegistrationService service = new UserRegistrationService(
            validator,
            userRepository,
            emailSender,
            auditLogger,
            passwordHasher
    );

    @Test
    void shouldRegisterUserAndTriggerSideEffects() {
        String email = "john.doe@example.com";
        String password = "StrongPass1";

        when(userRepository.existsByEmail(email)).thenReturn(false);

        User user = service.register(email, password);

        // Walidacja maila oraz hasła
        verify(validator).validateEmail(email);
        verify(validator).validatePassword(password);

        // Repozytorium otrzymuje poprawnego użytkownika
        verify(userRepository).save(any(User.class));
        assertEquals(email, user.getEmail());
        assertEquals("HASH_" + password, user.getPasswordHash());

        // Wysłany email powitalny
        verify(emailSender).sendWelcomeEmail(email);

        // Wpis w audycie
        ArgumentCaptor<String> eventType = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> details = ArgumentCaptor.forClass(String.class);

        verify(auditLogger).log(eventType.capture(), details.capture());
        assertEquals("USER_REGISTERED", eventType.getValue());
        assertEquals(email, details.getValue());
    }

    @Test
    void shouldNotAllowDuplicatedEmail() {
        String email = "john.doe@example.com";
        String password = "StrongPass1";

        when(userRepository.existsByEmail(email)).thenReturn(true);

        assertThrows(UserValidationException.class,
                () -> service.register(email, password));

        verify(userRepository, never()).save(any());
        verify(emailSender, never()).sendWelcomeEmail(any());
        verify(auditLogger, never()).log(any(), any());
    }
}
