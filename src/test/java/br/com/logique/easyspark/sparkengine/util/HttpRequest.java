package br.com.logique.easyspark.sparkengine.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Manage Http requests.
 *
 * Created by Gustavo on 26/04/2016.
 */
public class HttpRequest {

    private final String USER_AGENT = "Mozilla/5.0";

    /**
     * Send a HTTP GET request to URL.
     *
     * @param url utl to send request
     * @return response request result
     * @throws IOException case some failure in communication.
     */
    public Response sendGet(String url) throws IOException {
        return sendRequest(url, "GET");
    }

    /**
     * Send a HTTP request to URL.
     *
     * @param url    utl to send request
     * @param method HTTP verb: {GET, POST, PUT or DELETE}
     * @return response request result
     * @throws IOException case some failure in communication.
     */
    public Response sendRequest(String url, String method) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.connect();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return new Response(con.getResponseCode(), response.toString());
    }

}
