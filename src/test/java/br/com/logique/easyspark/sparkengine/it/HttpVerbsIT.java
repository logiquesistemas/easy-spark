package br.com.logique.easyspark.sparkengine.it;

import br.com.logique.easyspark.sparkengine.util.HttpRequest;
import br.com.logique.easyspark.sparkengine.util.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Test all HTTP verbs.
 * Created by Gustavo on 26/04/2016.
 */
public class HttpVerbsIT {

    public static String BASE_PATH;

    @BeforeClass
    public static void setUp() throws ExecutionException, InterruptedException {
        BASE_PATH = SparkSetup.getBaseBash();
    }

    @Test
    public void testGet() throws IOException {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendGet(BASE_PATH + "/httpverbs/");
        Assert.assertEquals("true", result.getResponseMsg());
    }

    @Test
    public void testPost() throws IOException {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendRequest(BASE_PATH + "/httpverbs/", "POST");
        Assert.assertEquals("true", result.getResponseMsg());
    }

    @Test
    public void testPut() throws IOException {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendRequest(BASE_PATH + "/httpverbs/", "PUT");
        Assert.assertEquals("true", result.getResponseMsg());
    }

    @Test
    public void testDelete() throws IOException {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendRequest(BASE_PATH + "/httpverbs/", "DELETE");
        Assert.assertEquals("true", result.getResponseMsg());
    }

}
