package co.com.automatizacionWeb.screenplay.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/AgregarProductosFalabella.feature",
        tags = "@PruebaGeneral",
        glue = {"co.com.automatizacionWeb.screenplay.stepdefinitions", "co.com.automatizacionWeb.screenplay.util"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AgregarProductosFalabellaRunner {
}
