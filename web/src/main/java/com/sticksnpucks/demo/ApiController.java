package com.sticksnpucks.demo;

import java.io.*;
import java.net.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {
    public static final String BASE_APIURL = "http://localhost:9090";
    public static final String API_VERSION = "v1";

    // to hide the default public constructor
    private ApiController(){ }
    public static String GetBaseAPICallUrl(){
        return ApiController.BASE_APIURL + "/" + ApiController.API_VERSION;
    }

    public static String GetAPIResult(String urlPath) throws IOException {
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

    public static int deleteFromAPI(String urlPath){
        int code = 200;
        URL url = null;
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
            code = 404;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("DELETE");
            return httpURLConnection.getResponseCode();
        } catch (IOException exception) {
            exception.printStackTrace();
            code = 404;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return code;
    }

    public static int putToAPI(String urlPath){
        int code = 200;
        URL url = null;
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
            code = 404;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("PUT");
            code = httpURLConnection.getResponseCode();
        } catch (IOException exception) {
            exception.printStackTrace();
            code = 404;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return code;
    }

    public static int postToAPI(String urlPath){
        int code = 200;
        URL url = null;
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
            return 404;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("POST");
            code = httpURLConnection.getResponseCode();
        } catch (IOException exception) {
            exception.printStackTrace();
            return 404;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return code;
    }
}