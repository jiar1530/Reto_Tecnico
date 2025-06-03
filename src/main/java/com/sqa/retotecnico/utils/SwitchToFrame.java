package com.sqa.retotecnico.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SwitchToFrame implements Task {
    private final String cssSelector;

    public SwitchToFrame(String cssSelector) {
        this.cssSelector = cssSelector;
    }

    public static SwitchToFrame byCss(String cssSelector) {
        return instrumented(SwitchToFrame.class, cssSelector);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement frame = driver.findElement(By.cssSelector(cssSelector));
        driver.switchTo().frame(frame);
    }

}
