package com.itsz.data.structure.stack;

import org.junit.Test;

public class SeniorCalculatorTest {


    @Test
    public void testCalculateResult(){
        SeniorCalculator calculator = new SeniorCalculator();
        int result = calculator.calculate("1+((2+3)*4)-5");
        System.out.println(result);
    }
}
