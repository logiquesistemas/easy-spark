package br.com.logique.easyspark.sparkengine.it;

import br.com.logique.easyspark.sparkengine.annotations.Controller;
import br.com.logique.easyspark.sparkengine.annotations.Path;

/**
 * Controller to test @Path annotation.
 *
 * Created by Gustavo on 26/04/2016.
 */
@Controller
public class PathController {

    @Path("basic/")
    public Boolean basicPath() {
        return Boolean.TRUE;
    }

    @Path(":controller/basic/")
    public Boolean dynamicPath() {
        return Boolean.TRUE;
    }

}
