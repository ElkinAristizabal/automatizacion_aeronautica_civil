package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import utils.GestionarDescargaPDF;

public class DescargaPDF implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return GestionarDescargaPDF.waitForDownload();
    }

    public static DescargaPDF enLocal() {
        return new DescargaPDF();
    }
}
