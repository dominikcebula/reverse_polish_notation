package com.dominikcebula.rpn.evaluator.exceptions;

public class EvaluatorExceptionMoreOperandsThanOperators extends EvaluatorException {

    public static final String MESSAGE_MORE_OPERANDS_THAN_OPERATORS = "Incorrect RPN input - more operands than operators";

    public EvaluatorExceptionMoreOperandsThanOperators() {
        super(MESSAGE_MORE_OPERANDS_THAN_OPERATORS);
    }
}
