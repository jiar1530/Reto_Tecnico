package com.sqa.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatePickerPageUI {
    public static final Target DATE_INPUT_FIELD = Target.the("Date input field")
            .located(By.id("datepicker"));

    public static final Target DATEPICKER_IFRAME = Target.the("Datepicker iframe")
            .located(By.xpath("//iframe[@class='demo-frame']"));

    public static final Target DATEPICKER_NEXT_MONTH_BUTTON = Target.the("Next month button")
            .located(By.xpath("//a[@data-handler='next']"));

    public static final Target DATEPICKER_PREVIOUS_MONTH_BUTTON = Target.the("Previous month button")
            .located(By.xpath("//a[@data-handler='prev']"));

    public static final Target SELECTED_DATE =
            Target.the("día seleccionado en el calendario")
                    .locatedBy("//div[@id='ui-datepicker-div']//table[@class='ui-datepicker-calendar']//a[text()='15']\"");

    // Dynamic target for a specific day in the currently displayed month
    public static Target dayInCalendar(int day) {
        return Target.the("Day " + day + " in calendar")
                .located(By.xpath("//div[@id='ui-datepicker-div']//table[@class='ui-datepicker-calendar']//a[text()='15']"));

    }

    public static final Target DATEPICKER_MONTH_YEAR_TITLE = Target.the("Datepicker month and year title")
            .located(By.className("ui-datepicker-title"));

}
