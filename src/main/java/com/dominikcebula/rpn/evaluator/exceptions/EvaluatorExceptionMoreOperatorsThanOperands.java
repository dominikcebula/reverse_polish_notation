package com.dominikcebula.rpn.evaluator.exceptions;

public class EvaluatorExceptionMoreOperatorsThanOperands extends EvaluatorException {

    public static final String MESSAGE_MORE_OPERATORS_THAN_OPERANDS = "Incorrect RPN input - more operators than operands";

    public EvaluatorExceptionMoreOperatorsThanOperands() {
        super(MESSAGE_MORE_OPERATORS_THAN_OPERANDS);
    }
}
