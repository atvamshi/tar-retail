package com.myretail.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Project: myretail-parent
 * Package: com.myretail.utils
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 9:28 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Component
public class RestTemplateUtils {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    public synchronized String getKeyFromJsonObject(String jsonString, String jsonKey) throws JSONException {
        logger.info(jsonString);
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.getString(jsonKey);
    }

    public synchronized HttpHeaders setHeaders(Map<String, String> mapOfHeaders) {
        HttpHeaders httpHeaders = new HttpHeaders() {{
            setAll(mapOfHeaders);
        }};

        return httpHeaders;
    }

    public synchronized <T> T restClientPost(String restUrl, HttpHeaders httpHeaders, T tRequestBody) {
        return restClient(restUrl, httpHeaders, tRequestBody, "POST");
    }

    public synchronized <T> T restClientPut(String restUrl, HttpHeaders httpHeaders, T tRequestBody) {
        return restClient(restUrl, httpHeaders, tRequestBody, "PUT");
    }

    public synchronized <T> T restClientDelete(String restUrl, HttpHeaders httpHeaders, T tRequestBody) {
        return restClient(restUrl, httpHeaders, tRequestBody, "DELETE");
    }

    public synchronized <T> T restClientGet(String restUrl, HttpHeaders httpHeaders, T tRequestBody) {
        return restClient(restUrl, httpHeaders, tRequestBody, "GET");
    }


    /**
     *Some helper utils I created in the past to use rest client utils  -- by Vamsi
     * @param restUrl
     * @param httpHeaders
     * @param tRequestBody
     * @param methodName
     * @param <T>
     * @return
     */
    public synchronized <T> T restClient(String restUrl, HttpHeaders httpHeaders, T tRequestBody, String methodName) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ResponseEntity<String> response = null;
        HttpEntity<String> httpEntity = new HttpEntity<>((String) tRequestBody, httpHeaders);
        if (methodName.equals("PUT")) {
            response =
                    restTemplate.exchange(restUrl.trim(), HttpMethod.PUT, httpEntity, String.class);
        } else if (methodName.equals("GET")) {
            response =
                    restTemplate.exchange(restUrl.trim(), HttpMethod.GET, httpEntity, String.class);
        } else if (methodName.equals("POST")) {
            response =
                    restTemplate.exchange(restUrl.trim(), HttpMethod.POST, httpEntity, String.class);
        } else if (methodName.equals("DELETE")) {
            response =
                    restTemplate.exchange(restUrl.trim(), HttpMethod.DELETE, httpEntity, String.class);
        }

        if (response.getStatusCodeValue() >= 200 && response.getStatusCodeValue() < 300) {
            try {
                JSONObject jsonObject = new JSONObject(response.getBody());
                return (T) jsonObject.toString();
            } catch (NullPointerException ne) {
                return (T) "";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return (T) Boolean.valueOf("false");
    }
}
