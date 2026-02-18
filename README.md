# FIRST – Independent (Antywzorzec)

## 🔴 Problem
Testy w tym branchu są **zależne od siebie** – współdzielą ten sam obiekt `cart` i zakładają określoną kolejność wykonania.

## 🎯 Zadanie dla uczestników

1. **Uruchom testy** – prawdopodobnie przejdą (jeśli wykonają się w kolejności 1→2→3→4)
2. **Spróbuj uruchomić tylko test3** (`test3_shouldRemoveItem`) – co się stanie?
3. **Spróbuj uruchomić tylko test2** (`test2_shouldAddSecondItem`) – dlaczego pada?
4. **Zastanów się:**
    - Co się stanie, gdy framework zmieni kolejność testów?
    - Jak debugować test, który pada tylko "czasami"?
    - Czy możesz bezpiecznie usunąć test1 bez wpływu na inne?

## 💡 Konsekwencje zależnych testów

- ❌ Nie możesz uruchomić testów w dowolnej kolejności
- ❌ Nie możesz uruchomić pojedynczego testu w izolacji
- ❌ Trudno zrozumieć, dlaczego test pada ("działa u mnie", "zależy od kolejności")
- ❌ Usunięcie jednego testu psuje inne
- ❌ Równoległe wykonanie testów niemożliwe

## 📚 Zasada Independent

Każdy test powinien być **samodzielną jednostką**:
- Przygotowuje własne dane (Given)
- Nie zależy od wyniku innych testów
- Można go uruchomić w dowolnej kolejności
- Można go uruchomić samodzielnie

## 🔧 Wskazówki do naprawy

- Każdy test powinien mieć własny obiekt `cart`
- Usuń `static` ze współdzielonego stanu
- Każdy test sam przygotowuje potrzebne dane
- Przejdź na branch `02-independent-good` żeby zobaczyć rozwiązanie
