package br.com.logiquesistemas.easyspark.core;

import spark.Request;
import spark.Response;


/**
 * Created by gustavo on 11/09/2017.
 */
public interface Intercept {

    void intercept(Request request, Response response);

}
