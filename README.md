# Warsztaty Clean Code

Repo do ćwiczeń: Clean Code, SOLID, TDD 

Wymagania: Java 11+.

Clean Code demo: 

```
git switch clean-code-task
bash scripts/compile.sh
bash scripts/run_clean_code.sh
```

SOLID demo: 

```
git switch solid-task
bash scripts/compile.sh
bash scripts/run_solid.sh
```

Testy TDD (String Calculator): 

```
git switch tdd-task
bash scripts/compile.sh
bash scripts/test_tdd.sh
```

Katalog src/ zawiera:

- **clean**: długa metoda do refaktoryzacji (ReportGenerator).
- **solid**: kalkulator zniżek z if/switch do przerobienia na strategię.
- **tdd**: StringCalculator z testami opartymi o asercje.
