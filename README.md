# FIRST – Fast (Rozwiązanie z prostym mockiem)

## ✅ Rozwiązanie

Zamiast korzystać z prawdziwego `SmtpEmailService` (wolny, zależny od sieci),
używamy **prostego mocka** (`FakeEmailService`) stworzonego w samym teście.

Dzięki temu:

- Test jest **bardzo szybki** (brak `Thread.sleep`, brak sieci).
- Test sprawdza tylko logikę `OrderService` – czy poprawnie wywołuje `EmailService`.
- Nie potrzebujemy żadnej infrastruktury (SMTP, API, kontenerów).

## 🧩 Jak działa ten mock?

```java
private static class FakeEmailService implements EmailService {

    boolean wasCalled = false;
    String capturedEmail;
    String capturedOrderNumber;

    @Override
    public void sendOrderConfirmation(String email, String orderNumber) {
        this.wasCalled = true;
        this.capturedEmail = email;
        this.capturedOrderNumber = orderNumber;
    }
}
```