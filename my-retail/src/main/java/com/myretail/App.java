package com.myretail;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Project: myretail-parent
 * Package: my.retail.app
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 8:19 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.myretail"})
public class App {

    static public void main(String...args){
        BeanFactory beanFactory = SpringApplication.run(App.class,args);
        beanFactory.getBean(WelcomeMessageBanner.class).printWelcomeBanner();
    }



}
