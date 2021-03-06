import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Project: myretail-parent
 * Package: PACKAGE_NAME
 * <p>
 * User: vthalapu
 * Date: 3/13/18
 * Time: 2:33 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/test-report",
                "json:target/cucumber.json",
                "junit:target/test-report/cucumber-junit-report.xml"},
        format = {"json:target/cucumber.json"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        features = {"src/main/resources/features"},
        tags = "@USTestRetail"
)
public class CucumberRunnerTest {
    // Runnable Cucumber class
}
