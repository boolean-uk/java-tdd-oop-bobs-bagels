package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionTest {
    @Test
    public void shouldSayHelloWorld() {
        Assertions.assertEquals("Hello, world!", Extension.sayHelloWorld());
    }
}
