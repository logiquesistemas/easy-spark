package br.com.logique.easyspark.core;

import java.lang.reflect.Method;

/**
 * Created by Gustavo on 28/04/2016.
 */
public interface PathResolver {

    /**
     * Generate URl path.
     *
     * @param controller Controller class
     * @param method Controller method
     * @return Http path
     */
    String resolvePath(Class<?> controller, Method method);


}
