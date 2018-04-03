package com.retail.step.definitions;

import com.retail.Hooks;
import com.retail.utils.RestTemplateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

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
    private Logger logger = Logger.getLogger(this.getClass());

    {
        appProperties = Hooks.appProperties;
    }

    //
    public ItemStepDefs(RestTemplateUtils restTemplateUtils) {
        this.restTemplateUtils = restTemplateUtils;
    }

    public boolean testOneItemGet(String itemID, String itemName, String itemPrice, String itemCurrencyType) {
        appProperties = Hooks.appProperties;
        this.restTemplateUtils = restTemplateUtils;
        String expecItemName = null, expecItemPrice = null, expecItemCurrencyType = null;
        JSONObject jsonObject;
//        logger.info("Inside testOneItemGet");
        String appEndPoint = appProperties.getProperty("app.api.url") + "/" + itemID;
        try {
            String responseJson = restTemplateUtils.restClientGet(appEndPoint, null, "");
            jsonObject = new JSONObject(responseJson);
            expecItemName = jsonObject.getString("itemName");
            expecItemPrice = String.valueOf(jsonObject.getInt("itemPrice"));
            expecItemCurrencyType = jsonObject.getString("itemCurrencyType");
        } catch (Exception je) {
        }


        Assert.assertTrue("Checking itemName",
                StringUtils.isNotEmpty(expecItemName) ? expecItemName.equalsIgnoreCase(itemName) : "null".equalsIgnoreCase(itemName));
        Assert.assertTrue("Checking itemPrice",
                StringUtils.isNotEmpty(expecItemPrice) ? expecItemPrice.equalsIgnoreCase(itemPrice) : "null".equalsIgnoreCase(itemPrice));
        Assert.assertTrue("Checking itemCurrencyType",
                StringUtils.isNotEmpty(expecItemCurrencyType) ? expecItemCurrencyType.equalsIgnoreCase(itemCurrencyType) :
                        "null".equalsIgnoreCase(itemCurrencyType));

//        logger.info(jsonObject.toString());

        return true;
    }

}
