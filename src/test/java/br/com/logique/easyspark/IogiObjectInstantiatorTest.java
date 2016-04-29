package br.com.logique.easyspark;

import com.google.common.collect.Sets;
import org.junit.Test;
import spark.Request;

import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Gustavo on 28/04/2016.
 */
public class IogiObjectInstantiatorTest {

    @Test
    public void testResolveParameter() throws Exception {
        Request mockRequest = mock(Request.class);
        when(mockRequest.attributes()).thenReturn(Sets.newHashSet("iogiTest.name", "iogiTest.value"));
        when(mockRequest.attribute("iogiTest.name")).thenReturn("nomeIogi");
        when(mockRequest.attribute("iogiTest.value")).thenReturn("10");

        IogiObjectInstantiator iogiObjectInstantiator = new IogiObjectInstantiator();
        Method method = IogiTestController.class.getMethod("testIogi", IogiParameterTest.class);
        IogiParameterTest instance = (IogiParameterTest) iogiObjectInstantiator.resolveParameter(method, method.getParameters()[0], mockRequest);
        //assertNotNull(instance);
    }



}