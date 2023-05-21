package com.booleanuk.core.basket.format;

import com.booleanuk.core.format.FirstLetterToUpperFormat;
import com.booleanuk.core.format.Format;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFormat {
    @Test
    public void testText() {
        Format f = new FirstLetterToUpperFormat();

        Assertions.assertEquals("Dave", f.text("dave"));
    }
}
