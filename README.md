# SOLID OCP Example - Open/Closed Principle w testach

Projekt demonstracyjny dla studiów podyplomowych PG - Moduł 3: SOLID w testach.

## Cel projektu

Pokazanie jak zasada Open/Closed Principle (OCP) wpływa na strukturę testów.

## Problem (03-solid-ocp-bad)

**8 osobnych testów** dla różnych typów klientów i poziomów lojalności.

Każdy test to kopiuj-wklej z małymi zmianami:
```java
@Test
void shouldCalculateDiscountForStandardCustomer() { ... }

@Test
void shouldCalculateDiscountForPremiumCustomer() { ... }
// ... 6 więcej podobnych testów
```

