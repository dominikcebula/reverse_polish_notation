package com.dominikcebula.rpn.operator.operators;

import com.dominikcebula.rpn.operand.operands.Operand;

public interface Operator {
    Operand evaluate(Operand a, Operand b);
}
