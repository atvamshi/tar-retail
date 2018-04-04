package spring.tests;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Project: myretail-parent
 * Package: spring.tests
 * <p>
 * User: vthalapu
 * Date: 4/4/18
 * Time: 12:02 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
public class TestClass {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void contextLoads() {
        logger.info("A sample spring test part of test suite");
    }
}
