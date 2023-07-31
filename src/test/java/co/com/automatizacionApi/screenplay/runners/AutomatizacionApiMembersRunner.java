package co.com.automatizacionApi.screenplay.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/AutomatizacionApiMembers.feature",
        tags = "@Prueba3",
        glue = {"co.com.automatizacionApi.screenplay.stepdefinitions",
                "co.com.automatizacionApi.screenplay.util",
                "co.com.automatizacionApi.screenplay.model"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AutomatizacionApiMembersRunner {
}
