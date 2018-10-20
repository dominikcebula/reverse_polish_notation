package com.dominikcebula.rpn.operator;

import static java.lang.String.format;

public class OperatorNotFoundException extends Exception {

    public OperatorNotFoundException(String symbol) {
        super(format("Unable to find operator for symbol %s", symbol));
    }
}
