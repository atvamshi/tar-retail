package com.myretail.retail.mvc;

/**
 * Project: myretail-parent
 * Package: com.myretail.retail.mvc
 * <p>
 * User: vthalapu
 * Date: 3/13/18
 * Time: 8:17 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public interface GetNamesFromExternalService {

    <T> T getNames(Integer itemId) throws Exception;

    <T> T getJsonFromExternalResources(Integer itemId) throws Exception;
}
