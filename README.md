# FIRST – Self-Validating (Rozwiązanie)

## ✅ Rozwiązanie
Testy w tym branchu **mają czytelne asercje** – automatycznie sprawdzają poprawność wyniku i jasno komunikują problemy.

## 🎯 Co się zmieniło?

### Przed (branch `04-self-validating-bad`):
```java
@Test
void shouldGenerateSummaryForSingleItem() {
    String summary = generator.generateSummary("Jan Kowalski", 1500.00, 1);
    
    // ❌ Brak asercji- tylko logowanie
    System.out.println(summary);
    System.out.println("Sprawdź ręcznie czy jest poprawne!");
}
```