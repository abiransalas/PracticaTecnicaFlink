import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/Features/PruebaTecnica.feature", glue = "Steps", plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:Reportes/reporte.html"})
public class RunTestPruebaTecnica extends AbstractTestNGCucumberTests {
}
