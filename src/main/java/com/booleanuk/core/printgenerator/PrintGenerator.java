package com.booleanuk.core.printgenerator;

public class PrintGenerator {

    /**
     * Prints centered text
     * @param text - Text
     * @param totalWidth - Total width of the output / layout
     */
    protected void printCenterTitle(String text, int totalWidth) {

        // Resource: https://www.baeldung.com/java-center-text-output
        String padding = "%" + ((totalWidth - text.length()) / 2) + "s";
        String centeredText = String.format(padding + "%s" + padding, "", text, "");
        System.out.println(centeredText);
    }

    public void print() {
        System.out.println("Hello World!");
    }

}
