Feature: User login

  Scenario: Login as registered user

    Given Open "https://stellarburgers.nomoreparties.site/"
    When Click "Account button" on "Constructor page"
    And Enter valid credentials on "Login page"
      | Email field    | example@mail.xyz |
      | Password field | 123456           |
    And Click "Enter button" on "Login page"
    Then Verify that page with url "https://stellarburgers.nomoreparties.site/" is opened
    And Verify that "accessToken" in localStorage not null
