package com.myretail.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Project: myretail-parent
 * Package: com.myretail.constants
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 8:44 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class PropertiesBean {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.profiles.active}")
    private String springProfilesActive;

    @Value("${logging.file}")
    private String loggingFile;

    @Value("${logging.level.root}")
    private String loggingLevelRoot;

    @Value("${external.api.url}")
    private String externalApiUrl;



    //Showing my spring experience to configure initiation of beans
    @Bean
    public PropertiesBean getPropertiesBean(){
        return new PropertiesBean();
    }
}
