package com.sqa.retotecnico.task;

import com.sqa.retotecnico.ui.DatePickerPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickDateField implements Task{
    public static Performable now() {
        return instrumented(ClickDateField.class);
    }

    @Override
    @Step("{0} clicks on the date input field")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DatePickerPageUI.DATE_INPUT_FIELD)
        );
    }

}
