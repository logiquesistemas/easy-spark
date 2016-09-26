package br.com.logiquesistemas.easyspark.core;

import spark.Request;

import java.lang.reflect.Parameter;

/**
 * Created by gustavo on 28/04/2016.
 */
public interface ObjectMaker {

    Object resolveParameter(String paramName, Parameter parameter, Request request);

}
