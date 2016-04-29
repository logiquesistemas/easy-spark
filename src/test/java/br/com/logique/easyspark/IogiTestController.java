package br.com.logique.easyspark;

import br.com.logique.easyspark.annotations.Controller;

import java.util.UUID;

/**
 * Created by Gustavo on 29/04/2016.
 */
@Controller
public class IogiTestController {

    public String testIogi(IogiParameterTest iogiTest){
        return UUID.randomUUID().toString();
    }

}
