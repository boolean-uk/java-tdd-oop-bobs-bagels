package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClarificationTest {

    @Test
    public void DaveToldUsToImplementExtensionsInCoreTest(){
        Clarification c = new Clarification();

        String expectedString = "The implementation of extension 1 and 2 can be found in the core hierarchy.";
        String result = c.DaveToldUsToImplementExtensionsInCore();
        Assertions.assertEquals(expectedString, result);
    }
}
