package br.com.logique.easyspark.it;

import br.com.logique.easyspark.annotations.Controller;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller to test if method return works fine.
 *
 * Created by Gustavo on 30/06/2016.
 */
@Controller
public class ReturnController {

    public ModelAndView modelAndView() {
        Map<String, Object> attributes = new HashMap<>();
        return new ModelAndView(attributes, "test.ftl");
    }

}
