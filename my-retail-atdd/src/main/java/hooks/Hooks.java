package hooks;

import cucumber.api.java.Before;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * Project: myretail-parent
 * Package: hooks
 * <p>
 * User: vthalapu
 * Date: 3/13/18
 * Time: 2:32 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class Hooks {
    public static Properties appProperties;
    public static Properties logProperties;
    private static boolean propertiesLoaded = false;
    private String appPropertiesLoc = "config/application.properties";
    private String log4JPropsLoc = "config/log4j.properties";

    @Before(order = 1)
    public void loadProperties() throws IOException {
        if (!propertiesLoaded) {
            loadAppProperties(this.appPropertiesLoc);
            log4JProperties(this.log4JPropsLoc);
            propertiesLoaded = true;

        }
    }

    public void loadAppProperties(String appPropertiesLoc) throws IOException {
        this.appPropertiesLoc = appPropertiesLoc;
        appProperties = new Properties();
        appProperties.load(new ClassPathResource(appPropertiesLoc.trim()).getInputStream());
    }

    public void log4JProperties(String log4JPropsLoc) throws IOException {
        this.log4JPropsLoc = log4JPropsLoc;
        PropertyConfigurator.configure(new ClassPathResource(log4JPropsLoc.trim()).getInputStream());

    }
}
