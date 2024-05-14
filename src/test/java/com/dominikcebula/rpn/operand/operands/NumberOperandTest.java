package com.dominikcebula.rpn.operand.operands;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NumberOperandTest {

    private static final String FIVE_VALUE_STRING = "5";
    private static final int FIVE_VALUE = Integer.parseInt(FIVE_VALUE_STRING);

    @Test
    public void shouldCorrectlyCreateNumberOperand() {
        NumberOperand numberOperand = new NumberOperand(FIVE_VALUE);

        assertEquals(FIVE_VALUE, numberOperand.getValue().intValue());
    }

    @Test
    public void shouldCorrectlyReturnOperandRepresentation() {
        NumberOperand numberOperand = new NumberOperand(FIVE_VALUE);

        assertEquals(FIVE_VALUE_STRING, numberOperand.getValuePresentation());
    }

    @Test
    @Parameters({
            "0, 0, 0",
            "1, 1, 2",
            "3, 4, 7",
            "-5, 8, 3",
            "-5, -3, -8",
    })
    public void shouldCorrectlyAddValues(int a, int b, int results) {
        NumberOperand operandA = new NumberOperand(a);
        NumberOperand operandB = new NumberOperand(b);

        NumberOperand result = operandA.add(operandB);

        assertEquals(results, result.getValue().intValue());
    }

    @Test
    @Parameters({
            "0, 0, 0",
            "1, 1, 0",
            "8, 5, 3",
            "3, 4, -1",
            "-5, 8, -13",
            "-5, -3, -2",
    })
    public void shouldCorrectlySubtractValues(int a, int b, int results) {
        NumberOperand operandA = new NumberOperand(a);
        NumberOperand operandB = new NumberOperand(b);

        NumberOperand result = operandA.subtract(operandB);

        assertEquals(results, result.getValue().intValue());
    }
}