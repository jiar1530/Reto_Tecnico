package co.sqasa.questions;

import co.sqasa.userinterfaces.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SelectedDate {

    public static Question<Boolean> containsDay(String day) {
        return actor -> DatepickerPage.DATE_INPUT.resolveFor(actor).getValue().contains(day);
    }
}