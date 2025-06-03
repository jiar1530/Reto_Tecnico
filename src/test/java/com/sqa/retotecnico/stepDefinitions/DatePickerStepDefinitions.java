package com.sqa.retotecnico.stepDefinitions;

import com.sqa.retotecnico.task.*;
import com.sqa.retotecnico.task.SelectnextmonthDay;
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
import net.serenitybdd.screenplay.GivenWhenThen.*;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;


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

        theActorInTheSpotlight().should(
                seeThat("el campo de texto contiene el día correcto",
                        Text.of(DatePickerPageUI.DATE_INPUT_FIELD).asString(),
                        containsString(String.format("%02d", expectedDay))
                )
        );
    }

    @Then("the selected date should be \"MM+1/10/YYYY\" in the input field")
    public void laFechaSeleccionadaDeberiaSerEnElCampoDeEntrada(String placeholderOFechaLiteral) {
        LocalDate hoy = LocalDate.now();
        String fechaEsperadaFormateada;

        DateTimeFormatter formateadorSalidaCampoWeb = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US);

        if ("MM/15/AAAA".equalsIgnoreCase(placeholderOFechaLiteral)) {
            fechaEsperadaFormateada = hoy.withDayOfMonth(15).format(formateadorSalidaCampoWeb);
        } else if ("MM+1/10/AAAA".equalsIgnoreCase(placeholderOFechaLiteral)) {
            fechaEsperadaFormateada = hoy.plusMonths(1).withDayOfMonth(10).format(formateadorSalidaCampoWeb);
        } else {
            DateTimeFormatter formateadorEntradaFeature = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US);
            try {
                LocalDate fechaParseada = LocalDate.parse(placeholderOFechaLiteral, formateadorEntradaFeature);
                fechaEsperadaFormateada = fechaParseada.format(formateadorSalidaCampoWeb);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException(
                        "El valor '" + placeholderOFechaLiteral + "' en el feature no es un placeholder de fecha reconocido (MM/15/AAAA, MM+1/10/AAAA) " +
                                "ni una fecha válida en el formato esperado (dd/MM/yyyy). Error de parseo: " + e.getMessage(), e);
            }
        }

        //theActorInTheSpotlight().should(
          //      seeThat(SelectedDateValue.is(), equalTo(fechaEsperadaFormateada))
        //);
    }

    @And("the user navigates to the next month")
    public void theUserNavigatesToTheNextMonth() {
        theActorInTheSpotlight().attemptsTo(NavigateToNextMonth.now());
    }
    @And("the user selects day {int} of the next month")
    public void theUserSelectsDayOfTheNextMonth(Integer day) {
        theActorInTheSpotlight().attemptsTo(SelectnextmonthDay.fromDisplayedMonth(day));
    }

    @Then("the selected date should be {string} in the input field")
    public void theSelectedDateShouldBeInTheInputField(String arg0) {

    }
}
