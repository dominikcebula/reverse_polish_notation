package com.dominikcebula.rpn.evaluator.exceptions;

public class EvaluatorExceptionNoTokens extends EvaluatorException {
    public static final String MESSAGE_NO_TOKENS = "Incorrect RPN input - no tokens provided";

    public EvaluatorExceptionNoTokens() {
        super(MESSAGE_NO_TOKENS);
    }
}
