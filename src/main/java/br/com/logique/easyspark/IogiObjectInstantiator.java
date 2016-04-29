package br.com.logique.easyspark;

import com.thoughtworks.paranamer.AnnotationParanamer;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;
import spark.Request;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by Gustavo on 28/04/2016.
 */
public class IogiObjectInstantiator implements ObjectInstantiator {

    @Override
    public Object resolveParameter(Method method, Parameter parameter, Request request) {
        method.getName();

        Paranamer info = new CachingParanamer(new AnnotationParanamer(new BytecodeReadingParanamer()));

        String[] parameterNames = info.lookupParameterNames(method, false);
        for (String parameterName : parameterNames) {
            System.out.println(parameterName);
        }

        return null;
    }
}
