package com.myretail;

import com.myretail.constants.PropertiesBean;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project: myretail-parent
 * Package: my.retail.app
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 8:25 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */

@Component
@NoArgsConstructor
public class WelcomeMessageBanner {


    @Autowired
    private PropertiesBean propertiesBean;

    public WelcomeMessageBanner(PropertiesBean propertiesBean){
        this.propertiesBean = propertiesBean;
    }


    public void printWelcomeBanner(){
        System.out.println("***********************************************************************");
        System.out.println(" __  __       ____      _        _ _    _                ");
        System.out.println("|  \\/  |_   _|  _ \\ ___| |_ __ _(_) |  / \\   _ __  _ __  ");
        System.out.println("| |\\/| | | | | |_) / _ \\ __/ _` | | | / _ \\ | '_ \\| '_ \\ ");
        System.out.println("| |  | | |_| |  _ <  __/ || (_| | | |/ ___ \\| |_) | |_) |");
        System.out.println("|_|  |_|\\__, |_| \\_\\___|\\__\\__,_|_|_/_/   \\_\\ .__/| .__/ ");
        System.out.println("       |___/                               |_|   |_|    ");
        System.out.println("==>>");
        printAppProperties();
        System.out.println("***********************************************************************");

    }


    public void printAppProperties(){
        System.out.println("Server port             -> "+ propertiesBean.getServerPort());
        System.out.println("Spring active profile   -> "+ propertiesBean.getSpringProfilesActive());
        System.out.println("Log file name           -> "+ propertiesBean.getLoggingFile());
        System.out.println("Log Root Status         -> "+ propertiesBean.getLoggingLevelRoot());
        System.out.println("External Api URL        -> "+ propertiesBean.getExternalApiUrl());
    }
}
