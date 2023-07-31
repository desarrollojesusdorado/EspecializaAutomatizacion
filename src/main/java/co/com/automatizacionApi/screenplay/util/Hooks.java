package co.com.automatizacionApi.screenplay.util;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

/*    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }*/
    @Before
    public static void prepararEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }

}
