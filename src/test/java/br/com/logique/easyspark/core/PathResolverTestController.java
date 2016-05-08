package br.com.logique.easyspark.core;

import br.com.logique.easyspark.annotations.Controller;
import br.com.logique.easyspark.annotations.Path;
import spark.Request;
import spark.Response;

/**
 * Created by gustavo on 27/04/2016.
 */
@Controller
public class PathResolverTestController {

    public void test1(){
    }

    @Path("test2/")
    public void test2(){
    }

    @Path(":controller/dynamic/")
    public void test3(){
    }

    @Path("test4/:paramStr/:paramInt")
    public void test4(String paramStr, Response response, Integer paramInt, Request request){
    }

}
