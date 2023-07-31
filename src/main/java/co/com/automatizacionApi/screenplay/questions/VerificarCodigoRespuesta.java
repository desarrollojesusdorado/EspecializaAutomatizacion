package co.com.automatizacionApi.screenplay.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarCodigoRespuesta implements Question<Integer> {
    public static VerificarCodigoRespuesta paraElServicio() {
        return new VerificarCodigoRespuesta();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}
