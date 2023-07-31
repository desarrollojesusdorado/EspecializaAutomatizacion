package co.com.automatizacionApi.screenplay.tasks;

import co.com.automatizacionApi.screenplay.model.builder.PersonaBuilder;
import co.com.automatizacionApi.screenplay.util.Constantes;
import co.com.automatizacionApi.screenplay.util.Utilidades;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarPersona implements Task {

    private PersonaBuilder personaBuilder;

    public RegistrarPersona(PersonaBuilder personaBuilder) {
        this.personaBuilder = personaBuilder;
    }

    public static RegistrarPersona enLaApi(PersonaBuilder personaBuilder) {
        return Tasks.instrumented(RegistrarPersona.class, personaBuilder);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to(Constantes.PATH_REGISTRAR_PERSONA).with(
                request->request.auth().preemptive().basic("admin", "admin").when()
                        .contentType(ContentType.JSON)
                        .body(Utilidades.obtenerJson(personaBuilder))));

        actor.remember("idMember", SerenityRest.lastResponse().path("id").toString());

    }
}
