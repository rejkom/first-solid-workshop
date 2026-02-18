# FIRST – Fast (Antywzorzec)

## 🔴 Problem

Ten test jednostkowy korzysta z **realnej implementacji serwisu e-mail** (`SmtpEmailService`), która symuluje połączenie sieciowe (`Thread.sleep(2000)`).

Skutki:

- Test jest **wolny** – jedno uruchomienie trwa około 2 sekund.
- Przy większej liczbie testów całkowity czas narasta (np. 50 testów x 2s = ~100 sekund).
- Test jest **kruchy** – zależy od zewnętrznej infrastruktury (sieć, SMTP, API).

## 🎯 Zadanie

1. Uruchom test `OrderServiceSlowTest`.
2. Zwróć uwagę, jak długo trwa jego wykonanie.
3. Zastanów się:
    - Jak często odpalałbyś taki test lokalnie?
    - Co by się stało, gdyby takich testów było 100?
    - Czy chciałbyś mieć je w szybkim buildzie CI uruchamianym po każdym commicie?

## 💡 Wniosek

- **Unit test** powinien być SZYBKI (Fast) – testuje logikę w izolacji, bez prawdziwej sieci/bazy.
- Test z realnym `SmtpEmailService` to tak naprawdę **test integracyjny**, niejednostkowy.
- Potrzebujemy sposobu, aby sprawdzić zachowanie `OrderService` bez prawdziwego połączenia sieciowego.

Przejdź do brancha `01-fast-good`, żeby zobaczyć, jak użycie prostego mocka rozwiązuje ten problem.
