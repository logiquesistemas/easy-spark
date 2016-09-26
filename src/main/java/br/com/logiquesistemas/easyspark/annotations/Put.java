package br.com.logiquesistemas.easyspark.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicate to use PUT HTTP verb.
 *
 * Created by Gustavo on 26/04/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Put {
}
