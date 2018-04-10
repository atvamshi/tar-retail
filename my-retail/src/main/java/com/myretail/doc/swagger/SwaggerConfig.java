package com.myretail.doc.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Project: myretail-parent
 * Package: com.myretail.doc.swagger
 * <p>
 * User: vthalapu
 * Date: 3/13/18
 * Time: 2:16 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 * http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
