# language: en
Feature: Date selection on calendar

  Background:
    Given the user opens the datepicker page

  @Scenario1
  Scenario: Make an appointment
    When the user switches to the calendar iframe
    And the user clicks on the date selection field
    And the user selects day 15 of the current month
    Then the text field should contain the date with day 15

  @Scenario2
  Scenario: Select a date in the next month
    When the user switches to the calendar iframe
    And the user clicks on the date selection field
    And the user navigates to the next month
    And the user selects day 10 of the next month
    Then the selected date should be "MM+1/10/YYYY" in the input field