package br.com.logique.easyspark;

import br.com.logique.easyspark.sparkengine.SparkEngine;

/**
 * Main class
 * Created by gustavo on 26/04/2016.
 */
public class App {

    public static void main(String[] args) {
        SparkEngine sparkEngine = new SparkEngine.Builder().build();
        sparkEngine.setUp();
    }

}
