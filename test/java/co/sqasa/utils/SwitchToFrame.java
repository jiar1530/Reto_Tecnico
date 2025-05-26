package co.sqasa.utils;



import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SwitchToFrame {

    public static Task byCss(String cssSelector) {
        return Task.where("{0} cambia al iframe del calendario",
                actor -> {
                    WebDriver driver = net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight().abilityTo(BrowseTheWeb.class).getDriver();
                    WebElement frame = driver.findElement(By.cssSelector(cssSelector));
                    driver.switchTo().frame(frame);
                });
    }
}