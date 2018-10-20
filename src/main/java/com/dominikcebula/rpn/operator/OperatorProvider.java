package com.dominikcebula.rpn.operator;

import com.dominikcebula.rpn.operator.operators.AdditionOperator;
import com.dominikcebula.rpn.operator.operators.Operator;
import com.dominikcebula.rpn.operator.operators.SubtractionOperator;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static com.dominikcebula.rpn.operator.operators.AdditionOperator.ADDITION_SYMBOL;
import static com.dominikcebula.rpn.operator.operators.SubtractionOperator.SUBTRACTION_SYMBOL;

public class OperatorProvider {

    private static final Map<String, Operator> OPERATORS = ImmutableMap.of(
            ADDITION_SYMBOL, new AdditionOperator(),
            SUBTRACTION_SYMBOL, new SubtractionOperator()
    );

    public boolean isOperator(String symbol)
    {
        return OPERATORS.containsKey(symbol);
    }

    public Operator getOperator(String symbol) throws OperatorNotFoundException {
        if (OPERATORS.containsKey(symbol))
            return OPERATORS.get(symbol);
        else
            throw new OperatorNotFoundException(symbol);
    }
}
