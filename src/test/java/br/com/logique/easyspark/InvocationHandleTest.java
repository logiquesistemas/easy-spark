package br.com.logique.easyspark;

import com.google.common.collect.Sets;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;

import java.lang.reflect.Method;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Invocation handle test.
 *
 * @author Gustavo Leitão
 */
public class InvocationHandleTest {

    @Before
    public void setUp() {
        TestController.resetCounter();
    }

    @Test
    public void invokeClientParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testIogi", IogiParameterTest.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"iogiTest"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokeRequestAndClientParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testIogi", Request.class, IogiParameterTest.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"request", "iogiTest"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokeResponseAndClientParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testIogi", Response.class, IogiParameterTest.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"response", "iogiTest"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokeRequestResponseAndClientParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testIogi", Request.class, Response.class, IogiParameterTest.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"request", "response", "iogiTest"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    private void executeMethod(ParamNamesResolver paramNames, Response mockResponse, Request mockRequest, Method controllerMethod) {
        InvocationHandle invocationHandle = new InvocationHandle(TestController.class, controllerMethod);
        invocationHandle.setParamNamesResolver(paramNames);
        invocationHandle.execute(mockRequest, mockResponse);
    }

    private Request getMockedRequest() {
        Request mockRequest = mock(Request.class);
        when(mockRequest.attributes()).thenReturn(Sets.newHashSet("iogiTest.name", "iogiTest.value"));
        when(mockRequest.attribute("iogiTest.name")).thenReturn("nomeIogi");
        when(mockRequest.attribute("iogiTest.value")).thenReturn("10");
        return mockRequest;
    }


}