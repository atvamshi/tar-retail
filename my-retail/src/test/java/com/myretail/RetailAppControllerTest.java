package com.myretail;

import com.myretail.retail.mvc.ItemsService;
import com.myretail.retail.mvc.PriceDetailsModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: myretail-parent
 * Package: PACKAGE_NAME
 * <p>
 * User: vthalapu
 * Date: 4/4/18
 * Time: 11:28 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */

//@WebMvcTest(value = RetailAppController.class, secure = false)
//@ContextConfiguration(classes={App.class})

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:config/application-local.properties")
public class RetailAppControllerTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BeanFactory beanFactory;

    private ItemsService itemsService = Mockito.mock(ItemsService.class);

    //
    @Test
    public void testItemsService() throws Exception {
        logger.info("Testing testItemsService");

        List<PriceDetailsModel> priceDetailsModelList = null;

        //Case 1
        priceDetailsModelList = buildData(priceDetailsModelList, 2l, 13860428,
                "The Big Lebowski (Blu-ray)", 2000f,
                "USD");
        processAndVerify(priceDetailsModelList, 13860428);

        //Case 2
        priceDetailsModelList = buildData(priceDetailsModelList, 4l, 16696652,
                "Beats Solo 2 Wireless - Black", 9000,
                "USD");
        processAndVerify(priceDetailsModelList, 16696652);


    }

    public List<PriceDetailsModel> buildData(List<PriceDetailsModel> priceDetailsModelList,
                                             Long primaryKey, int itemId, String itemName, float itemPrice, String currency) {
        priceDetailsModelList = new ArrayList<>();
        PriceDetailsModel mockCourse = new PriceDetailsModel(primaryKey, itemId,
                itemName, itemPrice,
                currency);
        priceDetailsModelList.add(mockCourse);
        return priceDetailsModelList;
    }

    public void processAndVerify(List<PriceDetailsModel> priceDetailsModelList, int itemId) throws Exception {

        //        Mockito.anyInt()
        Mockito.doReturn(priceDetailsModelList).when(itemsService).getItemsPrice(itemId);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/myretail/items/" + itemId).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());
        String expected = "{\n" +
                "    \"itemPrimaryKey\": " + priceDetailsModelList.get(0).getItemPrimaryKey() + ",\n" +
                "    \"itemId\": " + priceDetailsModelList.get(0).getItemId() + ",\n" +
                "    \"itemName\": \"" + priceDetailsModelList.get(0).getItemName() + "\",\n" +
                "    \"itemPrice\": " + priceDetailsModelList.get(0).getItemPrice() + ",\n" +
                "    \"itemCurrencyType\": \"" + priceDetailsModelList.get(0).getItemCurrencyType() + "\"\n" +
                "}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }

}


//{
//        "itemPrimaryKey": 4,
//        "itemId": 16696652,
//        "itemName": "Beats Solo 2 Wireless - Black",
//        "itemPrice": 9000,
//        "itemCurrencyType": "USD"
//        }

//{
//        "itemPrimaryKey": 2,
//        "itemId": 13860428,
//        "itemName": "The Big Lebowski (Blu-ray)",
//        "itemPrice": 2000,
//        "itemCurrencyType": "USD"
//        }