package com.kaminskey.lambda;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class SystemPropertiesHandlerTest {

    private static final SystemPropertiesHandler systemPropertiesHandler = new SystemPropertiesHandler();

    @Test
    public void shouldReturnValueForExistingProperty() {
        String lambdaInput = "java.vm.specification.name";

        Object result = SystemPropertiesHandlerTest.systemPropertiesHandler.handleRequest(lambdaInput, null);

        assertNotNull(result);
    }

    @Test
    public void shouldReturnNullForNonExistingProperty() {
        String lambdaInput = "non.existing.property";

        Object result = SystemPropertiesHandlerTest.systemPropertiesHandler.handleRequest(lambdaInput, null);

        assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForEmptyInput() {
        String lambdaInput = "";

        SystemPropertiesHandlerTest.systemPropertiesHandler.handleRequest(lambdaInput, null);

        // exception expected to be thrown as declared in method annotation
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullInput() {
        String lambdaInput = null;

        SystemPropertiesHandlerTest.systemPropertiesHandler.handleRequest(lambdaInput, null);

        // exception expected to be thrown as declared in method annotation
    }
}
