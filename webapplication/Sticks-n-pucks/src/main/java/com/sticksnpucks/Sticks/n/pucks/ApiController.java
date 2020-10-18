package com.sticksnpucks.Sticks.n.pucks;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.*;

@RestController
public class ApiController {
    public static final String BASE_APIURL = "http://localhost:9090";
    public static final String API_VERSION = "v1";

    private static final String REQUEST_CONTENT_TYPE = "Content-Type";
    private static final String URL_ENCODED_FORM = "application/x-www-form-urlencoded";
    // to hide the default public constructor
    private ApiController() {
    }

    public static String getBaseAPICallUrl() {
        return ApiController.BASE_APIURL + "/" + ApiController.API_VERSION;
    }

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

    private static int doRequestAction(String actionName, String urlPath){
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(urlPath);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty(REQUEST_CONTENT_TYPE, URL_ENCODED_FORM);
            httpURLConnection.setRequestMethod(actionName);
            return httpURLConnection.getResponseCode();
        } catch (IOException exception) {
            return 404;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
    public static int deleteFromAPI(String urlPath) {
        return ApiController.doRequestAction("DELETE", urlPath);
    }

    public static int putToAPI(String urlPath) {
        return ApiController.doRequestAction("PUT", urlPath);
    }

    public static int postToAPI(String urlPath) {
        return ApiController.doRequestAction("POST", urlPath);
    }
}