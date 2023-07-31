package co.com.automatizacionApi.screenplay.tasks;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class Eliminar implements Task {

    private int id;

    public Eliminar(int id) {
        this.id = id;
    }

    public static Eliminar elUsuario(int id) {
        return Tasks.instrumented(Eliminar.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Delete.from("/api/members/"+id).with(
                request->request.auth().preemptive()
                        .basic("admin","admin")
                        .contentType(ContentType.JSON)
        ));
        System.out.println(SerenityRest.lastResponse().asString());
    }
}
