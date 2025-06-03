package com.sqa.retotecnico.task;

import com.sqa.retotecnico.ui.DatePickerPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class NavigateToNextMonth implements Task {
    public static NavigateToNextMonth now() {
        return instrumented(NavigateToNextMonth.class);
    }
    @Override
    @Step("{0} navigates to the next month in the datepicker")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DatePickerPageUI.DATEPICKER_NEXT_MONTH_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(DatePickerPageUI.DATEPICKER_NEXT_MONTH_BUTTON)
        );
    }

}
