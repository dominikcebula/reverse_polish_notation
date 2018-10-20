package com.dominikcebula.rpn.operand;

import com.dominikcebula.rpn.operand.factory.NumberOperandFactory;
import com.dominikcebula.rpn.operand.factory.OperandFactory;
import com.dominikcebula.rpn.operand.operands.Operand;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;

public class OperandProvider {

    private static final List<OperandFactory> OPERANDS_FACTORY = ImmutableList.of(
            new NumberOperandFactory()
    );

    public boolean isOperand(String value) {
        return findOperand(value).isPresent();
    }

    public Operand getOperand(String value) throws OperandNotFoundException {
        Optional<OperandFactory> operandFactory = findOperand(value);

        if (operandFactory.isPresent())
            return operandFactory.get().getOperand(value);
        else
            throw new OperandNotFoundException(value);
    }

    private Optional<OperandFactory> findOperand(String value) {
        return OPERANDS_FACTORY.stream()
                .filter(f -> f.canHandle(value))
                .findFirst();
    }
}
