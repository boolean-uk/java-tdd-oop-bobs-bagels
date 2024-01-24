package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BagelExtensionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testTotalCost(){
        Bagel abagel = new Bagel();
        System.setOut(new PrintStream(outContent));
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("COFB");
        abagel.addBagel("COFB");
        abagel.addBagel("COFB");
        Assertions.assertEquals(10.43, abagel.totalCost());
        abagel.basketList.clear();
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        Assertions.assertEquals(2.45, abagel.totalCost());
        abagel.basketList.clear();
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        Assertions.assertEquals(0.98, abagel.totalCost());
        abagel.basketList.clear();
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        Assertions.assertEquals(2.49, abagel.totalCost());
    }
    @Test
    public void testPrintReceipt(){
        Bagel abagel = new Bagel();
        outContent.reset();
        System.setOut(new PrintStream(outContent));
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLO");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLP");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("BGLE");
        abagel.addBagel("COFB");
        abagel.addBagel("COFB");
        abagel.addBagel("COFB");
        String receipt = "        ~~~ Bob's Bagels ~~~       \n" +
                "        2024-01-23 11:31:41\n" +
                "----------------------------------\n" +
                "Products----------Quant-Price\n" +
                "Black Coffee        3   £2.97\n" +
                "Onion Bagel         2   £0.98\n" +
                "Everything Bagel    6   £2.94\n" +
                "                      (-£0.45)\n" +
                "Plain Bagel        12   £4.68\n" +
                "                      (-£0.69)\n" +
                "----------------------------------\n" +
                "Total              23   £10.43\n" +
                "\n" +
                "    You saved a total of £6.48\n" +
                "             Thank you        \n" +
                "          for your order! ";
        Assertions.assertEquals(10.43, abagel.totalCost());
        String out = outContent.toString().trim();
        Assertions.assertTrue(out.contains("Products----------Quant-Price\n" +
                "Black Coffee        3   £2.97\n" +
                "Onion Bagel         2   £0.98\n" +
                "Everything Bagel    6   £2.94\n" +
                "                      (-£0.45)\n" +
                "Plain Bagel        12   £4.68\n" +
                "                      (-£0.69)\n" +
                "----------------------------------\n" +
                "Total              23   £10.43\n" ) );

    }

}
