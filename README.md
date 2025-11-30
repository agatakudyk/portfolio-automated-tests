## Portfolio Testów Automatycznych – sklep PrestaShop

## Opis projektu
Projekt automatyzuje testy funkcjonalne dla strony e-commerce PrestaShop ([demo.prestashop.com](https://demo.prestashop.com/#/en/front)). 
Zawiera testy w różnych podejściach:
- Selenium WebDriver
- Selenium + Page Object Pattern (POP)
- Selenide + Page Object Pattern
- Cucumber + Selenide

Celem projektu jest pokazanie praktycznych umiejętności w automatyzacji testów webowych, stosowanie dobrych praktyk programistycznych (np. POP, BDD) oraz wykorzystanie narzędzi wspierających pracę testera.

## Zakres testów
- Testy funkcjonalne strony PrestaShop: logowanie, rejestracja, dodawanie produktów do koszyka, składanie zamówienia
- Testy integracyjne różnych komponentów strony
- Testy automatyczne w różnych frameworkach i podejściach
- Wykorzystanie **Page Object Pattern** dla lepszej czytelności i utrzymania kodu

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
