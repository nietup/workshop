# Warsztaty Clean Code

Repo do ćwiczeń: Clean Code, SOLID, TDD 

Wymagania: Java 11+.

Zadanie Clean Code: 

```
git switch clean-code-task
bash scripts/compile.sh
java -cp out clean.LongMethodApp
```

Zadanie SOLID: 

```
git switch solid-task
bash scripts/compile.sh
java -cp out solid.DiscountApp
```

Zadanie TDD: 

```
git switch tdd-task
bash scripts/compile.sh

# Run tests:
mvn clean package

# Run application:
java -cp out tdd.StringCalculator
```
