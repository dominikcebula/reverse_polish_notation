package com.dominikcebula.rpn.evaluator;

import com.dominikcebula.rpn.evaluator.exceptions.EvaluatorException;
import com.dominikcebula.rpn.evaluator.exceptions.EvaluatorExceptionMoreOperandsThanOperators;
import com.dominikcebula.rpn.evaluator.exceptions.EvaluatorExceptionMoreOperatorsThanOperands;
import com.dominikcebula.rpn.evaluator.exceptions.EvaluatorExceptionNoTokens;
import com.dominikcebula.rpn.input.InputReader;
import com.dominikcebula.rpn.operand.operands.Operand;
import com.dominikcebula.rpn.output.OutputWriter;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.easymock.Capture;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class EvaluatorIntegrationTest {

    private static final String SPACE = " ";
    private static final String[] EMPTY_TOKENS = new String[0];

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Parameters({
            "1 2 +, 3",
            "1 2 -, -1",
            "1 1 + 1 1 + +, 4",
            "3 4 5 - +, 2",
            "2 1 + 3 +, 6",
            "15 7 1 1 + - 2 1 1 + + - +, 16",
            "-10 10 + -5 2 + +, -3"
    })
    public void shouldEvaluateCorrectlyExpression(String tokens, String expectedResult) throws EvaluatorException {
        Capture<Operand> resultCapture = Capture.newInstance();

        Evaluator evaluator = new Evaluator(
                mockedInputReader(split(tokens)),
                mockOutputWriter(resultCapture)
        );

        evaluator.evaluate();

        assertEquals(expectedResult, resultCapture.getValue().getValuePresentation());
    }

    @Test
    public void shouldThrowExceptionWhenNoTokensProvided() throws EvaluatorException {
        Evaluator evaluator = new Evaluator(
                mockedInputReader(EMPTY_TOKENS),
                mockOutputWriter(Capture.newInstance())
        );

        thrown.expect(EvaluatorExceptionNoTokens.class);
        thrown.expectMessage(EvaluatorExceptionNoTokens.MESSAGE_NO_TOKENS);

        evaluator.evaluate();
    }

    @Test
    @Parameters({
            "1 2",
            "1 2 3 +",
            "1 2 + 3 4 +",
            "1 2 3 + 3 4 +",
    })
    public void shouldThrowExceptionWhenMoreOperandsThenOperators(String tokens) throws EvaluatorException {
        Evaluator evaluator = new Evaluator(
                mockedInputReader(split(tokens)),
                mockOutputWriter(Capture.newInstance())
        );

        thrown.expect(EvaluatorExceptionMoreOperandsThanOperators.class);
        thrown.expectMessage(EvaluatorExceptionMoreOperandsThanOperators.MESSAGE_MORE_OPERANDS_THAN_OPERATORS);

        evaluator.evaluate();
    }

    @Test
    @Parameters({
            "+",
            "+ -",
            "1 2 3 + - +",
            "1 2 + + 3 4 +",
            "1 2 3 + 3 4 + + + +",
            "1 2 3 + + 3 4 5 + + + + 6 7 8 + +",
    })
    public void shouldThrowExceptionWhenMoreOperatorsThenOperands(String tokens) throws EvaluatorException {
        Evaluator evaluator = new Evaluator(
                mockedInputReader(split(tokens)),
                mockOutputWriter(Capture.newInstance())
        );

        thrown.expect(EvaluatorExceptionMoreOperatorsThanOperands.class);
        thrown.expectMessage(EvaluatorExceptionMoreOperatorsThanOperands.MESSAGE_MORE_OPERATORS_THAN_OPERANDS);

        evaluator.evaluate();
    }

    private String[] split(String tokens) {
        return tokens.split(SPACE);
    }

    private InputReader mockedInputReader(String[] tokens) {
        InputReader inputReader = createMock(InputReader.class);

        expect(inputReader.readTokens()).andReturn(tokens);

        replay(inputReader);

        return inputReader;
    }

    private OutputWriter mockOutputWriter(Capture<Operand> resultCapture) {
        OutputWriter outputWriter = createMock(OutputWriter.class);

        outputWriter.writeResult(capture(resultCapture));

        replay(outputWriter);

        return outputWriter;
    }
}