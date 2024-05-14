package com.dominikcebula.rpn.operand.operands;

public class NumberOperand implements Operand {

    private final Integer value;

    public NumberOperand(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getValuePresentation() {
        return String.valueOf(value);
    }

    @Override
    public NumberOperand add(Operand other) {
        return new NumberOperand(getValue() + other.getValue().intValue());
    }

    @Override
    public NumberOperand subtract(Operand other) {
        return new NumberOperand(getValue() - other.getValue().intValue());
    }
}
