# language: en
Feature: Date selection on calendar
  @DatePicker

  Scenario: Make an appointment
    Given the user opens the datepicker page
    When the user switches to the calendar iframe
    And the user clicks on the date selection field
    And the user selects day 15 of the current month
    Then the text field should contain the date with day 15