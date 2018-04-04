package spring.tests;

import com.myretail.retail.mvc.ItemsService;
import com.myretail.retail.mvc.PriceDetailsModel;
import com.myretail.retail.mvc.RetailAppController;
import org.junit.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

@SpringBootTest
@WebMvcTest(value = RetailAppController.class, secure = false)
public class RetailAppControllerTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemsService itemsService;

//    priceDetailsModel = beanFactory.getBean(PriceDetailsModel.class);
//        priceDetailsModel.setItemId(13860428);
//        priceDetailsModel.setItemName("The Big Lebowski (Blu-ray)");
//        priceDetailsModel.setItemPrice(2000f);
//        priceDetailsModel.setItemCurrencyType("USD");
//        priceDetailsModelList.add(priceDetailsModel);

    @Test
    public void testItemsService() throws Exception {
        logger.info("Testing testItemsService");

        List<PriceDetailsModel> priceDetailsModelList = new ArrayList<>();
        PriceDetailsModel mockCourse = new PriceDetailsModel(1l, 13860428,
                "The Big Lebowski (Blu-ray)", 2000f,
                "USD");

        priceDetailsModelList.add(mockCourse);
        Mockito.when(
                itemsService.getItemsPrice(Mockito.anyInt())).thenReturn(priceDetailsModelList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/myretail/items/13860428").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\n" +
                "    \"itemPrimaryKey\": 4,\n" +
                "    \"itemId\": 16696652,\n" +
                "    \"itemName\": \"Beats Solo 2 Wireless - Black\",\n" +
                "    \"itemPrice\": 9000,\n" +
                "    \"itemCurrencyType\": \"USD\"\n" +
                "}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }


}
