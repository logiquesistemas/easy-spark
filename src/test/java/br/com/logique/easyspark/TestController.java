package br.com.logique.easyspark;

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

    public static boolean isInteracted(){
        return interactionsCounter.isInteracted();
    }

    public static void resetCounter(){
        interactionsCounter.resetCounter();
    }

}