package com.myretail.retail.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PriceDetailsRepo priceDetailsRepo;

    @Autowired
    private GetNamesFromExternalService getNamesFromExternalService;

    //    public PriceDetailsModel getItemsPrice() throws JSONException {
    public List<PriceDetailsModel> getItemsPrice(Long itemId) throws JSONException {
        List<PriceDetailsModel> priceDetailsModelList = new ArrayList<>();
        Set<String> jsonObject = getNamesFromExternalService.getNames();
        logger.info(jsonObject.toString());
        try {
            for (String name : jsonObject) {
                if (priceDetailsRepo.findAllByItemNameAndItemId(name, itemId) != null) {
                    priceDetailsModelList.add(priceDetailsRepo.findAllByItemNameAndItemId(name, itemId));
                }
            }
        } catch (Exception e) {
            return null;
        }


//        findAllByItemName

        return priceDetailsModelList;
    }

    public void saveItemInfo(PriceDetailsModel priceDetailsModel) {
        priceDetailsRepo.save(priceDetailsModel);
    }

    public void updateItemInfo(PriceDetailsModel priceDetailsModel) {
        saveItemInfo(priceDetailsModel);
    }

    public void deleteItemInfo(Long itemId) {
        priceDetailsRepo.deleteAllByItemId(itemId);
    }

    public List<PriceDetailsModel> getAllItems() {
        return (List<PriceDetailsModel>) priceDetailsRepo.findAll();
    }


}
