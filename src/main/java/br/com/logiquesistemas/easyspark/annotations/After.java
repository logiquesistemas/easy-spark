package br.com.logiquesistemas.easyspark.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 Annotation to indicate a action to run after the controller
 *
 * Created by Gustavo on 11/09/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface After {

    /**
     * After filter. Default value: "*". See Spark framework documentation for options.
     * @return String filter
     */
    String filter() default "*";

}
