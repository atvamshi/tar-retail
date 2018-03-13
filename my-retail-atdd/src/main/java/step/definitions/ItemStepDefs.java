package step.definitions;

import cucumber.api.java8.En;
import org.junit.Assert;

/**
 * Project: myretail-parent
 * Package: PACKAGE_NAME
 * <p>
 * User: vthalapu
 * Date: 3/13/18
 * Time: 2:37 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class ItemStepDefs implements En {

    public ItemStepDefs() {
        Given("^The test passes$", () -> {
            Assert.assertTrue("A pass test ", true);
        });
    }
}
