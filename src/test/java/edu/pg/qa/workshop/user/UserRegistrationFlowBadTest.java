package edu.pg.qa.workshop.user;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * ANTYWZORZEC SRP:
 * Jeden test sprawdza:
 * - walidację emaila i hasła
 * - zapis do repozytorium
 * - wysyłkę emaila powitalnego
 * - logowanie zdarzenia do audytu
 * - poprawność hasha hasła
 * <p>
 * Problem:
 * - Trudne debugowanie
 * - Test ma wiele powodów do zmiany (łamanie SRP)
 */
class UserRegistrationFlowBadTest {

    @Test
    void shouldRegisterUserCompleteFlow() {
        // given - setup WSZYSTKIEGO naraz
        UserValidator validator = new UserValidator();
        InMemoryUserRepository userRepository = new InMemoryUserRepository();
        EmailSender emailSender = mock(EmailSender.class);
        AuditLogger auditLogger = mock(AuditLogger.class);
        PasswordHasher passwordHasher = raw -> "HASH_" + raw;

        UserRegistrationService service = new UserRegistrationService(
                validator,
                userRepository,
                emailSender,
                auditLogger,
                passwordHasher
        );

        String email = "john.doe@example.com";
        String password = "StrongPass1";

        // when - wywołanie całego flow
        User user = service.register(email, password);

        // then - CZĘŚĆ 1: walidacja domenowa
        assertEquals(email, user.getEmail());
        assertEquals("HASH_" + password, user.getPasswordHash());
        assertTrue(user.isActive());

        // then - CZĘŚĆ 2: zapis w repo
        Optional<User> fromRepo = userRepository.findByEmail(email);
        assertTrue(fromRepo.isPresent());
        assertEquals(email, fromRepo.get().getEmail());

        // then - CZĘŚĆ 3: email powitalny
        verify(emailSender, times(1)).sendWelcomeEmail(email);

        // then - CZĘŚĆ 4: log audytu
        ArgumentCaptor<String> eventTypeCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> detailsCaptor = ArgumentCaptor.forClass(String.class);
        verify(auditLogger, times(1)).log(eventTypeCaptor.capture(), detailsCaptor.capture());

        assertEquals("USER_REGISTERED", eventTypeCaptor.getValue());
        assertEquals(email, detailsCaptor.getValue());

        // then - CZĘŚĆ 5: walidacja błędnych danych (w tym samym teście!)
        assertThrows(UserValidationException.class,
                () -> service.register("zly-email", "weak"),
                "Powinien zostać rzucony wyjątek dla nieprawidłowych danych");

        assertThrows(UserValidationException.class,
                () -> service.register("john.doe@example.com", "weak"),
                "Powinien zostać rzucony wyjątek dla słabego hasła");

        // then - CZĘŚĆ 6: użytkownik duplikuje się
        assertThrows(UserValidationException.class,
                () -> service.register(email, password),
                "Powinien zostać rzucony wyjątek dla istniejącego emaila");
    }
}
