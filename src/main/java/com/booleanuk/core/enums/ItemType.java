package com.booleanuk.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemType {
    BAGEL("Bagel"),
    COFFEE("Coffee"),
    FILLING("Filling"),
    GENERIC("");

    private final String displayName;

    public static ItemType getItemTypeFromString(String input) {
        for (ItemType itemType : ItemType.values()) {
            if (itemType.getDisplayName().equals(input)) {
                return itemType;
            }
        }
        return GENERIC;
    }
}