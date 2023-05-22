package com.booleanuk.core.format;

import com.booleanuk.core.format.FirstLetterToUpperFormat;
import com.booleanuk.core.format.Format;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFormat {
    @Test
    public void testText() {
        Format<String> f = new FirstLetterToUpperFormat();

        Assertions.assertEquals("Dave", f.result("dave"));
    }

    @Test
    public void testDouble() {
        Format<Double> f = new TwoDecimalFormat();

        Assertions.assertEquals(200.46, f.result(100.2323123123123123) + f.result(100.2323123123123123));
    }
}
