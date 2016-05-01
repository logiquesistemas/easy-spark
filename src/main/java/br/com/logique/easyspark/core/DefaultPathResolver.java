package br.com.logique.easyspark.core;

import br.com.logique.easyspark.annotations.Path;

import java.lang.reflect.Method;

/**
 * Manage URl path.
 * <p>
 * Created by Gustavo on 26/04/2016.
 */
public class DefaultPathResolver implements PathResolver {

    private static final String CONTROLLER = "Controller";

    /**
     * Generate URl path.
     *
     * @param controller Controller class
     * @param method Controller method
     * @return Http path
     */
    public String resolvePath(Class<?> controller, Method method) {

        String className = getControllerName(controller);
        String path;

        if (method.isAnnotationPresent(Path.class)) {
            path = method.getAnnotation(Path.class).value();
            path = path.replaceAll(":controller", className);
        } else {
            path = className + "/" + method.getName() + "/";
        }

        return path.toLowerCase();
    }

    private String getControllerName(Class<?> controller) {
        String className = controller.getSimpleName();
        int indexController = className.indexOf(CONTROLLER);
        if (indexController >= 0) {
            className = className.substring(0, indexController);
        }
        return className;
    }

}
