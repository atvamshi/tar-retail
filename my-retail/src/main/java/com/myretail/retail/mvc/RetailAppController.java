package com.myretail.retail.mvc;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Project: myretail-parent
 * Package: com.myretail.retail.mvc
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 9:49 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "/myretail")
public class RetailAppController {

    @Autowired
    private ItemsService itemsService;

    @Validated
    @ResponseBody
    @RequestMapping(value = "/items/{itemId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getItemPriceInfo(@PathVariable Integer itemId) {
        JSONObject jsonObject;
        try {

            if (itemId.toString().length() == 0 || itemId <= 0) {
                return new ResponseEntity<>(new JSONObject("Invalid item id"), HttpStatus.BAD_REQUEST);
            } else {
                jsonObject = itemsService.getItemsPrice();
            }


        } catch (Exception e) {
            e.printStackTrace();

            if (e instanceof HttpClientErrorException) {
                return new ResponseEntity<>("Unable to process request due to -> " + ((HttpClientErrorException) e).getResponseBodyAsString()
                        , HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(new JSONPObject("status", "Unable to process request due to -> " +
                        e.getStackTrace())
                        , HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(jsonObject, HttpStatus.ACCEPTED);
    }


}
