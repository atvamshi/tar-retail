package com.retail.step.definitions;

import com.retail.Hooks;
import com.retail.utils.RestTemplateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
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

        String expecItemName = null, expecItemPrice = null, expecItemCurrencyType = null;
        JSONObject jsonObject;
        logger.info("Inside testOneItemGet");
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
        return true;
    }

    public boolean testOneItemInGetAll(String itemID, String itemName, String itemPrice, String itemCurrencyType) {
        appProperties = Hooks.appProperties;

        String expecItemName = null, expecItemPrice = null, expecItemCurrencyType = null;
        JSONObject jsonObject;
        logger.info("Inside testOneItemGet");
        String appEndPoint = appProperties.getProperty("app.api.url");
        boolean allItemsFound = false;
        try {
            String responseJson = restTemplateUtils.restClientGet(appEndPoint, null, "");
            JSONArray jsonArray = new JSONArray(responseJson);

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                expecItemName = jsonObject.getString("itemName");
                expecItemPrice = String.valueOf(jsonObject.getInt("itemPrice"));
                expecItemCurrencyType = jsonObject.getString("itemCurrencyType");
                boolean testItemName = StringUtils.isNotEmpty(expecItemName) ? expecItemName.equalsIgnoreCase(itemName) : "null".equalsIgnoreCase(itemName);
                boolean testExpecItemPrice = StringUtils.isNotEmpty(expecItemPrice) ?
                        expecItemName.equalsIgnoreCase(itemName) : "null".equalsIgnoreCase(itemName);
                boolean testExpecItemCurrencyType = StringUtils.isNotEmpty(expecItemCurrencyType) ?
                        expecItemName.equalsIgnoreCase(itemName) : "null".equalsIgnoreCase(itemName);
                if (testItemName & testExpecItemPrice & testExpecItemCurrencyType) {
                    allItemsFound = true;
                    break;
                }
            }

        } catch (Exception je) {
            je.printStackTrace();
            return false;
        }

        Assert.assertTrue("Checking if all items were updates", allItemsFound);
        return true;
    }


    public boolean putItem(String primaryKey, String itemID, String itemName, String itemPrice, String itemCurrencyType) {
        logger.info("Inside putItem");

        appProperties = Hooks.appProperties;
        String appEndPoint = appProperties.getProperty("app.api.url");

        Map mapHeaders = new HashMap<>();
        mapHeaders.put("Content-Type", "application/json");
        HttpHeaders headers = restTemplateUtils.setHeaders(mapHeaders);

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("itemPrimaryKey", primaryKey);
            jsonObject.put("itemId", itemID);
            jsonObject.put("itemName", itemName);
            jsonObject.put("itemPrice", itemPrice);
            jsonObject.put("itemCurrencyType", itemCurrencyType);
            logger.info(jsonObject.toString());
            restTemplateUtils.restClientPut(appEndPoint, headers, jsonObject.toString());
        } catch (Exception je) {
            je.printStackTrace();
            return false;
        }
        return true;
    }

}
