package com.dominikcebula.rpn.output;

import com.dominikcebula.rpn.operand.operands.Operand;

import java.io.PrintStream;

public class ConsoleOutputWriter implements OutputWriter {

    private final PrintStream outputStream = System.out;

    @Override
    public void writeResult(Operand result) {
        outputStream.println(result.getValuePresentation());
    }
}
