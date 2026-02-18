# FIRST – Self-Validating (Antywzorzec)

## 🔴 Problem
Testy w tym branchu **nie mają asercji** – wypisują wynik na konsolę i oczekują ręcznej weryfikacji przez programistę.

## 🎯 Zadanie dla uczestników

1. **Uruchom testy** – wszystkie "przechodzą" (zielone w JUnit)
2. **Przeczytaj logi w konsoli** – czy tam jest informacja o problemach?
3. **Zmodyfikuj kod produkcyjny** (np. zmień "Klient:" na "Customer:") i uruchom ponownie
4. **Zastanów się:**
    - Czy JUnit wykrył błąd?
    - Jak długo zajęłoby Ci ręczne czytanie logów z 100 testów?
    - Co by się stało, gdyby te testy były uruchamiane automatycznie w CI?

## 💡 Konsekwencje testów bez asercji

- ❌ Test "przechodzi" nawet gdy kod jest błędny
- ❌ Trzeba ręcznie czytać setki linii logów
- ❌ Nie można uruchomić w CI (nikt nie przeczyta logów)
- ❌ Tracisz czas na ręczną weryfikację zamiast pisać kolejne testy
- ❌ Zespół nie wie, czy test naprawdę sprawdza coś użytecznego

## 📚 Zasada Self-Validating

Test powinien **sam powiedzieć** czy przeszedł, czy nie:
- **Zielony** = kod działa poprawnie
- **Czerwony** = znaleziono błąd, jasny komunikat co jest nie tak
- Bez potrzeby ręcznej analizy logów, debuggera, czy "sprawdź ręcznie"

## 🔧 Typowe błędy przeciwko Self-Validating

1. **Brak asercji** – test nic nie sprawdza
2. **Tylko logowanie** – `System.out.println()` zamiast `assertEquals()`
3. **Komentarze "sprawdź ręcznie"** – programista musi sam patrzeć
4. **Test wymaga debuggera** – trzeba zatrzymać i sprawdzić zmienne

## 🔧 Wskazówki do naprawy

- Dodaj asercje: `assertEquals()`, `assertTrue()`, `assertNotNull()`
- Sprawdź konkretne wartości, nie tylko "czy nie pada"
- Użyj opisowych komunikatów błędów w asercjach
- Przejdź na branch `04-self-validating-good` żeby zobaczyć rozwiązanie
