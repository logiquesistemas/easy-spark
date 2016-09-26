package br.com.logiquesistemas.easyspark.core;

import com.thoughtworks.paranamer.AnnotationParanamer;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;

import java.lang.reflect.Method;

/**
 * Created by gustavo on 30/04/2016.
 */
public class DefaultParamNamesResolver implements ParamNamesResolver {

    private Paranamer info = new CachingParanamer(new AnnotationParanamer(new BytecodeReadingParanamer()));

    public String[] paramNames(Method method) {
        return info.lookupParameterNames(method);
    }

}
