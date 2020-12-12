Feature: Prueba Tecnica
  Scenario Outline: Shopping

    Given the user login in <page> with the <user> and <password>
    When the user add product to cart Suace Labs Backpack y Sauce Labs Fleece Jacket
    And go to cart
    And validate the products
    And remove the last product and click on the button checkout
    Then the user types <name> and <lastname> and clicks continue
    And assert the error message
    And types postal code and click continue
    Then the user clicks finish
    And assert the message
    Examples:
      | page | user | password | name | lastname |
      |https://www.saucedemo.com/|standard_user|secret_sauce|Abiran|Salas|