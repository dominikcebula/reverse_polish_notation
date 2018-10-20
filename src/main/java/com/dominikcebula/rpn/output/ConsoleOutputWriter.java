package com.dominikcebula.rpn.output;

import com.dominikcebula.rpn.operand.operands.Operand;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void writeResult(Operand result) {
        System.out.println(result.getValuePresentation());
    }
}
