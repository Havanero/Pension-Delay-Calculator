$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/calc/pension_delay_calculator.feature");
formatter.feature({
  "id": "pension-delay-calculator",
  "description": "In order to make the right contribution\nAs a user\nI want to to choose the time period to delay my pension",
  "name": "Pension Delay Calculator",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 4945724754,
  "status": "passed"
});
formatter.scenario({
  "id": "pension-delay-calculator;calculate-the-cost-of-delaying-starting-a-pension",
  "description": "",
  "name": "Calculate the cost of delaying starting a pension",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "That I click on pension delay calculator link",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "I was born in the year 1980",
  "keyword": "Given ",
  "line": 8
});
formatter.step({
  "name": "My retirement age is 70",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "My Annual salary before tax is 50000",
  "keyword": "And ",
  "line": 10
});
formatter.step({
  "name": "My gross pension contribution is 100  a \u003cselection\u003e:",
  "keyword": "And ",
  "line": 11,
  "rows": [
    {
      "cells": [
        "Monthly"
      ],
      "line": 12
    },
    {
      "cells": [
        "Yearly"
      ],
      "line": 13
    }
  ]
});
formatter.step({
  "name": "Tax relief from the taxman will be 40",
  "keyword": "Then ",
  "line": 14
});
formatter.step({
  "name": "My contribution will be 60",
  "keyword": "And ",
  "line": 15
});
formatter.step({
  "name": "I delay starting my pension by 4 years",
  "keyword": "When ",
  "line": 16
});
formatter.step({
  "name": "My total pension pot could be 23",
  "keyword": "Then ",
  "line": 17
});
formatter.step({
  "name": "Annual pension in real terms",
  "keyword": "And ",
  "line": 18
});
formatter.step({
  "name": "My total delayed pension pot could be",
  "keyword": "And ",
  "line": 19
});
formatter.step({
  "name": "Delayed annual pension in real terms",
  "keyword": "And ",
  "line": 20
});
formatter.match({
  "location": "pension_delay_calculator.That_I_click_on_pension_delay_calculator_link()"
});
formatter.result({
  "duration": 3963902576,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1980",
      "offset": 23
    }
  ],
  "location": "pension_delay_calculator.I_was_born_in_the_year(int)"
});
formatter.result({
  "duration": 102503223,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "70",
      "offset": 21
    }
  ],
  "location": "pension_delay_calculator.My_retirement_age_is(int)"
});
formatter.result({
  "duration": 104779063,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "50000",
      "offset": 31
    }
  ],
  "location": "pension_delay_calculator.My_Annual_salary_before_tax_is(int)"
});
formatter.result({
  "duration": 93081181,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 33
    }
  ],
  "location": "pension_delay_calculator.My_gross_pension_contribution_is_a_selection(int,String\u003e)"
});
formatter.result({
  "duration": 1038565477,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "40",
      "offset": 35
    }
  ],
  "location": "pension_delay_calculator.Tax_relief_from_the_taxman_will_be(int)"
});
formatter.result({
  "duration": 52849634,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "60",
      "offset": 24
    }
  ],
  "location": "pension_delay_calculator.My_contribution_will_be(int)"
});
formatter.result({
  "duration": 37609273,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 31
    }
  ],
  "location": "pension_delay_calculator.I_delay_starting_my_pension_by_years(int)"
});
formatter.result({
  "duration": 45544233,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "23",
      "offset": 30
    }
  ],
  "location": "pension_delay_calculator.My_total_pension_pot_could_be(int)"
});
formatter.result({
  "duration": 38405549,
  "status": "passed"
});
formatter.match({
  "location": "pension_delay_calculator.Annual_pension_in_real_terms()"
});
formatter.result({
  "duration": 47385074,
  "status": "passed"
});
formatter.match({
  "location": "pension_delay_calculator.My_total_delayed_pension_pot_could_be()"
});
formatter.result({
  "duration": 31380505,
  "status": "passed"
});
formatter.match({
  "location": "pension_delay_calculator.Delayed_annual_pension_in_real_terms()"
});
formatter.result({
  "duration": 44714782,
  "status": "passed"
});
formatter.after({
  "duration": 79068510,
  "status": "passed"
});
});