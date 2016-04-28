package br.com.logique.easyspark.it;

import br.com.logique.easyspark.annotations.*;

/**
 * Controller to teste if HTTP verbs works fine.
 *
 * Created by Gustavo on 26/04/2016.
 */
@Controller
public class HttpVerbsController {

    @Get
    @Path("httpverbs/")
    public Boolean get() {
        return Boolean.TRUE;
    }

    @Post
    @Path("httpverbs/")
    public Boolean post() {
        return Boolean.TRUE;
    }

    @Put
    @Path("httpverbs/")
    public Boolean put() {
        return Boolean.TRUE;
    }

    @Delete
    @Path("httpverbs/")
    public Boolean delete() {
        return Boolean.TRUE;
    }

}
