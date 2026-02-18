# FIRST – Repeatable (Rozwiązanie)

## ✅ Rozwiązanie

Testy w tym branchu są **w pełni deterministyczne** – przekazujemy konkretną datę jako parametr, więc wynik jest zawsze
taki sam.

## 🎯 Co się zmieniło?

### Przed (branch `03-repeatable-bad`):

```java
public double calculateWeekendDiscount(double orderTotal) {
    LocalDate today = LocalDate.now(); // ❌ Niedeterministyczne!
    // ...
}

@Test
void shouldApplyWeekendDiscount() {
    double discount = service.calculateWeekendDiscount(1000.0);
    assertEquals(150.0, discount); // ❌ Pada w tygodniu!
}
```