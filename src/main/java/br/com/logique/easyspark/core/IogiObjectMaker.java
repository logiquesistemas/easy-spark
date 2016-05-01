package br.com.logique.easyspark.core;

import br.com.caelum.iogi.Iogi;
import br.com.caelum.iogi.reflection.Target;
import br.com.caelum.iogi.util.DefaultLocaleProvider;
import br.com.caelum.iogi.util.NullDependencyProvider;
import spark.Request;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 28/04/2016.
 */
public class IogiObjectMaker implements ObjectMaker {

    @Override
    public Object resolveParameter(String paramName, Parameter parameter, Request request) {

        Class<?> clazzParamter = parameter.getType();
        Target<?> target = Target.create(clazzParamter, paramName);

        List<br.com.caelum.iogi.parameters.Parameter> paramtersIogi = new ArrayList<>();
        request.attributes().stream().filter(p -> p.startsWith(paramName))
                .forEach(p -> paramtersIogi.add(new br.com.caelum.iogi.parameters.Parameter(p, request.attribute(p))));

        Iogi iogi = new Iogi(new NullDependencyProvider(), new DefaultLocaleProvider());


        Object result = iogi.instantiate(target, paramtersIogi.toArray(new br.com.caelum.iogi.parameters.Parameter[paramtersIogi.size()]));
        if (result == null) {
            throw new InstantiatorException("Failed to create " + clazzParamter + " object. Insufficient parameters.");
        }
        return result;
    }
}
