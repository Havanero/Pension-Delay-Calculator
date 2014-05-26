Feature: Pension Delay Calculator
  In order to make the right contribution
  As a user
  I want to to choose the time period to delay my pension

  Scenario: Calculate the cost of delaying starting a pension
    Given That I click on pension delay calculator link
    Given I was born in the year 1980
    And My retirement age is 70
    And My Annual salary before tax is 50000
    And My gross pension contribution is 100  a <selection>:
    | Monthly     |
    | Yearly      |
    Then Tax relief from the taxman will be 40
    And  My contribution will be 60
    When I delay starting my pension by 4 years
    Then My total pension pot could be 23
    And  Annual pension in real terms
    And  My total delayed pension pot could be
    And  Delayed annual pension in real terms
