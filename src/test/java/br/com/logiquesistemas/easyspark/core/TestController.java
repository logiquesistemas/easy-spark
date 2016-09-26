package br.com.logiquesistemas.easyspark.core;

import br.com.logiquesistemas.easyspark.annotations.Controller;
import br.com.logiquesistemas.easyspark.annotations.Path;
import br.com.logiquesistemas.easyspark.util.InteractionsCounter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Gustavo on 29/04/2016.
 */
@Controller
public class TestController {

    private static InteractionsCounter interactionsCounter = new InteractionsCounter();

    public static boolean isInteracted() {
        return interactionsCounter.isInteracted();
    }

    public static void resetCounter() {
        interactionsCounter.resetCounter();
    }

    public String testIogi(IogiParameterTest iogiTest) {
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testIogi(Request request, IogiParameterTest iogiTest) {
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testIogi(Response response, IogiParameterTest iogiTest) {
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testIogi(Request request, Response response, IogiParameterTest iogiTest) {
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testPrimitiveStr(String paramStr) {
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testPrimitiveInt(int paramInt) {
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public String testPrimitiveDbl(double paramDbl) {
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

    public ModelAndView testModelViewReturn() {
        interactionsCounter.interact();
        Map<String, Object> attributes = new HashMap<>();
        return new ModelAndView(attributes, "teste.ftl");
    }

    @Path("testdynami/:paramStr/:paramInt")
    public String testDynamic(Request request, String paramStr, Response response, Integer paramInt) {
        interactionsCounter.interact();
        return UUID.randomUUID().toString();
    }

}
