package com.sqa.retotecnico.task;

import com.sqa.retotecnico.utils.SwitchToFrame;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTheDatepickerPage {
    public static Task inBrowser() {
        return Task.where("{0} abre la página de datepicker",
                Open.url("https://jqueryui.com/datepicker/"),
                SwitchToFrame.byCss("#content > iframe")
        );
    }
}
