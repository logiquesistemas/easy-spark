package br.com.logiquesistemas.easyspark.it;

import br.com.logiquesistemas.easyspark.annotations.Controller;
import br.com.logiquesistemas.easyspark.annotations.Path;

/**
 * Controller to test @Path annotation.
 *
 * Created by Gustavo on 26/04/2016.
 */
@Controller
@Path("globalpath")
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
