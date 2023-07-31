package co.com.automatizacionApi.screenplay.model.builder;

import co.com.automatizacionApi.screenplay.model.Persona;

public class PersonaBuilder {
    private String name;
    private String gender;

    public PersonaBuilder() {
        this.name = "";
        this.gender = "";
    }

    public static PersonaBuilder con() {
        return new PersonaBuilder();
    }

    public PersonaBuilder elNombre(String nombre) {
        this.name = nombre;
        return this;
    }

    public PersonaBuilder yGenero(String genero) {
        this.gender = genero;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }


}
