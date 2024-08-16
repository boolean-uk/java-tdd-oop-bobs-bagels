package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Reciept;
import com.booleanuk.core.RecieptItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExtensionTest {
    @Test
    public void testGetTotalCostSpecialOffer(){
        Basket basket = new Basket(10);
        Bagel bagelE = new Bagel("BGLE", 0.49, "Bagel", "Everything");
        Bagel bagelS = new Bagel("BGLS", 0.49, "Bagel", "Sesame");
        basket.addItem(bagelE);
        basket.addItem(bagelE);
        basket.addItem(bagelE);
        basket.addItem(bagelS);
        basket.addItem(bagelS);
        basket.addItem(bagelS);

        Assertions.assertEquals(2.94, basket.getTotalCost(), 0.001);
    }

    @Test
    public void receiptBagelAndCoffeeTest(){
        List<RecieptItem> recieptItemList = new ArrayList<>();
        recieptItemList.add(new RecieptItem("BGLP", 0.39,"Bagel","Plain", 12));
        recieptItemList.add(new RecieptItem("COFB", 0.99, "Coffee", "Black", 5));

        Reciept reciept = new Reciept(recieptItemList);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream realReceipt = System.out;
        System.setOut(printStream);

        reciept.getReceipt();
        System.out.flush();
        System.setOut(realReceipt);
        String printed = byteArrayOutputStream.toString();

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String expected = "~~~ Bob's Bagels ~~~\n\n"
                + date + "\n\n"
                + "----------------------------\n\n"
                + "Bagel (Plain)\t12\t£4.68\n"
                + "Cofee (Black)\t3\t£4.95\n"
                + "\n"
                + "----------------------------\n"
                + "Total\t\t\t£9.63\n"
                + "\n"
                + "Thank you\n"
                + "for your order!\n"
                + "~~~ Bob's Bagels ~~~\n\n"
                + date + "\n\n"
                + "----------------------------\n"
                + "You saved a total of £0.69 \n";

        String[] expectedLines = expected.split("\\r?\\n");
        String[] actualLines = printed.split("\\r?\\n");

        Assertions.assertEquals(expectedLines.length, actualLines.length, "Receipt line count isn't the same");
    }
}
