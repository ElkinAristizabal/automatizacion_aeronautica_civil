package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.InteracionesPaginaAeronauticaCivil.*;

public class NavegarAPDF implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_TRANSPARENCIA),
                Click.on(BOTON_PLANEACION_PRESUPUESTO),
                Click.on(BOTON_PLAN_ACCION),
                Click.on(DIV_PLAN_ACCION),
                Scroll.to(BTN_DOWNLOAD_PRESENTACION_CIUDADANA).then(Click.on(BTN_DOWNLOAD_PRESENTACION_CIUDADANA))

        );
    }

    public static NavegarAPDF paraDescargar(){
        return instrumented(NavegarAPDF.class);
    }
}
