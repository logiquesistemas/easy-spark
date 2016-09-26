package br.com.logiquesistemas.easyspark.it;

import br.com.logiquesistemas.easyspark.util.HttpRequest;
import br.com.logiquesistemas.easyspark.util.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Test if @Path works fine.
 *
 * Created by Gustavo on 26/04/2016.
 */
public class PathIT {

    public static String BASE_PATH;

    @BeforeClass
    public static void setUp() throws ExecutionException, InterruptedException {
        BASE_PATH = SparkSetup.getBaseBash();
    }

    @Test
    public void changePath() throws IOException {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendGet(BASE_PATH + "/basic/");
        Assert.assertEquals("true", result.getResponseMsg());
    }

    @Test
    public void dynamicPath() throws IOException {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendGet(BASE_PATH + "/path/basic/");
        Assert.assertEquals("true", result.getResponseMsg());
    }

}
