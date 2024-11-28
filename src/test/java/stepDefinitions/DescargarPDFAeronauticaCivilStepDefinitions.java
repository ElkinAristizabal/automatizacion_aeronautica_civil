package stepDefinitions;

import interactions.LimpiarFolderDescarga;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import interactions.AbrirPaginaWeb;
import questions.DescargaPDF;
import task.NavegarAPDF;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.equalTo;


public class DescargarPDFAeronauticaCivilStepDefinitions {

    private static final String actor = "Elkin Aristizabal";

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(actor);
    }

    @Dado("que el usuario esta en la pagina principal de Aeronautica civil")
    public void queElUsuarioEstaEnLaPaginaPrincipalDeAeronauticaCivil() {
        theActorCalled(actor).attemptsTo(AbrirPaginaWeb.paraComenzarEscenario());
    }
    @Cuando("el usuario navega hasta el pdf solicitado")
    public void elUsuarioNavegaHastaElPDFSolicitado() {
        theActorCalled(actor).attemptsTo(NavegarAPDF.paraDescargar());
    }

    @Entonces("valido que se pueda descargar correctamente el pdf de Presentación a la Ciudadania")
    public void validoQueSePuedaDescargarCorrectamenteElPdfDePresentacionALaCiudadania() {
        theActorCalled(actor).should(
                seeThat(
                        DescargaPDF.enLocal(), equalTo(true)
                )
        );
    }
    @After
    public void eliminarPDF(){
        theActorCalled(actor).attemptsTo(LimpiarFolderDescarga.enLocal());
    }

}
