package co.sqasa.runners;



import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.runners;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.Cucumber.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features = "src/test/resources/features/test.feature",
        glue = "co.sqasa.StepDef",
        snippets = SnippetType.CAMELCASE
)
public class testRunner {
}
