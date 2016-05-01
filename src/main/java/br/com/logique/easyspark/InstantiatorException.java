package br.com.logique.easyspark;

/**
 * Created by gustavo on 30/04/2016.
 */
public class InstantiatorException extends RuntimeException {

    public InstantiatorException(String message) {
        super(message);
    }

    public InstantiatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
