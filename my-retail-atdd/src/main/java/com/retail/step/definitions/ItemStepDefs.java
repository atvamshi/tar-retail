package com.retail.step.definitions;

import com.retail.Hooks;
import com.retail.utils.RestTemplateUtils;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
public class ItemStepDefs {

    private Properties appProperties;
    private RestTemplateUtils restTemplateUtils;
//    private Logger logger = Logger.getLogger(this.getClass());

//    {
//        appProperties = Hooks.appProperties;
//    }
//
//    public ItemStepDefs(RestTemplateUtils restTemplateUtils) {
//        this.restTemplateUtils = restTemplateUtils;
//    }

    public boolean testOneItemGet(String itemID, String itemName, String itemPrice, String itemCurrencyType) {
        appProperties = Hooks.appProperties;
        this.restTemplateUtils = restTemplateUtils;


//        logger.info("Inside testOneItemGet");
        String appEndPoint = appProperties.getProperty("app.api.url");
        Map headersMap = new HashMap<>();
        headersMap.put("Content-Type", "application/json");
        HttpHeaders headers = restTemplateUtils.setHeaders(headersMap);

        String str = restTemplateUtils.restClientGet(appEndPoint, headers, "");
//        logger.info(str);

        return false;
    }

}
