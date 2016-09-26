package br.com.logiquesistemas.easyspark.it;

import br.com.logiquesistemas.easyspark.util.HttpRequest;
import br.com.logiquesistemas.easyspark.util.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created by gustavo on 30/06/2016.
 */
public class SparkReturnsIT {

    public static String BASE_PATH;

    @BeforeClass
    public static void setUp() throws ExecutionException, InterruptedException {
        BASE_PATH = SparkSetup.getBaseBash();
    }

    @Test
    public void testModelAndView() throws Exception {
        HttpRequest httpRequest = new HttpRequest();
        Response result = httpRequest.sendGet(BASE_PATH + "/return/modelandview");
        Assert.assertNotNull("Não deve ser nulo", result.getResponseMsg());
    }

}
