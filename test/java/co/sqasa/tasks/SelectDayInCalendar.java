package co.sqasa.tasks;

import co.sqasa.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDayInCalendar {

    public static Task withDay(String day) {
        return Task.where("{0} selecciona el día " + day,
                Click.on(DatepickerPage.DATE_INPUT),
                Click.on(DatepickerPage.day(day))
        );
    }
}
