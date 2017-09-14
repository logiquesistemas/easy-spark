package br.com.logiquesistemas.easyspark.it;

import br.com.logiquesistemas.easyspark.annotations.Controller;
import spark.Response;


/**
 * Controller to test interceptors
 * Created by Gustavo Leitão on 11/09/2017.
 */
@Controller
public class InterceptorController {

    public boolean simple(Response response){
        System.out.println("CHAMOU CONTROLLER");
        return Boolean.TRUE;
    }

}
