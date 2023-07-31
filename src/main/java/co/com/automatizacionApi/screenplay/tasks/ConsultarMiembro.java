package co.com.automatizacionApi.screenplay.tasks;

import co.com.automatizacionApi.screenplay.util.Constantes;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarMiembro implements Task {

    private int id;

    public ConsultarMiembro(int id) {
        this.id = id;
    }

    public static ConsultarMiembro registradoCon(int id) {
        return Tasks.instrumented(ConsultarMiembro.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource(Constantes.PATH_CONSULTAR_PERSONA).with(
                        peticion->peticion.auth().preemptive().basic("admin","admin").when()
                                .contentType(ContentType.JSON).pathParam("id",id)));
        System.out.println(SerenityRest.lastResponse().asString());
    }
}
