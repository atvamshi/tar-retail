package com.myretail.post.construct;

import com.myretail.retail.mvc.PriceDetailsModel;
import com.myretail.retail.mvc.PriceDetailsRepo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: myretail-parent
 * Package: com.myretail.PostConstruct
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 11:14 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Component
public class LoadDataToDerby implements BeanFactoryAware {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private PriceDetailsRepo priceDetailsRepo;


//    public LoadDataToDerby(BeanFactory beanFactory){
//        this.beanFactory = beanFactory;
//    }

    @PostConstruct
    public void addDefaultDataToDerby() {
        PriceDetailsModel priceDetailsModel;
        List<PriceDetailsModel> priceDetailsModelList = new ArrayList<>();

        priceDetailsModel = beanFactory.getBean(PriceDetailsModel.class);
        priceDetailsModel.setItemId(15117729);
        priceDetailsModel.setItemName("TAC");
        priceDetailsModel.setItemPrice(2000f);
        priceDetailsModel.setItemCurrencyType("USD");
        priceDetailsModelList.add(priceDetailsModel);

        priceDetailsModel = beanFactory.getBean(PriceDetailsModel.class);
        priceDetailsModel.setItemId(13860428);
        priceDetailsModel.setItemName("The Big Lebowski (Blu-ray)");
        priceDetailsModel.setItemPrice(2000f);
        priceDetailsModel.setItemCurrencyType("USD");
        priceDetailsModelList.add(priceDetailsModel);


        priceDetailsModel = beanFactory.getBean(PriceDetailsModel.class);
        priceDetailsModel.setItemId(16483589);
        priceDetailsModel.setItemName("Movies");
        priceDetailsModel.setItemPrice(20);
        priceDetailsModel.setItemCurrencyType("USD");
        priceDetailsModelList.add(priceDetailsModel);

        priceDetailsModel = beanFactory.getBean(PriceDetailsModel.class);
        priceDetailsModel.setItemId(16696652);
        priceDetailsModel.setItemName("Beats Solo 2 Wireless - Black");
        priceDetailsModel.setItemPrice(9000f);
        priceDetailsModel.setItemCurrencyType("USD");
        priceDetailsModelList.add(priceDetailsModel);

        priceDetailsModel = beanFactory.getBean(PriceDetailsModel.class);
        priceDetailsModel.setItemId(16752456);
        priceDetailsModel.setItemName("TV");
        priceDetailsModel.setItemPrice(9000f);
        priceDetailsModel.setItemCurrencyType("USD");
        priceDetailsModelList.add(priceDetailsModel);

        priceDetailsModel = beanFactory.getBean(PriceDetailsModel.class);
        priceDetailsModel.setItemId(15643793);
        priceDetailsModel.setItemName("TV");
        priceDetailsModel.setItemPrice(9000f);
        priceDetailsModel.setItemCurrencyType("USD");
        priceDetailsModelList.add(priceDetailsModel);

        priceDetailsRepo.saveAll(priceDetailsModelList);

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
