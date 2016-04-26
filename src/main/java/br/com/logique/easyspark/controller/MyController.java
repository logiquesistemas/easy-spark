package br.com.logique.easyspark.controller;

import br.com.logique.easyspark.sparkengine.Controller;
import spark.Request;
import spark.Response;

import java.util.UUID;

/**
 * Created by gustavo on 26/04/2016.
 */
@Controller
public class MyController {

    public String logar(Request request, Response response){
        return UUID.randomUUID().toString();
    }

}
