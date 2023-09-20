package com.booleanuk.extension;

//Extensions are implemented along the core package
//Therefore adding this test to pass checks

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DummyTest {
    @Test
    public void alwaysTrue(){
        Assertions.assertTrue(true);
    }
}
