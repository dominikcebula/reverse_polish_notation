package com.dominikcebula.rpn.evaluator.exceptions;

public class EvaluatorExceptionInvalidToken extends EvaluatorException {

    public EvaluatorExceptionInvalidToken(String token) {
        super(String.format("Provided token [%s] is not operand or operator", token));
    }
}
