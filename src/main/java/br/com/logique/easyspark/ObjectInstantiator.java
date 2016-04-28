package br.com.logique.easyspark;

import spark.Request;

/**
 * Created by gustavo on 28/04/2016.
 */
public interface ObjectInstantiator {

    <T> T instantiate(Class<T> clazz, Request request);

}
