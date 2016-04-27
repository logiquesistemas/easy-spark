package br.com.logique.easyspark.sparkengine;

import br.com.logique.easyspark.sparkengine.annotations.Controller;
import br.com.logique.easyspark.sparkengine.annotations.Path;

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
