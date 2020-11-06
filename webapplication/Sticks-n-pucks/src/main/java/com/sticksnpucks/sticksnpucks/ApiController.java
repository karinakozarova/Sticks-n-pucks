package com.sticksnpucks.sticksnpucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.*;

/**
 * Base actions to the API
 */
@RestController
public class ApiController {
    /**
     * Base URL for the API
     */
    public static final String BASE_APIURL = "http://localhost:9090";

    /**
     * Version of the API that is currently in use
     */
    public static final String API_VERSION = "v1";

    private static final String REQUEST_CONTENT_TYPE = "Content-Type";
    private static final String URL_ENCODED_FORM = "application/x-www-form-urlencoded";
    // to hide the default public constructor
    private ApiController() {
    }

    /**
     * Gets the url that is used for requests to the API
     * @return base url for the requests
     */
    public static String getBaseAPICallUrl() {
        return ApiController.BASE_APIURL + "/" + ApiController.API_VERSION;
    }

    /**
     * Get the results the API return when running a GET request
     * @param urlPath url as string
     * @return json result as string
     * @throws IOException when the data could not be read
     */
    public static String getAPIResult(String urlPath) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlPath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    /**
     * Delete request to the API
     * @param urlPath full url path for the request
     * @return status code
     */
    public static int deleteFromAPI(String urlPath) {
        return ApiController.doRequestAction("DELETE", urlPath);
    }

    /**
     * Put request to the API
     * @param urlPath full url path for the request
     * @return status code
     */
    public static int putToAPI(String urlPath) {
        return ApiController.doRequestAction("PUT", urlPath);
    }

    /**
     * Post request to the API
     * @param urlPath full url path for the request
     * @return status code
     */
    public static int postToAPI(String urlPath) {
        return ApiController.doRequestAction("POST", urlPath);
    }

    private static int doRequestAction(String actionName, String urlPath){
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(urlPath);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty(REQUEST_CONTENT_TYPE, URL_ENCODED_FORM);
            httpURLConnection.setRequestMethod(actionName);
            return httpURLConnection.getResponseCode();
        } catch (Exception exception) {
            return 404;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}