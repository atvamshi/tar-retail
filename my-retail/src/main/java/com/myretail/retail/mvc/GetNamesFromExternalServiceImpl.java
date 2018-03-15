package com.myretail.retail.mvc;

import com.myretail.constants.PropertiesBean;
import com.myretail.utils.RestTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashSet;
import java.util.Set;

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
@Service
public class GetNamesFromExternalServiceImpl implements GetNamesFromExternalService {

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    @Autowired
    private PropertiesBean propertiesBean;

    /**
     * @return
     * @throws JSONException
     */
    public Set<String> getNames() throws JSONException {

        Set<String> namesSet = new HashSet<>();

        JSONObject jsonFromExternalResources = getJsonFromExternalResources();
        String[] depthArray = propertiesBean.getExternalNameDepth().split(",");
        String keyJson = jsonFromExternalResources.toString();

        for (int jsonDepthItr = 0; jsonDepthItr < depthArray.length; jsonDepthItr++) {
            keyJson = restTemplateUtils.getKeyFromJsonObject(keyJson,
                    depthArray[jsonDepthItr].trim());
        }

        //Parsing to json array from string
        JSONArray jsonArrayItemNames = new JSONArray(keyJson);

        for (int itemItr = 0; itemItr < jsonArrayItemNames.length(); itemItr++) {
            JSONObject oneItemObject = jsonArrayItemNames.getJSONObject(itemItr);
            try {
                namesSet.add(oneItemObject.getString(propertiesBean.getExternalNameKey().trim()));
            } catch (Exception e) {
            }
        }

        return namesSet;
    }

    /**
     * @return
     * @throws JSONException
     */
    public JSONObject getJsonFromExternalResources() throws JSONException {

        Object stringJson = restTemplateUtils.restClientGet(propertiesBean.getExternalApiUrl(), null, "");
        if (stringJson instanceof Boolean) {
            throw new HttpClientErrorException(HttpStatus.PROCESSING, "Unable to process request in getJsonFromExternalResources");
        }
        return new JSONObject((String) stringJson);
    }


}
