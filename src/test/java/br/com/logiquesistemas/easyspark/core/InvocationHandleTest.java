package br.com.logiquesistemas.easyspark.core;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;

import java.lang.reflect.Method;
import java.util.HashMap;

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
        Request mockRequest = getIogiMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testIogi", IogiParameterTest.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"iogiTest"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokeRequestAndClientParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getIogiMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testIogi", Request.class, IogiParameterTest.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"request", "iogiTest"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokeResponseAndClientParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getIogiMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testIogi", Response.class, IogiParameterTest.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"response", "iogiTest"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokeRequestResponseAndClientParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getIogiMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testIogi", Request.class, Response.class, IogiParameterTest.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"request", "response", "iogiTest"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokePrimitiveStringParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getPrimitiveAttributeMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testPrimitiveStr", String.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"paramStr"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokePrimitiveIntParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getPrimitiveAttributeMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testPrimitiveInt", Integer.TYPE);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"paramInt"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokePrimitiveDlbParameter() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getPrimitiveAttributeMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testPrimitiveDbl", Double.TYPE);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"paramDbl"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokeDynamicParameters() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = getPrimitiveParamMockedRequest();
        Method controllerMethod = TestController.class.getMethod("testDynamic", Request.class, String.class,
                Response.class, Integer.class);
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        when(paramNames.paramNames(controllerMethod)).thenReturn(new String[]{"request", "paramStr", "response", "paramInt"});
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    @Test
    public void invokeModelAndView() throws NoSuchMethodException {
        Response mockResponse = mock(Response.class);
        Request mockRequest = mock(Request.class);
        Method controllerMethod = TestController.class.getMethod("testModelViewReturn");
        ParamNamesResolver paramNames = mock(ParamNamesResolver.class);
        executeMethod(paramNames, mockResponse, mockRequest, controllerMethod);
        Assert.assertTrue(TestController.isInteracted());
    }

    private void executeMethod(ParamNamesResolver paramNames, Response mockResponse, Request mockRequest, Method controllerMethod) {
        InvocationHandle invocationHandle = new InvocationHandle(TestController.class, controllerMethod);
        invocationHandle.setParamNamesResolver(paramNames);
        invocationHandle.execute(mockRequest, mockResponse);
    }

    private Request getIogiMockedRequest() {
        Request mockRequest = mock(Request.class);
        when(mockRequest.attributes()).thenReturn(Sets.newHashSet("iogiTest.name", "iogiTest.value"));
        when(mockRequest.attribute("iogiTest.name")).thenReturn("nomeIogi");
        when(mockRequest.attribute("iogiTest.value")).thenReturn("10");
        return mockRequest;
    }

    private Request getPrimitiveAttributeMockedRequest() {
        Request mockRequest = mock(Request.class);
        when(mockRequest.attributes()).thenReturn(Sets.newHashSet(":paramStr", ":paramInt", ":paramDbl"));
        when(mockRequest.attribute(":paramStr")).thenReturn("Logique Sistemas");
        when(mockRequest.attribute(":paramInt")).thenReturn("12");
        when(mockRequest.attribute(":paramDbl")).thenReturn("12.5");
        return mockRequest;
    }

    private Request getPrimitiveParamMockedRequest() {
        Request mockRequest = mock(Request.class);
        HashMap<String, String> map = Maps.newHashMap();
        map.put(":paramStr", "Logique Sistemas");
        map.put(":paramInt", "12");
        map.put(":paramDbl", "12.5");
        when(mockRequest.params()).thenReturn(map);
        when(mockRequest.params(":paramStr")).thenReturn("Logique Sistemas");
        when(mockRequest.params(":paramInt")).thenReturn("12");
        when(mockRequest.params(":paramDbl")).thenReturn("12.5");
        return mockRequest;
    }


}