package br.com.logiquesistemas.easyspark.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gustavo on 01/05/2016.
 */
public class InteractionsCounter {

    private AtomicInteger counter = new AtomicInteger(0);

    public void interact(){
        counter.incrementAndGet();
    }

    public void resetCounter(){
        counter = new AtomicInteger(0);
    }

    public boolean isInteracted(){
        return counter.get() > 0;
    }

}
