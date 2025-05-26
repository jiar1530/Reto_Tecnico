package co.sqasa.tasks;


import co.sqasa.utils.SwitchToFrame;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheDatepickerPage {

    public static Task inBrowser() {
        return Task.where("{0} abre la página de datepicker",
                Open.url("https://jqueryui.com/datepicker/"),
                SwitchToFrame.byCss(".demo-frame")
        );
    }
}
