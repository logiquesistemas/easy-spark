package br.com.logique.easyspark.it;

import br.com.logique.easyspark.util.HttpRequest;
import br.com.logique.easyspark.util.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Test if controllers methods arguments works fine.
 *
 * Created by Gustavo on 26/04/2016.
 */
public class SparkArgumentsIT {

    public static String BASE_PATH;

    @BeforeClass
    public static void setUp() throws ExecutionException, InterruptedException {
        BASE_PATH = SparkSetup.getBaseBash();
    }

    @Test
    public void testeNoArguments() throws Exception {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendGet(BASE_PATH + "/argument/noarguments/");
        Assert.assertEquals("true", result.getResponseMsg());
    }

    @Test
    public void testeRequest() throws Exception {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendGet(BASE_PATH + "/argument/request/");
        Assert.assertEquals("true", result.getResponseMsg());
    }

    @Test
    public void testeResponse() throws Exception {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendGet(BASE_PATH + "/argument/response/");
        Assert.assertEquals("true", result.getResponseMsg());
    }

    @Test
    public void testeRequestResponse() throws Exception {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendGet(BASE_PATH + "/argument/requestresponse/");
        Assert.assertEquals("true", result.getResponseMsg());
    }

}