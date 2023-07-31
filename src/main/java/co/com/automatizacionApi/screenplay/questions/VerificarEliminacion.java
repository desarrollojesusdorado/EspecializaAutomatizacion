package co.com.automatizacionApi.screenplay.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.List;

public class VerificarEliminacion implements Question<Boolean> {
    public static VerificarEliminacion enELResponse() {
        return new VerificarEliminacion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        Boolean validacion = null;

        int idMenber = Integer.parseInt(actor.recall("idMember"));

        List<Integer> listaIdMenbers = SerenityRest.lastResponse().path("members.id");

        validacion = !listaIdMenbers.contains(idMenber);

        return validacion;
    }
}
