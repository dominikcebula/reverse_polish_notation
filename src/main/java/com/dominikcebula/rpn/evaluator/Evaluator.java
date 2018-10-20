package com.dominikcebula.rpn.evaluator;

import com.dominikcebula.rpn.evaluator.exceptions.*;
import com.dominikcebula.rpn.input.InputReader;
import com.dominikcebula.rpn.operand.OperandNotFoundException;
import com.dominikcebula.rpn.operand.OperandProvider;
import com.dominikcebula.rpn.operand.operands.Operand;
import com.dominikcebula.rpn.operator.OperatorNotFoundException;
import com.dominikcebula.rpn.operator.OperatorProvider;
import com.dominikcebula.rpn.operator.operators.Operator;
import com.dominikcebula.rpn.output.OutputWriter;

import java.util.Stack;

public class Evaluator {

    private InputReader inputReader;
    private OutputWriter outputWriter;

    private OperandProvider operandProvider = new OperandProvider();
    private OperatorProvider operatorProvider = new OperatorProvider();

    public Evaluator(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void evaluate() throws EvaluatorException {
        String[] tokens = readTokens();

        try {
            Operand result = evaluateTokens(tokens);

            writeResult(result);
        } catch (OperandNotFoundException | OperatorNotFoundException e) {
            throw new EvaluatorException(String.format("Error occurred during evaluation: %s", e.getMessage()), e);
        }
    }

    private String[] readTokens() throws EvaluatorException {
        String[] tokens = inputReader.readTokens();

        if (tokens.length > 0)
            return tokens;
        else
            throw new EvaluatorExceptionNoTokens();
    }

    private Operand evaluateTokens(String[] tokens) throws OperandNotFoundException, OperatorNotFoundException, EvaluatorException {
        Stack<Operand> operands = new Stack<>();

        for (String token : tokens) {
            if (operandProvider.isOperand(token)) {
                evaluateOperandToken(operands, token);
            } else if (operatorProvider.isOperator(token)) {
                evaluateOperatorToken(operands, token);
            } else {
                throw new EvaluatorExceptionInvalidToken(token);
            }
        }

        return getFinalResults(operands);
    }

    private void writeResult(Operand result) {
        outputWriter.writeResult(result);
    }

    private void evaluateOperandToken(Stack<Operand> operands, String token) throws OperandNotFoundException {
        operands.push(operandProvider.getOperand(token));
    }

    private void evaluateOperatorToken(Stack<Operand> operands, String token) throws OperatorNotFoundException, EvaluatorException {
        Operator operator = operatorProvider.getOperator(token);

        Operand operandB = getOperandFromStack(operands);
        Operand operandA = getOperandFromStack(operands);

        Operand result = operator.evaluate(operandA, operandB);

        operands.push(result);
    }

    private Operand getOperandFromStack(Stack<Operand> operands) throws EvaluatorException {
        if (operands.size() > 0)
            return operands.pop();
        else
            throw new EvaluatorExceptionMoreOperatorsThanOperands();
    }

    private Operand getFinalResults(Stack<Operand> operands) throws EvaluatorException {
        if (operands.size() == 1)
            return operands.pop();
        else
            throw new EvaluatorExceptionMoreOperandsThanOperators();

    }
}
