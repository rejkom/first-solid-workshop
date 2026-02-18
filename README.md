# FIRST – Independent (Rozwiązanie)

## ✅ Rozwiązanie
Każdy test w tym branchu jest **całkowicie niezależny** – tworzy własny obiekt `cart` i przygotowuje własne dane.

## 🎯 Co się zmieniło?

### Przed (branch `02-independent-bad`):
```java
// ❌ Współdzielony stan
private static ShoppingCart cart = new ShoppingCart();

@Test
void test2_shouldAddSecondItem() {
    cart.addItem("Mouse");
    assertEquals(2, cart.getItemCount()); // Zakłada wykonanie test1!
}
```