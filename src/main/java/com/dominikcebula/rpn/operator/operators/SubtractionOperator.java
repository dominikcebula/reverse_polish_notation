package com.dominikcebula.rpn.operator.operators;

import com.dominikcebula.rpn.operand.operands.Operand;

public class SubtractionOperator implements Operator {

    public static String SUBTRACTION_SYMBOL = "-";

    @Override
    public Operand evaluate(Operand a, Operand b) {
        return a.subtract(b);
    }
}
