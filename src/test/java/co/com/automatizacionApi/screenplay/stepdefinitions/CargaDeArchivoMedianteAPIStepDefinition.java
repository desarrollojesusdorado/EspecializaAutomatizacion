package co.com.automatizacionApi.screenplay.stepdefinitions;

import co.com.automatizacionApi.screenplay.tasks.CargarArchivo;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class CargaDeArchivoMedianteAPIStepDefinition {

    @Cuando("el quiere realizar el consumo para cargar un archivo")
    public void elQuiereRealizarElConsumoParaCargarUnArchivo() {
        theActorInTheSpotlight().attemptsTo(CargarArchivo.medianteWs());
    }
    @Entonces("el verifica el mensaje {string}")
    public void elVerificaElMensaje(String mensajeEsperado) {
        theActorInTheSpotlight().should(seeThatResponse(response->
                response.body("message", equalTo(mensajeEsperado))));
    }
}
