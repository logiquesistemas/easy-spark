package br.com.logiquesistemas.easyspark.it;

import br.com.logiquesistemas.easyspark.annotations.After;
import br.com.logiquesistemas.easyspark.annotations.Before;
import br.com.logiquesistemas.easyspark.core.Intercept;
import spark.Request;
import spark.Response;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gustavo on 11/09/2017.
 */
@After
public class AfterTest implements Intercept {

    public static AtomicInteger COUTING_CALL = new AtomicInteger();

    @Override
    public void intercept(Request request, Response response) {
        System.out.println("CHAMOU INTERCEPTOR");
        COUTING_CALL.incrementAndGet();
    }

}
