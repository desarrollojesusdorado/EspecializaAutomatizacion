package co.com.automatizacionApi.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static co.com.automatizacionApi.screenplay.util.Utilidades.convertirJsonMap;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerificarInfoMiembro implements Question<Boolean> {

    private final String name;
    private final String gender;

    private Map jsonConvertido;

    public VerificarInfoMiembro(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }


    public static VerificarInfoMiembro enElResponseCon(String name, String gender) {
        return new VerificarInfoMiembro(name, gender);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        jsonConvertido = convertirJsonMap(lastResponse().getBody().prettyPrint());

        return verificarDatosMiembro();
    }
    private boolean verificarDatosMiembro() {
        return name.equals(jsonConvertido.get("name"))
                && gender.equals(jsonConvertido.get("gender"));
    }

}
