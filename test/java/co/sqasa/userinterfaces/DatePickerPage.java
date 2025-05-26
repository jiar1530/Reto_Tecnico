package co.sqasa.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatepickerPage {

    public static final Target DATE_INPUT = Target.the("campo de fecha")
            .located(By.id("datepicker"));

    public static Target day(String day) {
        return Target.the("día del calendario")
                .located(By.xpath("//*[@id="datepicker"]" + day + "']"));

    }
}
