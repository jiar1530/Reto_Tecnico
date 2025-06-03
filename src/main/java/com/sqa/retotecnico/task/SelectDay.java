package com.sqa.retotecnico.task;

import com.sqa.retotecnico.ui.DatePickerPageUI;
import com.sqa.retotecnico.utils.EsperarXSegundos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectDay implements Task {
    public int day;

    public SelectDay(int day) {
        this.day = day;
    }

    public static SelectDay fromCurrentMonth(int day) {
        return instrumented(SelectDay.class, day);
    }

    public static SelectDay fromDisplayedMonth(int day) {
        // This is essentially the same as fromCurrentMonth,
        // as the target locates within the currently visible calendar.
        return instrumented(SelectDay.class, day);
    }

    @Override
    @Step("{0} selects day {1} from the displayed month")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DatePickerPageUI.dayInCalendar(day), isVisible()).forNoMoreThan(10).seconds(),
                EsperarXSegundos.por(5),
                Click.on(DatePickerPageUI.dayInCalendar(day))
        );
    }

}
