package com.dominikcebula.rpn.operand;

import static java.lang.String.format;

public class OperandNotFoundException extends Exception {

    public OperandNotFoundException(String value) {
        super(format("Unable to find operand for symbol %s", value));
    }
}
