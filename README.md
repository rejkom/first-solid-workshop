# FIRST – Repeatable (Antywzorzec)

## 🔴 Problem
Testy w tym branchu są **niedeterministyczne** – ich wynik zależy od aktualnej daty systemowej.

## 🎯 Zadanie dla uczestników

1. **Sprawdź, jaki jest dzisiaj dzień tygodnia** (poniedziałek-piątek vs sobota-niedziela)
2. **Uruchom testy** – jeden z nich prawdopodobnie pada
3. **Zmień datę systemową** (jeśli możesz) i uruchom ponownie
4. **Zastanów się:**
    - Jak przetestować kod, który zależy od czasu/daty?
    - Co by się stało, gdyby testy były uruchamiane automatycznie w CI każdego dnia?
    - Jak debugować test, który pada "tylko w poniedziałki"?

## 💡 Konsekwencje niedeterministycznych testów

- ❌ Test działa na Twoim komputerze, pada w CI
- ❌ Test przechodzi dzisiaj, pada jutro (bez zmian w kodzie!)
- ❌ Nie można odtworzyć błędu ("u mnie działa")
- ❌ Zespół traci zaufanie do testów ("znowu flakey test")
- ❌ Trzeba zapamiętać "ten test pada w weekendy, ignoruj"

## 📚 Zasada Repeatable

Test powinien dać **ten sam wynik** niezależnie od:
- Daty i czasu wykonania
- Środowiska (dev, CI, produkcja)
- Kolejności wykonania
- Danych zewnętrznych (sieć, losowość)

## 🔧 Typowe źródła niedeterminizmu

1. **Czas systemowy** – `LocalDate.now()`, `System.currentTimeMillis()`
2. **Losowość** – `Random`, `UUID.randomUUID()`
3. **Zewnętrzne zasoby** – API, baza danych, system plików
4. **Współbieżność** – wielowątkowość bez synchronizacji

## 🔧 Wskazówki do naprawy

- Wstrzyknij kontrolowany zegar/datę do testowanej klasy
- Przekaż datę jako parametr metody
- Użyj "test double" (zastępnik) dla czasu
- Przejdź na branch `03-repeatable-good` żeby zobaczyć rozwiązanie
