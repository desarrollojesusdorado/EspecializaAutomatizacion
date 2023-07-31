package co.com.automatizacionApi.screenplay.model;

import io.cucumber.java.DataTableType;

import java.util.Map;

public class PersonaTable {
    @DataTableType
    public Persona infoPersona(Map<String, String> data){
        return new Persona(
                data.get("name"),
                data.get("gender"));
    }
}
