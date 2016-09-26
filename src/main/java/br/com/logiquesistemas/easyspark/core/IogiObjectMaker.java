package br.com.logiquesistemas.easyspark.core;

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

        String lowerCaseParamName = paramName.toLowerCase();

        Target<?> target = Target.create(clazzParamter, lowerCaseParamName);

        List<br.com.caelum.iogi.parameters.Parameter> paramtersIogi = new ArrayList<>();
        request.attributes().stream().filter(p -> removeTwoPoints(p.toLowerCase()).startsWith(lowerCaseParamName))
                .forEach(p -> paramtersIogi.add(new br.com.caelum.iogi.parameters.Parameter(removeTwoPoints(p.toLowerCase()), request.attribute(p).toString())));

        request.queryParams().stream().filter(p -> removeTwoPoints(p.toLowerCase()).toLowerCase().startsWith(lowerCaseParamName))
                .forEach(p -> paramtersIogi.add(new br.com.caelum.iogi.parameters.Parameter(removeTwoPoints(p.toLowerCase()), request.queryParams(p).toString())));

        request.params().keySet().stream().filter(p -> removeTwoPoints(p).toLowerCase().startsWith(lowerCaseParamName))
                .forEach(p -> paramtersIogi.add(new br.com.caelum.iogi.parameters.Parameter(removeTwoPoints(p.toLowerCase()), request.params(p).toString())));

        Iogi iogi = new Iogi(new NullDependencyProvider(), new DefaultLocaleProvider());

        Object result = iogi.instantiate(target, paramtersIogi.toArray(new br.com.caelum.iogi.parameters.Parameter[paramtersIogi.size()]));
        if (result == null) {
            throw new InstantiatorException("Failed to create " + clazzParamter + " object. Insufficient parameters.");
        }
        return result;
    }



    private String removeTwoPoints(String input) {
        return input.replaceAll(":", "");
    }

}
