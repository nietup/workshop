# Warsztaty Clean Code

Repo do ćwiczeń: Clean Code, SOLID, TDD 

Wymagania: Java 11+.

Kompilacja: 

```
bash scripts/compile.sh
```

Clean Code demo: 

```
bash scripts/run_clean_code.sh
```

SOLID demo: 

```
bash scripts/run_solid.sh
```

Testy TDD (String Calculator): 

```
bash scripts/test_tdd.sh
```

Katalog src/ zawiera:

- **clean**: długa metoda do refaktoryzacji (ReportGenerator).
- **solid**: kalkulator zniżek z if/switch do przerobienia na strategię.
- **tdd**: StringCalculator z testami opartymi o asercje.
