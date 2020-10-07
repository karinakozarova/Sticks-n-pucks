package com.sticksnpucks.demo;

import java.io.*;
import java.net.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {
    public static String baseAPIURL = "http://localhost:9090";
    public static String apiVersion = "v1";

    public static String GetBaseAPICallUrl(){
        return ApiController.baseAPIURL + "/" + ApiController.apiVersion;
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

    public static int DeleteFromAPI(String urlPath){
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
            return code;
        }
    }

    public static int PutToAPI(String urlPath){
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
            return code;
        }
    }

    public static int PostToAPI(String urlPath){
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
            httpURLConnection.setRequestMethod("POST");
            code = httpURLConnection.getResponseCode();
        } catch (IOException exception) {
            exception.printStackTrace();
            code = 404;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return code;
        }
    }
}