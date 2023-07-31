package co.com.automatizacionApi.screenplay.model;

import co.com.automatizacionApi.screenplay.model.builder.PersonaBuilder;

public class Persona{
        private final String name;
        private final String gender;

    public Persona(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Persona(PersonaBuilder personaBuilder) {
            this.name = personaBuilder.getName();
            this.gender = personaBuilder.getGender();
    }

    public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }
}
