//package com.myretail;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * Project: myretail-parent
// * Package: PACKAGE_NAME
// * <p>
// * User: vthalapu
// * Date: 4/4/18
// * Time: 11:28 AM
// * <p>
// * Created with IntelliJ IDEA
// * To change this template use File | Settings | File Templates.
// */
//
////@WebMvcTest(value = RetailAppController.class, secure = false)
////@ContextConfiguration(classes={App.class})
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@TestPropertySource(
//        locations = "classpath:config/application-local.properties")
//public class RetailAppControllerTest {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
////    @Autowired
////    private MockMvc mockMvc;
////
////    @MockBean
////    private ItemsService itemsService;
////
////    @MockBean
////    private DataBaseService dataBaseService;
////
////    @Test
////    public void testItemsService() throws Exception {
////        logger.info("Testing testItemsService");
////
////        List<PriceDetailsModel> priceDetailsModelList = new ArrayList<>();
////        PriceDetailsModel mockCourse = new PriceDetailsModel(1l, 13860428,
////                "The Big Lebowski (Blu-ray)", 2000f,
////                "USD");
////
////        priceDetailsModelList.add(mockCourse);
////        Mockito.when(
////                itemsService.getItemsPrice(Mockito.anyInt())).thenReturn(priceDetailsModelList);
////
////        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
////                "/myretail/items/13860428").accept(
////                MediaType.APPLICATION_JSON);
////
////        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////
////        System.out.println(result.getResponse());
////        String expected = "{\n" +
////                "    \"itemPrimaryKey\": 4,\n" +
////                "    \"itemId\": 16696652,\n" +
////                "    \"itemName\": \"Beats Solo 2 Wireless - Black\",\n" +
////                "    \"itemPrice\": 9000,\n" +
////                "    \"itemCurrencyType\": \"USD\"\n" +
////                "}";
////
////        JSONAssert.assertEquals(expected, result.getResponse()
////                .getContentAsString(), false);
////    }
//
//
//    @Test
//    public void test()
//    {
//        logger.info("Test");
//    }
//
//}
