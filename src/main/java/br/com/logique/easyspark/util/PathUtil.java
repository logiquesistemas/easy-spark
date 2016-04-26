package br.com.logique.easyspark.util;

/**
 * Created by gustavo on 26/04/2016.
 */
public class PathUtil {

    private static final String CONTROLLER = "Controller";

    public static String getPath(String clazzName, String method) {

        int indexController = clazzName.indexOf(CONTROLLER);
        if (indexController >= 0) {
            clazzName = clazzName.substring(0, indexController);
        }

        return clazzName.toLowerCase() + "/" + method.toLowerCase() + "/";
    }

}
