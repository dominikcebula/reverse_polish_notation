package com.dominikcebula.rpn.output;

import com.dominikcebula.rpn.operand.operands.Operand;

public interface OutputWriter {
    void writeResult(Operand result);
}
