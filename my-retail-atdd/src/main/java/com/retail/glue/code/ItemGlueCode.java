package com.retail.glue.code;

import com.retail.step.definitions.ItemStepDefs;
import cucumber.api.java8.En;
import org.junit.Assert;

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
public class ItemGlueCode implements En {

    private ItemStepDefs itemStepDefs;

    public ItemGlueCode(ItemStepDefs itemStepDefs) {
        this.itemStepDefs = itemStepDefs;
        Given("^The test passes$", () -> {
            Assert.assertTrue("A pass test ", true);
        });

        Given("^I consume the Get Item API with \"([^\"]*)\" and I would expect Item_Name as \"([^\"]*)\" and Item_Price is \"([^\"]*)\" and Item_Currency_Type is \"([^\"]*)\"$",
                (String itemID, String itemName, String itemPrice, String itemCurrencyType) -> {
                    Assert.assertTrue("Checking expected values for itemID: " + itemID +
                                    "itemName: " + itemName +
                                    "itemPrice: " + itemPrice +
                                    "itemCurrencyType: " + itemCurrencyType
                            , this.itemStepDefs.testOneItemGet(itemID, itemName, itemPrice, itemCurrencyType));

                });

        Given("^I update Item API with \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$",
                (String itemPrimaryKey, String itemID, String itemName, String itemPrice, String itemCurrencyType) -> {
                    Assert.assertTrue("Putting the Item details " +
                            "Item primary key in DB" + itemPrimaryKey +
                            "Item Id" + itemID +
                            "itemName: " + itemName +
                            "itemPrice: " + itemPrice +
                            "itemCurrencyType: " + itemCurrencyType, this.itemStepDefs.putItem(itemPrimaryKey, itemID, itemName, itemPrice, itemCurrencyType));
                });

        Then("^I expect the item id \"([^\"]*)\" is updated with Item_Name as \"([^\"]*)\" and Item_Price as \"([^\"]*)\" and Item_Currency_Type as \"([^\"]*)\"$",
                (String itemID, String itemName, String itemPrice, String itemCurrencyType) -> {
                    Assert.assertTrue("Checking expected values for itemID: " + itemID +
                                    "itemName: " + itemName +
                                    "itemPrice: " + itemPrice +
                                    "itemCurrencyType: " + itemCurrencyType
                            , this.itemStepDefs.testOneItemInGetAll(itemID, itemName, itemPrice, itemCurrencyType));
                });


    }
}
