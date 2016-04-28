package br.com.logique.easyspark.it;

import br.com.logique.easyspark.SparkEngine;

/**
 * Setup spark to Integration tests.
 *
 * Created by Gustavo on 26/04/2016.
 */
public class SparkSetup {

    private static final String BASE_PATH = "http://localhost:7485";

    static {
        SparkEngine sparkEngine = new SparkEngine.Builder().withPort(7485).withBasePackage("br.com.logique").build();
        sparkEngine.setUp();
    }

    private SparkSetup() {
    }

    public static String getBaseBash() {
        return BASE_PATH;
    }

}
