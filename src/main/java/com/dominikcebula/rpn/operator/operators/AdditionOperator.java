package com.dominikcebula.rpn.operator.operators;

import com.dominikcebula.rpn.operand.operands.Operand;

public class AdditionOperator implements Operator {

    public static final String ADDITION_SYMBOL = "+";

    @Override
    public Operand evaluate(Operand a, Operand b) {
        return a.add(b);
    }
}
