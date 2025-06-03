package com.sqa.retotecnico.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        features = "src/test/resources/features/",
        tags = " @Scenario2",
        glue = "com.sqa.retotecnico.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class DatePickerRunner {
}
