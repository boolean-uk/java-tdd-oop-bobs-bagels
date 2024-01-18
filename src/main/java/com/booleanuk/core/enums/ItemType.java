package com.booleanuk.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemType {
    BAGEL("Bagel"),
    COFFEE("Coffee"),
    FILLING("Filling");

    private final String displayName;
}