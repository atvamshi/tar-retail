package com.myretail.retail.mvc;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private DataBaseService dataBaseService;

    @Validated
    @ResponseBody
    @RequestMapping(value = "/items/{itemId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getItemPriceInfo(@PathVariable Integer itemId) {

        List<PriceDetailsModel> priceDetailsModel;

        try {

            if (itemId <= 0) {
                return new ResponseEntity<>(new JSONObject("Invalid item id"), HttpStatus.BAD_REQUEST);
            } else {
                priceDetailsModel = itemsService.getItemsPrice(itemId);
            }

        } catch (Exception e) {
            e.printStackTrace();

            if (e instanceof HttpClientErrorException) {
                return new ResponseEntity<>("Unable to process request due to -> " + ((HttpClientErrorException) e).getResponseBodyAsString()
                        , HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(new JSONPObject("status", "Unable to process request due to -> " +
                        e.getLocalizedMessage())
                        , HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (priceDetailsModel == null || priceDetailsModel.size() == 0) {
            return new ResponseEntity<>("No data found for the searched id", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(priceDetailsModel, HttpStatus.ACCEPTED);
    }


    @Validated
    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Object> addItemToDb(@RequestBody PriceDetailsModel priceDetailsModel) {
        try {
            dataBaseService.saveItemInfo(priceDetailsModel);
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

        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @Validated
    @ResponseBody
    @RequestMapping(value = "/items/{itemId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteItemInDb(@PathVariable Integer itemId) {
        try {
            if (itemId <= 0) {
                return new ResponseEntity<>(new JSONObject("Invalid item id"), HttpStatus.BAD_REQUEST);
            }

            dataBaseService.deleteItemInfo(itemId);
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

        return new ResponseEntity<>("Item deleted or Not Available", HttpStatus.ACCEPTED);
    }

    @Validated
    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Object> updateItemInDb(@RequestBody PriceDetailsModel priceDetailsModel) {
        try {
            dataBaseService.updateItemInfo(priceDetailsModel);
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

        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }


    @Validated
    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllItems() {

        try {
            return new ResponseEntity<>((List<PriceDetailsModel>) dataBaseService.getAllItems(), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            e.printStackTrace();

            if (e instanceof HttpClientErrorException) {
                return new ResponseEntity<>("Unable to process request due to -> " + ((HttpClientErrorException) e).getResponseBodyAsString()
                        , HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(new JSONPObject("status", "Unable to process request due to -> " +
                        e.getLocalizedMessage())
                        , HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

}
