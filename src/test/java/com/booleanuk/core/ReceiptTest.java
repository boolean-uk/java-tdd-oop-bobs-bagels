package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
    @Test
    public void testPrintReceipt() {
        List<ReceiptItem> receiptItems = new ArrayList<>();
        receiptItems.add(new ReceiptItem("BGLO", 0.49, "Bagel", "Onion", 2));
        receiptItems.add(new ReceiptItem("BGLP", 0.39, "Bagel", "Plain", 12));
        receiptItems.add(new ReceiptItem("BGLE", 0.49, "Bagel", "Everything", 6));
        receiptItems.add(new ReceiptItem("COFB", 0.99, "Coffee", "Black", 3));

        Receipt receipt = new Receipt(receiptItems);

        // Capture the printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);

        receipt.printReceipt();

        System.out.flush();
        System.setOut(originalPrintStream);

        String printedReceipt = outputStream.toString();

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String expectedReceipt = "~~~ Bob's Bagels ~~~\n\n" +
                currentDate + "\n\n" +
                "----------------------------\n\n" +
                "Bagel (Onion)\t2\t£0.98\n" +
                "Bagel (Plain)\t12\t£4.68\n" +
                "Bagel (Everything)\t6\t£2.94\n" +
                "Coffee (Black)\t3\t£2.97\n" +
                "\n" +
                "----------------------------\n" +
                "Total\t\t\t£11.57\n" +
                "\n" +
                "Thank you\n" +
                "for your order!\n" +
                "~~~ Bob's Bagels ~~~\n\n" +
                currentDate + "\n\n" +
                "----------------------------\n\n";

        expectedReceipt = expectedReceipt.replace("£", "");

        printedReceipt = printedReceipt.replace("£", "");

        assertEquals(expectedReceipt.trim(), printedReceipt.trim());
    }
}
