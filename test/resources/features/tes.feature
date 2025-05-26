Feature: Date selection on calendar

  Scenario: Selecting day 15 of the current


    Given the user opens the datepicker page
    When the user switches to the calendar iframe
    And the user clicks on the date selection field
    And the user selects day 15 of the current month
    Then the text field should contain the date with day 15

  Scenario: Selecting day 10 of the next month
    Given the user opens the datepicker page
    When the user switches to the calendar iframe
    And the user clicks on the date selection field
    And the user navigates to the next month
    And the user selects day 10
    Then the text field should contain the date with day 10 of the next month

  Scenario: Validate blocked input field
    Given the user opens the datepicker page
    When the user tries to enter a date manually
    Then the field should not allow manual editing

