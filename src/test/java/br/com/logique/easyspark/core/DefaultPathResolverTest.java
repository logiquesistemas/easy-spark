package br.com.logique.easyspark.core;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals("pathresolvertest/test1/", path);
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

}