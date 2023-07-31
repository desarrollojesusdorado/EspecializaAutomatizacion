package co.com.automatizacionApi.screenplay.tasks;

import co.com.automatizacionApi.screenplay.util.Constantes;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.io.File;

import static co.com.automatizacionApi.screenplay.util.Constantes.PATH_CARGA_ARCHIVO;

public class CargarArchivo implements Task {
    public static CargarArchivo medianteWs() {
        return Tasks.instrumented(CargarArchivo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String filePath = "src/test/resources/archivo/tamyiro.png";

        actor.attemptsTo(Post.to(PATH_CARGA_ARCHIVO).with(
                peticion->peticion.auth().basic("admin", "admin").when().that()
                        .multiPart("file", new File(filePath))
                        .multiPart("name", "archivoPrueba")
                        .contentType(ContentType.MULTIPART)
        ));
        SerenityRest.lastResponse().print();

    }
}
