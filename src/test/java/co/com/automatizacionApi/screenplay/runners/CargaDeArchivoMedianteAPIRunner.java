package co.com.automatizacionApi.screenplay.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/CargaArchivoEnApi.feature",
        tags = "@Prueba5",
        glue = {"co.com.automatizacionApi.screenplay.stepdefinitions",
                "co.com.automatizacionApi.screenplay.util"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CargaDeArchivoMedianteAPIRunner {
}
