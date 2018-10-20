package com.dominikcebula.rpn.operator;

import com.dominikcebula.rpn.operator.operators.AdditionOperator;
import com.dominikcebula.rpn.operator.operators.SubtractionOperator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class OperatorProviderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private OperatorProvider operatorProvider = new OperatorProvider();

    @Test
    @Parameters(method = "validOperators")
    public void shouldStateValueAsOperator(String value) {
        assertTrue(operatorProvider.isOperator(value));
    }

    @Test
    @Parameters(method = "validOperatorsAndClasses")
    public void shouldParseValueCorrectly(String value, Class expectedOperand) throws OperatorNotFoundException {
        assertEquals(expectedOperand, operatorProvider.getOperator(value).getClass());
    }

    @Test
    @Parameters(method = "invalidOperators")
    public void shouldStateValueAsNotOperator(String value) {
        assertFalse(operatorProvider.isOperator(value));
    }

    @Test
    @Parameters(method = "invalidOperators")
    public void shouldThrowOperatorNotFoundException(String value) throws OperatorNotFoundException {
        thrown.expect(OperatorNotFoundException.class);

        operatorProvider.getOperator(value);
    }

    @SuppressWarnings("unused")
    private String[] validOperators() {
        return new String[]{
                "+",
                "-"
        };
    }

    @SuppressWarnings("unused")
    private Object[] validOperatorsAndClasses() {
        return new Object[]{
                new Object[]{"+", AdditionOperator.class},
                new Object[]{"-", SubtractionOperator.class}
        };
    }

    @SuppressWarnings("unused")
    private String[] invalidOperators() {
        return new String[]{
                "0",
                "10",
                "*",
                "/",
                "A"
        };
    }
}