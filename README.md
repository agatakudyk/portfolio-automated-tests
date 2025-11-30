## Portfolio Testów Automatycznych – PrestaShop

## Opis projektu
Projekt służy do automatyzacji testów funkcjonalnych strony e-commerce PrestaShop (https://demo.prestashop.com/#/en/front). 
Zawiera testy w różnych podejściach:
- Selenium WebDriver (Java)
- Selenium + Page Object Pattern (POP)
- Selenide + Page Object Pattern
- Cucumber + Selenide
  
Celem projektu jest pokazanie praktycznych umiejętności w automatyzacji testów, stosowaniu dobrych praktyk programistycznych oraz użyciu narzędzi wspierających pracę testera.

## Struktura projektu
- src/test/java/selenium – testy w Selenium
- src/test/java/seleniumPageObject – testy w Selenium z Page Object Pattern
- src/test/java/selenidePageObject – testy w Selenide z Page Object Pattern
- src/test/java/cucumberSelenide/stepdefinitions – testy Cucumber
- src/test/java/config/ConfigReader.java – klasa do konfiguracji
- src/test/resources – plik konfiguracyjny
- src/test/assets/instructions – dokumentacja przypadków testowych
- stepdefinitions – kroki testów Cucumber
- build.gradle – konfiguracja projektu
- docker-compose.yaml – konfiguracja środowiska testowego
- .gitignore – pliki ignorowane przez Git
- README.md – opis projektu

## Technologie i narzędzia
- Język programowania: Java
- IDE: IntelliJ IDEA
- Frameworki testowe: Selenium WebDriver, Selenide, Cucumber, JUnit
- Zarządzanie projektem: Gradle
- Środowisko testowe: Docker
- Wzorce projektowe: Page Object Pattern
- Kontrola wersji: Git, GitHub
- Raportowanie wyników: Allure Report

## Zawartość testów
Testy funkcjonalne strony PrestaShop: logowanie, rejestracja, dodawanie produktów do koszyka, składanie zamówienia.
Pliki z instrukcjami i przypadkami testowymi dostępne w src/test/assets/instructions.
Testy pokrywają różne poziomy automatyzacji i techniki projektowania testów.

## Cel portfolio
Zaprezentowanie umiejętności w automatyzacji testów w różnych podejściach.
Praktyczne zastosowanie wzorców projektowych i narzędzi do testowania.
Dokumentacja testów i uporządkowana struktura projektu gotowa do wglądu rekrutera.