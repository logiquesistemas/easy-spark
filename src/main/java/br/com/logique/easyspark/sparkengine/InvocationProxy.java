package br.com.logique.easyspark.sparkengine;

import spark.Request;
import spark.Response;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by gustavo on 26/04/2016.
 */
public class InvocationProxy {

    private Class<?> controller;
    private Method method;

    public InvocationProxy(Class<?> controller, Method method) {
        this.controller = controller;
        this.method = method;
    }

    public Object execute(Request request, Response response){
        try {

            return method.invoke(getInstance(controller), request, response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object getInstance(Class<?> controller) throws IllegalAccessException, InstantiationException {
        return controller.newInstance();
    }

}
