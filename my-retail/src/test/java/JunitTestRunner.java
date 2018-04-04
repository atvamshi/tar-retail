import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spring.tests.RetailAppControllerTest;
import spring.tests.TestClass;

/**
 * Project: myretail-parent
 * Package: PACKAGE_NAME
 * <p>
 * User: vthalapu
 * Date: 4/4/18
 * Time: 12:05 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({RetailAppControllerTest.class, TestClass.class})
public class JunitTestRunner {
}
