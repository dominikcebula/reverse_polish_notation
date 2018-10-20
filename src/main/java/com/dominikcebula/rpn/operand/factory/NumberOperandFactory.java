package com.dominikcebula.rpn.operand.factory;

import com.dominikcebula.rpn.operand.operands.NumberOperand;
import com.dominikcebula.rpn.operand.operands.Operand;

public class NumberOperandFactory implements OperandFactory {

    @Override
    public boolean canHandle(String value) {
        return value.matches("[0-9]+");
    }

    @Override
    public Operand getOperand(String value) {
        return new NumberOperand(Integer.valueOf(value));
    }
}
