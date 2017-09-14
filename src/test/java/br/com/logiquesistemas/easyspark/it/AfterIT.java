package br.com.logiquesistemas.easyspark.it;

import br.com.logiquesistemas.easyspark.util.HttpRequest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by gustavo on 11/09/2017.
 */
public class AfterIT {

    public static String BASE_PATH;

    @BeforeClass
    public static void setUp() throws ExecutionException, InterruptedException {
        BASE_PATH = SparkSetup.getBaseBash();
        AfterTest.COUTING_CALL.set(0);
    }

    @Test
    public void simpleTestInterceptor() throws IOException {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.sendGet(BASE_PATH + "/interceptor/simple");
        Assert.assertTrue(AfterTest.COUTING_CALL.intValue() > 0);
    }

}
