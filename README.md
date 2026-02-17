# Warsztaty: Dobre praktyki przy pisaniu testów (FIRST + SOLID)

## O projekcie

Projekt Maven dla studiów podyplomowych **„Zapewnienie jakości oprogramowania"** na Politechnice Gdańskiej.

**Temat:** Dobre praktyki przy pisaniu testów w oparciu o zasady FIRST oraz SOLID


## Wymagania

- **Java 21** (lub nowsza)
- **Maven 3.6+**
- **IntelliJ IDEA** (zalecane) lub Eclipse/VS Code
- **Git**

## Struktura projektu

```
first-solid-workshop/
├── pom.xml                          # Konfiguracja Maven (JUnit 5.14.3)
├── README.md                        # Ten plik
├── .gitignore                       # Pliki ignorowane przez Git
├── src/
│   ├── main/java/                   # Kod produkcyjny
│   │   └── edu/pg/qa/workshop/
│   │       └── calculator/
│   │           └── Calculator.java  # Prosta klasa kalkulatora
│   └── test/java/                   # Testy
│       └── edu/pg/qa/workshop/
│           └── calculator/
│               ├── CalculatorBadTest.java   # Antywzorce (do analizy)
│               └── CalculatorGoodTest.java  # Wzorce FIRST
```

## Jak uruchomić projekt

### 1. Sklonuj repozytorium

```bash
git clone <URL_REPOZYTORIUM>
cd first-solid-workshop
```

### 2. Zbuduj projekt

```bash
mvn clean compile
```

### 3. Uruchom testy

```bash
mvn test
```

Powinieneś zobaczyć:
- ✅ Wszystkie testy z `CalculatorGoodTest` przechodzą (zielony)
- ⚠️ Testy z `CalculatorBadTest` to antywzorce (do analizy podczas zajęć)

### 4. Uruchom konkretny test w IntelliJ

- Otwórz plik testowy (np. `CalculatorGoodTest.java`)
- Kliknij prawym przyciskiem na nazwę klasy testowej
- Wybierz **Run 'CalculatorGoodTest'**

## Moduły warsztatów

### Moduł 0: Wprowadzenie (0,5h)
- Po co FIRST i SOLID w testach
- Case study z prawdziwego projektu
- Korzyści dla QA i zespołu

### Moduł 1: Minimum Javy i anatomia testu (1,5h)
- Struktura projektu Maven
- Podstawowa składnia Java dla testerów
- Struktura testu JUnit 5
- Given-When-Then
- Asercje i nazewnictwo testów

**🎯 To jest materiał do tego modułu!**

### Moduł 2: Zasady FIRST (2,5h)
- **F**ast - testy szybkie
- **I**ndependent - niezależność testów
- **R**epeatable - powtarzalność
- **S**elf-Validating - automatyczna walidacja
- **T**imely - pisanie testów na czas

### Moduł 3: Zasady SOLID w testach (2,5h)
- **S**ingle Responsibility - jeden test, jeden scenariusz
- **O**pen/Closed - rozszerzalność testów
- **L**iskov Substitution - testy dla interfejsów
- **I**nterface Segregation - małe helpery
- **D**ependency Inversion - odwrócenie zależności

### Moduł 4: Podsumowanie (0,5h)
- Q&A
- Zadanie zaliczeniowe (praca grupowa)

## Pliki w projekcie

### Calculator.java
Prosta klasa kalkulatora z podstawowymi operacjami matematycznymi:
- `add(a, b)` - dodawanie
- `subtract(a, b)` - odejmowanie
- `multiply(a, b)` - mnożenie
- `divide(a, b)` - dzielenie (rzuca wyjątek przy dzieleniu przez zero)
- `factorial(n)` - silnia
- `isEven(number)` - sprawdzanie parzystości

### CalculatorBadTest.java ❌
**To jest celowy antywzorzec do analizy!**

Przykłady złych praktyk:
- Niejasne nazwy testów (`test1`, `testCalculator`)
- "God test" - testowanie zbyt wielu rzeczy naraz
- Brak struktury given-when-then
- Trudne do debugowania

**Nie używaj tego jako wzorca!** To materiał do dyskusji: "Co jest tu złe?"

### CalculatorGoodTest.java ✅
**To jest wzorzec zgodny z FIRST!**

Dobre praktyki:
- Jasna struktura given-when-then (z komentarzami)
- `@DisplayName` z czytelnymi opisami po polsku
- Jeden test = jeden scenariusz
- `@BeforeEach` do setupu
- Precyzyjne asercje z komunikatami

## Materiały do przygotowania się

Przed zajęciami warto zapoznać się z:

### 1. Podstawy Git
- `git clone` - klonowanie repozytorium
- `git status` - status zmian
- `git checkout <branch>` - przełączanie między branchami

**Tutorial:** [Git Basics](https://git-scm.com/docs/gittutorial)

### 2. Struktura testu jednostkowego
- Co to jest test jednostkowy (unit test)
- Struktura Given-When-Then
- Podstawowe asercje

**Dokumentacja:** [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

### 3. Opcjonalnie - przypomnienie Java
Jeśli dawno nie miałeś/aś kontaktu z Javą, przejrzyj:
- Klasy i obiekty
- Metody i ich wywoływanie
- Typy danych (int, double, boolean)

**Cheat sheet:** [Java Basics](https://introcs.cs.princeton.edu/java/11cheatsheet/)

## Pomoc techniczna

### Sprawdzenie środowiska

```bash
# Sprawdź wersję Javy (powinna być 21 lub nowsza)
java -version

# Sprawdź Maven
mvn -version
```

### Częste problemy

**Problem:** "mvn: command not found"
- **Rozwiązanie:** Zainstaluj Maven: https://maven.apache.org/install.html

**Problem:** Projekt się nie kompiluje
```bash
# Wyczyść i zbuduj od nowa
mvn clean compile
```

**Problem:** Testy nie uruchamiają się w IntelliJ
- **Rozwiązanie:** 
  1. File → Invalidate Caches / Restart
  2. Kliknij prawym na pom.xml → Maven → Reload Project

**Problem:** "Cannot resolve symbol JUnit"
- **Rozwiązanie:** Maven musi pobrać zależności:
```bash
mvn clean install
```

## Kontakt

**Prowadzący:** [Michał Rejkowski]  
**Email:** [michal.rejkowski@outlook.com]  
**Studia:** Zapewnienie jakości oprogramowania, Politechnika Gdańska

---

**Powodzenia na warsztatach! 🚀**
