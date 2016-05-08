package br.com.logique.easyspark.core;

import br.com.logique.easyspark.annotations.Path;
import br.com.logique.easyspark.util.InteractionsCounter;
import br.com.logique.easyspark.annotations.Controller;
import spark.Request;
import spark.Response;

import java.util.UUID;

/**
 * Created by Gustavo on 29/04/2016.
 */
@Controller
public class TestController {

    private static InteractionsCounter interactionsCounter = new InteractionsCounter();

    public String testIogi(IogiParameterTest iogiTest){
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testIogi(Request request, IogiParameterTest iogiTest){
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testIogi(Response response, IogiParameterTest iogiTest){
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testIogi(Request request, Response response, IogiParameterTest iogiTest){
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testPrimitiveStr(String paramStr){
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testPrimitiveInt(int paramInt){
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testPrimitiveDbl(double paramDbl){
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    @Path("testdynami/:paramStr/:paramInt")
    public String testDynamic(Request request, String paramStr, Response response, Integer paramInt){
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public static boolean isInteracted(){
        return interactionsCounter.isInteracted();
    }

    public static void resetCounter(){
        interactionsCounter.resetCounter();
    }

}
