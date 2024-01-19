package com.migzus.terminal.menus;

public class Button {
    public boolean disabled = false;
    public Callable callable;
    public String displayName;

    public Button(String name) {
        displayName = name;
    }

    public Button(String name, Callable callback) {
        displayName = name;
        callable = callback;
    }

    public void onSelect() {
        callable.call();
    }
}
