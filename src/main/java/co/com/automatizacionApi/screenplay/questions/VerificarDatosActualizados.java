package co.com.automatizacionApi.screenplay.questions;

import co.com.automatizacionApi.screenplay.model.Persona;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificarDatosActualizados implements Question<Boolean> {

    private Persona persona;

    public VerificarDatosActualizados(Persona persona) {
        this.persona = persona;
    }

    public static VerificarDatosActualizados paraElMiembro(Persona persona) {
        return new VerificarDatosActualizados(persona);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return nameRespuesta()&&genderRespuesta();

    }
    public boolean nameRespuesta(){
        String nameResponse = SerenityRest.lastResponse().path("member.name").toString();
        return persona.getName().equals(nameResponse);
    }
    public boolean genderRespuesta(){
        String genderResponse = SerenityRest.lastResponse().path("member.gender").toString();
        return persona.getGender().equals(genderResponse);
    }


}
