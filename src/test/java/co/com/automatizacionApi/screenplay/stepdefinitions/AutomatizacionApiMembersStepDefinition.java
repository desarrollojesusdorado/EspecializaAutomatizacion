package co.com.automatizacionApi.screenplay.stepdefinitions;

import co.com.automatizacionApi.screenplay.model.Persona;
import co.com.automatizacionApi.screenplay.model.builder.PersonaBuilder;
import co.com.automatizacionApi.screenplay.questions.VerificarCodigoRespuesta;
import co.com.automatizacionApi.screenplay.questions.VerificarDatosActualizados;
import co.com.automatizacionApi.screenplay.questions.VerificarEliminacion;
import co.com.automatizacionApi.screenplay.questions.VerificarInfoMiembro;
import co.com.automatizacionApi.screenplay.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;

import static co.com.automatizacionApi.screenplay.model.builder.PersonaBuilder.con;
import static co.com.automatizacionApi.screenplay.util.Constantes.URL_PAGINA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class AutomatizacionApiMembersStepDefinition {

    private EnvironmentVariables environmentVariables;
    @Dado("^que (.*) quiere registrar una persona en api members$")
    public void queJesusQuiereRegistrarUnaPersonaEnApiMembers(String actor) {

        String urlBaseServicio = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(URL_PAGINA);

        theActorCalled(actor)
                .whoCan(CallAnApi.at(urlBaseServicio));
    }
    @Cuando("el consume el servicio con nombre y genero de la persona")
    public void elConsumoElServicioConNombreYGeneroDeLaPersona(List<Persona> datosPersona) {
        theActorInTheSpotlight().attemptsTo(RegistrarPersona.enLaApi(con()
                .elNombre(datosPersona.get(0).getName())
                .yGenero(datosPersona.get(0).getGender())));
    }
    @Entonces("el verifica que la respuesta del servicio sea {int}")
    public void elVerificaQueLaRespuestaDelServicioSeaCodigoRespuesta(Integer codigoEsperado) {
        theActorInTheSpotlight().should(seeThat(VerificarCodigoRespuesta.paraElServicio(), equalTo(codigoEsperado)));
    }
    @Entonces("el verifica la informacion de la persona en el response")
    public void elVerificaLaInformacionDeLaPersonaEnElResponse() {
    }

    @Cuando("el realiza la consulta de un miembro con {int}")
    public void elRealizaLaConsultaDeUnMiembroCon(int id) {
        theActorInTheSpotlight().attemptsTo(ConsultarMiembro.registradoCon(id));
    }



    @Y("el verifica que el {string}  y {string} sean correctos")
    public void elVerificaQueElYSeanCorrectos(String name, String gender) {
        theActorInTheSpotlight().should(seeThat(VerificarInfoMiembro.enElResponseCon(name, gender)));
    }

    @Cuando("el actualiza los siguientes datos para el miembro con {int}")
    public void elActualizaLosSiguientesDatosParaElMiembro(int id, List<Persona> datosPersona) {
        theActorInTheSpotlight().attemptsTo(ActualizarMiembro.conDatosNuevos(con()
                .elNombre(datosPersona.get(0).getName())
                .yGenero(datosPersona.get(0).getGender()), id));
    }

    @Y("verifica que el mensaje del ws {string}")
    public void verificaQueElMensajeDelWs(String arg0) {
    }

    @Y("el verifica que la actualizacion sea correcta con los datos:")
    public void elVerificaQueLaActualizacionSeaCorrectaConLosDatos(List<Persona> datosPersona) {
        theActorInTheSpotlight().should(seeThat(VerificarDatosActualizados.paraElMiembro(datosPersona.get(0))));
    }

    @Cuando("el elimina al miembro del sistema")
    public void elEliminaAlMiembroDelSistema() {

        theActorInTheSpotlight().attemptsTo(EliminarMiembro.delSistema());
    }

    @Y("el verifica la eliminacion del miembro del sistema")
    public void elVerificaLaEliminacionDelMiembroDelSistema() {
        theActorInTheSpotlight().should(seeThat(VerificarEliminacion.enELResponse()));
    }
}
