Feature: User registration

  Scenario: Register with valid credentials

    Given Open "https://stellarburgers.nomoreparties.site/"
    When Click "Account button" on "Constructor page"
    When Click "Register link" on "Login page"
    And Enter valid credentials on "Register page"
      | Name field     | example          |
      | Email field    | example@mail.xyz |
      | Password field | 123456           |
    And Click "Register button" on "Register page"
    Then Verify that page with url "https://stellarburgers.nomoreparties.site/login" is opened
