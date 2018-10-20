package com.dominikcebula.rpn.operand.factory;

import com.dominikcebula.rpn.operand.operands.Operand;

public interface OperandFactory {

    boolean canHandle(String value);

    Operand getOperand(String value);
}
