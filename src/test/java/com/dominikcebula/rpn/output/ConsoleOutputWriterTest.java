package com.dominikcebula.rpn.output;

import com.dominikcebula.rpn.operand.operands.Operand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsBlockJUnit4ClassRunner;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;

import java.io.PrintStream;

import static org.easymock.EasyMock.expect;
import static org.unitils.easymock.EasyMockUnitils.replay;

@RunWith(UnitilsBlockJUnit4ClassRunner.class)
public class ConsoleOutputWriterTest {

    private static final String VALUE_REPRESENTATION = "10";

    @TestedObject
    private ConsoleOutputWriter consoleOutputWriter;
    @Mock
    @InjectIntoByType
    private PrintStream printStream;
    @Mock
    private Operand operand;

    @Test
    public void shouldWriteOperandToStream() {
        expect(operand.getValuePresentation()).andReturn(VALUE_REPRESENTATION);
        printStream.println(VALUE_REPRESENTATION);

        replay();

        consoleOutputWriter.writeResult(operand);
    }
}