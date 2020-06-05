package com.itsz.springboot.tdd.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilTest {

    @Test
    void testConvertToDecimal() {
        double result = MathUtil.convertToDecimal(1, 2);
        assertEquals(0.5, result);
    }

    @Test
    void testConvertToDecimalWithInvalidDenominator() {
        assertThrows(IllegalArgumentException.class, () -> MathUtil.convertToDecimal(1, 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsEvenNumber() {
        assertFalse(() -> MathUtil.isEventNumber(1));
    }

    @ParameterizedTest
    @MethodSource("generateEventNumber")
    void testGenerateEventNumber(int number) {
        assertTrue(() -> MathUtil.isEventNumber(number));
    }

    static IntStream generateEventNumber() {
        return IntStream.iterate(0, i -> i + 2).limit(500);
    }
}