package com.myretail.retail.mvc;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Project: myretail-parent
 * Package: com.myretail.retail.mvc
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 9:56 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public interface PriceDetailsRepo extends CrudRepository<PriceDetailsModel, Long> {

    PriceDetailsModel findAllByItemNameAndItemId(String itemName, Long itemId);

    @Transactional
    @Modifying
    void deleteByItemId(Long itemId);

}
