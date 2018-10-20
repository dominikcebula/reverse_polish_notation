package com.dominikcebula.rpn.operator.operators;

import com.dominikcebula.rpn.operand.operands.Operand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsBlockJUnit4ClassRunner;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertSame;
import static org.unitils.easymock.EasyMockUnitils.replay;

@RunWith(UnitilsBlockJUnit4ClassRunner.class)
public class SubtractionOperatorTest {

    @TestedObject
    private SubtractionOperator subtractionOperator;
    @Mock
    private Operand operandA;
    @Mock
    private Operand operandB;
    @Mock
    private Operand result;

    @Test
    public void shouldInvokeAdditionOperation() {
        expect(operandA.subtract(operandB)).andReturn(result);

        replay();

        assertSame(
                result,
                subtractionOperator.evaluate(operandA, operandB)
        );
    }
}