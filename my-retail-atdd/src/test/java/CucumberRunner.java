import cucumber.api.CucumberOptions;
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
        features = {"classpath:features"},
        glue = {"classpath:hooks", "classpath:step/definitions"},
        plugin = {"pretty", "html:target/test-report",
                "json:target/cucumber.json",
                "junit:target/test-report/cucumber-junit-report.xml"},
        tags = "@PassTest"
)
public class CucumberRunner {
    //whoops just saw that if i can demonstrate it should be good. Thought of doing ATDD
    //Any one --> test Or demonstrate Or hostable app
}
