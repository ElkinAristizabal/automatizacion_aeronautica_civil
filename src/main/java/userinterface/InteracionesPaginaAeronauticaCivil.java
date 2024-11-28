package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class InteracionesPaginaAeronauticaCivil {
    public static final Target BOTON_TRANSPARENCIA = Target.the("boton productos y servicios")
            .locatedBy("//span[text()='Transparencia']");
    public static final Target BOTON_PLANEACION_PRESUPUESTO = Target.the("boton prestamos")
            .locatedBy("//div[contains(normalize-space(text()), '4. Planeación, Presupuesto e Informes')]");
    public static final Target BOTON_PLAN_ACCION = Target.the("boton prestamos auto")
            .locatedBy("//a[text()='4.3 Plan de  Acción']");
    public static final Target DIV_PLAN_ACCION = Target.the("boton prestamos auto")
            .locatedBy("//div[@class='chordion chordion2018']");
    public static final Target BTN_DOWNLOAD_PRESENTACION_CIUDADANA = Target.the("boton prestamos auto")
            .locatedBy("//a[contains(@download, 'Presentación a la Ciudadania.pdf')]//img");
}
