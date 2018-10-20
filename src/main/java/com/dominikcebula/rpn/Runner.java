package com.dominikcebula.rpn;

import com.dominikcebula.rpn.evaluator.Evaluator;
import com.dominikcebula.rpn.evaluator.exceptions.EvaluatorException;
import com.dominikcebula.rpn.input.CliArgsReader;
import com.dominikcebula.rpn.output.ConsoleOutputWriter;

public class Runner {

    public static void main(String[] args) throws EvaluatorException {

        Evaluator evaluator = new Evaluator(
                new CliArgsReader(args),
                new ConsoleOutputWriter()
        );

        evaluator.evaluate();
    }
}
