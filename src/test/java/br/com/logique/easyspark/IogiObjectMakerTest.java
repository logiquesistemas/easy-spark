package br.com.logique.easyspark;

import com.google.common.collect.Sets;
import org.junit.Test;
import spark.Request;

import java.lang.reflect.Method;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test object maker.
 *
 * @author Gustavo Leitão.
 */
public class IogiObjectMakerTest {

    @Test
    public void testResolveParameter() throws Exception {
        Request mockRequest = mock(Request.class);
        when(mockRequest.attributes()).thenReturn(Sets.newHashSet("iogiTest.name", "iogiTest.value"));
        when(mockRequest.attribute("iogiTest.name")).thenReturn("nomeIogi");
        when(mockRequest.attribute("iogiTest.value")).thenReturn("10");

        IogiObjectMaker iogiObjectInstantiator = new IogiObjectMaker();
        Method method = TestController.class.getMethod("testIogi", IogiParameterTest.class);
        IogiParameterTest result = (IogiParameterTest) iogiObjectInstantiator.resolveParameter("iogiTest", method.getParameters()[0], mockRequest);
        assertEquals(expeted("nomeIogi", 10), result);
    }

    @Test(expected = InstantiatorException.class)
    public void testResolveNoParameter() throws Exception {
        Request mockRequest = mock(Request.class);
        when(mockRequest.attributes()).thenReturn(Collections.emptySet());

        IogiObjectMaker iogiObjectInstantiator = new IogiObjectMaker();
        Method method = TestController.class.getMethod("testIogi", IogiParameterTest.class);
        IogiParameterTest instance = (IogiParameterTest) iogiObjectInstantiator.resolveParameter("iogiTest", method.getParameters()[0], mockRequest);
    }

    @Test(expected = InstantiatorException.class)
    public void testResolveIncompleteParameter() throws Exception {
        Request mockRequest = mock(Request.class);
        when(mockRequest.attributes()).thenReturn(Sets.newHashSet("iogiTest.name"));
        when(mockRequest.attribute("iogiTest.name")).thenReturn("nomeIogi");

        IogiObjectMaker iogiObjectInstantiator = new IogiObjectMaker();
        Method method = TestController.class.getMethod("testIogi", IogiParameterTest.class);
        IogiParameterTest instance = (IogiParameterTest) iogiObjectInstantiator.resolveParameter("iogiTest", method.getParameters()[0], mockRequest);
    }

    private IogiParameterTest expeted(String name, int value) {
        return new IogiParameterTest(name, value);
    }


}