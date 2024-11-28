package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import utils.GestionarDescargaPDF;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LimpiarFolderDescarga implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            GestionarDescargaPDF.limpiarFolder();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static LimpiarFolderDescarga enLocal(){
        return instrumented(LimpiarFolderDescarga.class);
    }
}
