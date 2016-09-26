package br.com.logiquesistemas.easyspark.it;

import br.com.logiquesistemas.easyspark.annotations.Controller;
import br.com.logiquesistemas.easyspark.annotations.Path;
import spark.Request;
import spark.Response;

/**
 * Controller to test if method arguments works fine.
 * 
 * Created by Gustavo on 26/04/2016.
 */
@Controller
public class ArgumentController {

    public Boolean noArguments() {
        return Boolean.TRUE;
    }

    public Boolean request(Request request) {
        return request != null;
    }

    public Boolean response(Response response) {
        return response != null;
    }

    public Boolean requestResponse(Request request, Response response) {
        return request != null && response != null;
    }

    public Boolean requestStringQueryPrm(String paramStr){
        return paramStr != null && !paramStr.isEmpty();
    }

    @Path("argument/requeststringprm/:paramStr")
    public Boolean requestStringPrm(String paramStr){
        return paramStr != null && !paramStr.isEmpty();
    }

}
