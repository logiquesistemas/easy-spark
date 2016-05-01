package br.com.logique.easyspark.core;

import br.com.logique.easyspark.annotations.Controller;
import br.com.logique.easyspark.annotations.Path;

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

}
