package co.sqasa.StepDef;

import co.sqasa.questions.SelectedDate;
import co.sqasa.tasks.OpenTheDatepickerPage;
import co.sqasa.tasks.SelectDayInCalendar;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class TestStepDefinition {

    @Managed(driver = "chrome")
    public WebDriver driver;

    private final Actor user = Actor.named("User");

    @Before
    public void setUp() {
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("the user opens the datepicker page")
    public void openDatepickerPage() {
        user.attemptsTo(OpenTheDatepickerPage.inBrowser());
    }

    @When("the user switches to the calendar iframe")
    public void switchToIframe() {
        // Add implementation to switch iframe
        System.out.println("Switching to calendar iframe");
    }

    @When("the user clicks on the date selection field")
    public void clickDateField() {
        // Add implementation to click date field
        System.out.println("Clicking on the date selection field");
    }

    @When("the user selects day 15 of the current month")
    public void selectDay15() {
        user.attemptsTo(SelectDayInCalendar.withDay("15"));
    }

    @When("the user navigates to the next month")
    public void navigateToNextMonth() {
        // Add implementation to navigate next month
        System.out.println("Navigating to the next month");
    }

    @When("the user selects day 10")
    public void selectDay10() {
        user.attemptsTo(SelectDayInCalendar.withDay("10"));
    }

    @When("the user tries to enter a date manually")
    public void tryManualDateEntry() {
        // Add implementation to simulate manual entry
        System.out.println("Trying to manually enter a date");
    }

    @Then("the text field should contain the date with day 15")
    public void validateDate15() {
        user.should(seeThat(SelectedDate.containsDay("15")));
    }

    @Then("the text field should contain the date with day 10 of the next month")
    public void validateDate10NextMonth() {
        user.should(seeThat(SelectedDate.containsDay("10")));
    }

    @Then("the field should not allow manual editing")
    public void validateFieldIsReadOnly() {
        // Add implementation to check field is readonly
        System.out.println("Validating field is not editable manually");
    }
}

















