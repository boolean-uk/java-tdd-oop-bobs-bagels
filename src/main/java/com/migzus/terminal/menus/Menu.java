package com.migzus.terminal.menus;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static Menu currentActiveMenu;
    public Menu parentMenu;

    public Callable afterMenuPrintCallback;

    public String name = "Menu";

    private int selectIndex;
    private final ArrayList<Button> buttons = new ArrayList<>();
    private boolean hasFocus;

    public Menu(String newName) {
        name = newName;
    }

    public void pushButton(Button btn) {
        if (hasButton(btn.displayName)) return;
        buttons.add(btn);
    }

    public void popButton(String btnName) {
        for (Button b : buttons) {
            if (btnName.equals(b.displayName)) {
                buttons.remove(b);
                return;
            }
        }
    }

    public boolean hasButton(String btnName) {
        for (Button b : buttons)
            if (btnName.equals(b.displayName))
                return true;
        return false;
    }

    public void update() {
        while (hasFocus) {
            try {
                Scanner _scanner = new Scanner(System.in);

                switch (_scanner.next()) {
                    case "c":
                        buttons.get(selectIndex).onSelect();
                        break;
                    case "q":
                        unfocus();
                        break;
                    case "w":
                        selectIndex = (selectIndex - 1) % buttons.size();
                        if (selectIndex < 0) selectIndex += buttons.size();
                        printMenu();
                        break;
                    case "s":
                        selectIndex = (selectIndex + 1) % buttons.size();
                        printMenu();
                        break;
                    default:
                        printMenu();
                        break;
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + " : Invalid key.");
            }
        }
    }

    public void focus() {
        hasFocus = true;

        if (Menu.currentActiveMenu != null) {
            Menu.currentActiveMenu.unfocus();
            parentMenu = Menu.currentActiveMenu;
        }

        Menu.currentActiveMenu = this;

        printMenu();
        update();
    }

    public boolean hasFocus() {
        return hasFocus;
    }

    public void unfocus() {
        hasFocus = false;

        if (parentMenu != null) {
            Menu.currentActiveMenu = null;
            parentMenu.focus();
        }
    }

    public void printMenu() {
        Menu.clearScreen();

        StringBuilder _buttonListing = new StringBuilder();
        for (int i = 0; i < buttons.size(); i++)
            _buttonListing.append(i == selectIndex ? " -> " : "    ").append(buttons.get(i).displayName).append("\n");

        System.out.println("   " + name + "\n" +
                "-".repeat(name.length() + 6) + "\n" +
                _buttonListing);

        if (afterMenuPrintCallback != null)
            afterMenuPrintCallback.call();
    }

    public static void clearScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
