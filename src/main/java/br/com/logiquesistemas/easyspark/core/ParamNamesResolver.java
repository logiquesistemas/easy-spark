package br.com.logiquesistemas.easyspark.core;

import java.lang.reflect.Method;

/**
 * Created by gustavo on 30/04/2016.
 */
public interface ParamNamesResolver {

    String[] paramNames(Method method);

}
