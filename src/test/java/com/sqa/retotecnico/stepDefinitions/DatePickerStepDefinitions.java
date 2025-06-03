package com.sqa.retotecnico.stepDefinitions;

import com.sqa.retotecnico.task.ClickDateField;
import com.sqa.retotecnico.task.OpenTheDatepickerPage;
import com.sqa.retotecnico.task.SelectDay;
import com.sqa.retotecnico.ui.DatePickerPageUI;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.containsString;

public class DatePickerStepDefinitions {
    @Managed(driver = "chrome")
    public WebDriver driver;
    private final Actor user = Actor.named("User");

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
        theActorCalled("User").can(BrowseTheWeb.with(driver));
    }

    @Given ("the user opens the datepicker page")
    public void theuseropensthedatepickerpage() {
        theActorInTheSpotlight().wasAbleTo(OpenTheDatepickerPage.inBrowser());

    }
    @When("the user switches to the calendar iframe")
    public void switchToIframe() {
        System.out.println("Switching to calendar iframe");
    }

    @And("the user clicks on the date selection field")
    public void theUserClicksOnTheDateSelectionField() {
        theActorInTheSpotlight().attemptsTo(ClickDateField.now());
    }
    @And("the user selects day {int} of the current month")
    public void theUserSelectsDayOfTheCurrentMonth(Integer day) {
        theActorInTheSpotlight().attemptsTo(SelectDay.fromCurrentMonth(day));
    }

    @Then("the text field should contain the date with day {int}")

    public void theTextFieldShouldContainTheDateWithDay(int expectedDay) {
        user.should();
        seeThat("el campo de texto contiene el día correcto",
                Text.of(DatePickerPageUI.DATE_INPUT_FIELD).asString(),
                containsString(String.format("%02d", expectedDay))  // compara si contiene "15"

        );
    }

}
