package com.dominikcebula.rpn.operand.operands;

public interface Operand {

    Number getValue();

    String getValuePresentation();

    Operand add(Operand other);

    Operand subtract(Operand other);
}
