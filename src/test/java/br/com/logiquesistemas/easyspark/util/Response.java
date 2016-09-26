package br.com.logiquesistemas.easyspark.util;

/**
 * DTO to save HTTP response.
 *
 * Created by Gustavo on 26/04/2016.
 */
public class Response {

    private int responseCode;

    private String responseMsg;

    public Response(int responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }
}
