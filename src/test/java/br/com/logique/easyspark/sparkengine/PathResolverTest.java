package br.com.logique.easyspark.sparkengine;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * PathResolver unit test.
 *
 * Created by gustavo on 27/04/2016.
 */
public class PathResolverTest {

    @Test
    public void testResolveSimplePath() throws Exception {
        PathResolver pathResolver = new PathResolver();
        Method loginMethod = PathResolverTestController.class.getMethod("test1");
        String path = pathResolver.resolvePath(PathResolverTestController.class, loginMethod);
        Assert.assertEquals("pathresolvertest/test1/", path);
    }

    @Test
    public void testResolveChangedPath() throws Exception {
        PathResolver pathResolver = new PathResolver();
        Method loginMethod = PathResolverTestController.class.getMethod("test2");
        String path = pathResolver.resolvePath(PathResolverTestController.class, loginMethod);
        Assert.assertEquals("test2/", path);
    }

    @Test
    public void testResolveDynamicPath() throws Exception {
        PathResolver pathResolver = new PathResolver();
        Method loginMethod = PathResolverTestController.class.getMethod("test3");
        String path = pathResolver.resolvePath(PathResolverTestController.class, loginMethod);
        Assert.assertEquals("pathresolvertest/dynamic/", path);
    }

}