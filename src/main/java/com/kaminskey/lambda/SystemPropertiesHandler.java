package com.kaminskey.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SystemPropertiesHandler implements RequestHandler<String, Object> {

    public Object handleRequest(final String input, final Context context) {
        this.validateInput(input);
        return System.getProperty(input);
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Passed system parameter cannot be null or empty");
        }
    }
}
