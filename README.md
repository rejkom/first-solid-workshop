# FIRST – Timely (Terminowość pisania testów)

## 🎯 O co chodzi w Timely?

**Timely** to zasada mówiąca o tym, **KIEDY** piszemy testy:

✅ **Najlepiej: przed kodem lub równocześnie** (TDD - Test Driven Development)  
✅ **Akceptowalne: zaraz po napisaniu funkcjonalności** (jeszcze pamiętasz co chciałeś osiągnąć)  
❌ **Złe: "napiszę testy później"** (prawie nigdy się nie dzieje)  
❌ **Najgorsze: po tygodniach/miesiącach** (nie pamiętasz już kontekstu, legacy code)

## Dlaczego ważne jest pisanie testów "na czas"?

### Pisanie testów wcześnie:
- ✅ **Lepszy design kodu** - testowalny kod = czysty kod
- ✅ **Szybsze wykrywanie błędów** - łapiesz je, zanim pójdą na produkcję
- ✅ **Dokumentacja** - testy pokazują jak kod ma działać
- ✅ **Łatwiejsze** - pamiętasz co chciałeś osiągnąć
- ✅ **Refactoring bez strachu** - testy chronią przed regresją

### Pisanie testów późno ("later"):
- ❌ **Trudniejsze** - kod już istnieje, trzeba się dostosować
- ❌ **Kod nietestowalny** - twarde zależności, zbyt złożony
- ❌ **Nie pamiętasz edge cases** - zapominasz o szczególnych przypadkach
- ❌ **"Później" = nigdy** - presja terminów, zawsze są ważniejsze rzeczy
- ❌ **Więcej bugów** - błędy wykryte później = droższe naprawy

## 📚 TDD (Test Driven Development) - ekstremalny Timely

Najpopularniejsza implementacja Timely to **TDD**:

1. **RED** - Napisz test (nie ma kodu, test pada)
2. **GREEN** - Napisz minimalny kod, żeby test przeszedł
3. **REFACTOR** - Popraw kod, testy chronią przed regresją

**Korzyści TDD:**
- Kod zawsze testowalny (bo test był pierwszy)
- Piszesz tylko kod, który jest potrzebny
- 100% pokrycia testami (naturalnie)