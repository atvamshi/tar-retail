package com.myretail.retail.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Project: myretail-parent
 * Package: com.myretail.retail.mvc
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 10:04 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ItemsService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GetNamesFromExternalService getNamesFromExternalService;

    //    public PriceDetailsModel getItemsPrice() throws JSONException {
    public JSONObject getItemsPrice() throws JSONException {

        Set<String> jsonObject = getNamesFromExternalService.getNames();
        logger.info(jsonObject.toString());
        return null;
    }


}
