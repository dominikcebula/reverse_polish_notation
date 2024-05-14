package com.dominikcebula.rpn.operand;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class OperandProviderTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private final OperandProvider operandProvider = new OperandProvider();

    @Test
    @Parameters(method = "validCases")
    public void shouldStateValueAsOperand(String value) {
        assertTrue(operandProvider.isOperand(value));
    }

    @Test
    @Parameters(method = "validCases")
    public void shouldParseValueCorrectly(String value) throws OperandNotFoundException {
        assertEquals(Integer.valueOf(value), operandProvider.getOperand(value).getValue());
    }

    @Test
    @Parameters(method = "invalidCases")
    public void shouldStateValueAsNotOperand(String value) {
        assertFalse(operandProvider.isOperand(value));
    }

    @Test
    @Parameters(method = "invalidCases")
    public void shouldThrowOperandNotFoundException(String value) throws OperandNotFoundException {
        thrown.expect(OperandNotFoundException.class);

        operandProvider.getOperand(value);
    }

    @SuppressWarnings("unused")
    private String[] validCases() {
        return new String[]{
                "0",
                "-5",
                "8",
                "10",
                "-20"
        };
    }

    @SuppressWarnings("unused")
    private String[] invalidCases() {
        return new String[]{
                "A",
                "b",
                "-",
                "+",
                "x"
        };
    }
}