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
//        glue = {"classpath:com/retail/hooks", "classpath:com/retail/step/definitions"
//                ,"classpath:com/retail/glue/code"},
//        glue = {"classpath:com/retail"},
        plugin = {"pretty", "html:target/test-report",
                "json:target/cucumber.json",
                "junit:target/test-report/cucumber-junit-report.xml"},
        features = {"classpath:features"},
        tags = "@TestGetOneItem"
)
public class CucumberRunner {
    // Runnable Cucumber class
}
