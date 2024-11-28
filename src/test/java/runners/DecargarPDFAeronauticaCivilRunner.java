package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/descargar_pdf_aeronautica_civil.feature",
        glue = {"stepDefinitions"},
        snippets = CAMELCASE
)
public class DecargarPDFAeronauticaCivilRunner {
}