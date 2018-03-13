package com.myretail.retail.mvc;

/**
 * Project: myretail-parent
 * Package: com.myretail.retail.mvc
 * <p>
 * User: vthalapu
 * Date: 3/13/18
 * Time: 8:19 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public interface DataBaseService {
    void saveItemInfo(Object object) throws Exception;

    void updateItemInfo(Object object) throws Exception;

    void deleteItemInfo(Object itemId) throws Exception;

    <T> T getAllItems() throws Exception;


}
