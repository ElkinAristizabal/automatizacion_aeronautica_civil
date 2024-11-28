package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirPaginaWeb implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Open.browserOn().thePageNamed("environments.defaultURL.aerocivil")
        );
    }

    public static AbrirPaginaWeb paraComenzarEscenario(){
        return instrumented(AbrirPaginaWeb.class);
    }
}
