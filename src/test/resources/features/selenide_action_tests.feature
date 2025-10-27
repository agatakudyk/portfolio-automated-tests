Feature: Selenide POP Prestashop Test
  As a user
  I want to interact with products on the website
  So that I can add items to my cart

  Background:
    Given the website is opened at "http://localhost:8080/pl/"

  Scenario: Switch language into English
    When I click on the language dropdown in the header
    And I select "English" from the language list
    Then I should see that the language has been changed to English



