package com.dominikcebula.rpn.evaluator.exceptions;

public class EvaluatorException extends Exception {

    EvaluatorException(String message) {
        super(message);
    }

    public EvaluatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
