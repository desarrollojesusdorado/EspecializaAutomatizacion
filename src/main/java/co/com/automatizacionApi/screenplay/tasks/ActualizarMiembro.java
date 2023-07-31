package co.com.automatizacionApi.screenplay.tasks;

import co.com.automatizacionApi.screenplay.model.builder.PersonaBuilder;
import co.com.automatizacionApi.screenplay.util.Constantes;
import co.com.automatizacionApi.screenplay.util.Utilidades;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.automatizacionApi.screenplay.util.Constantes.PATH_ACTUALIZAR_PERSONA;
import static co.com.automatizacionApi.screenplay.util.Utilidades.obtenerJson;

public class ActualizarMiembro implements Task {

    private PersonaBuilder personaBuilder;
    private int id;

    public ActualizarMiembro(PersonaBuilder personaBuilder, int id) {
        this.personaBuilder = personaBuilder;
        this.id = id;
    }

    public static ActualizarMiembro conDatosNuevos(PersonaBuilder personaBuilder, int id) {
        return Tasks.instrumented(ActualizarMiembro.class, personaBuilder, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(PATH_ACTUALIZAR_PERSONA).with(
                        peticion->peticion.auth().preemptive().basic("admin", "admin").when()
                                .contentType(ContentType.JSON).pathParam("id", id).body(obtenerJson(personaBuilder))));

        System.out.println(SerenityRest.lastResponse().asString());
    }
}
