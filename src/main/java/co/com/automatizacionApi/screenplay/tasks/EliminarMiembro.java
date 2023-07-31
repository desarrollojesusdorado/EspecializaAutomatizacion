package co.com.automatizacionApi.screenplay.tasks;

import co.com.automatizacionApi.screenplay.util.Constantes;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.automatizacionApi.screenplay.util.Constantes.PATH_ELIMINAR_PERSONA;

public class EliminarMiembro implements Task {

    public static EliminarMiembro delSistema() {
        return Tasks.instrumented(EliminarMiembro.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        int idMenber = Integer.parseInt(actor.recall("idMember"));

        actor.attemptsTo(
                Delete.from(PATH_ELIMINAR_PERSONA+idMenber).with(
                        peticion->peticion.auth().preemptive().basic("admin", "admin").when()
                                .contentType(ContentType.JSON)));
    }
}
