package br.com.logiquesistemas.easyspark.core;

import br.com.logiquesistemas.easyspark.it.PathController;
import org.junit.Assert;
import org.junit.Test;
import spark.Request;
import spark.Response;

import java.lang.reflect.Method;

/**
 * DefaultPathResolver unit test.
 *
 * Created by gustavo on 27/04/2016.
 */
public class DefaultPathResolverTest {

    @Test
    public void testResolveSimplePath() throws Exception {
        PathResolver defaultPathResolver = new DefaultPathResolver();
        Method loginMethod = PathResolverTestController.class.getMethod("test1");
        String path = defaultPathResolver.resolvePath(PathResolverTestController.class, loginMethod);
        Assert.assertEquals("pathresolvertest/test1", path);
    }

    @Test
    public void testResolveChangedPath() throws Exception {
        PathResolver defaultPathResolver = new DefaultPathResolver();
        Method loginMethod = PathResolverTestController.class.getMethod("test2");
        String path = defaultPathResolver.resolvePath(PathResolverTestController.class, loginMethod);
        Assert.assertEquals("test2/", path);
    }

    @Test
    public void testResolveDynamicPath() throws Exception {
        PathResolver defaultPathResolver = new DefaultPathResolver();
        Method loginMethod = PathResolverTestController.class.getMethod("test3");
        String path = defaultPathResolver.resolvePath(PathResolverTestController.class, loginMethod);
        Assert.assertEquals("pathresolvertest/dynamic/", path);
    }

    @Test
    public void testResolveParamDynamicPath() throws Exception {
        PathResolver defaultPathResolver = new DefaultPathResolver();
        Method loginMethod = PathResolverTestController.class.getMethod("test4", String.class, Response.class,
                Integer.class, Request.class);
        String path = defaultPathResolver.resolvePath(PathResolverTestController.class, loginMethod);
        Assert.assertEquals("test4/:paramstr/:paramint", path);
    }

    @Test
    public void testGlobalPathInController() throws Exception {
        PathResolver defaultPathResolver = new DefaultPathResolver();
        Method method = PathController.class.getMethod("basicPath");
        String path = defaultPathResolver.resolvePath(PathController.class, method);
        Assert.assertEquals("globalpath/basic/", path);
    }

    @Test
    public void testGlobalPathWithControllerName() throws Exception {
        PathResolver defaultPathResolver = new DefaultPathResolver();
        Method method = PathController.class.getMethod("dynamicPath");
        String path = defaultPathResolver.resolvePath(PathController.class, method);
        Assert.assertEquals("globalpath/path/basic/", path);
    }

}