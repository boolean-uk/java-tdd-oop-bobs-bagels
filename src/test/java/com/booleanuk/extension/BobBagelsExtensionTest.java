package com.booleanuk.extension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BobBagelsExtensionTest {


    BasketExt basketExt;
    InventoryExt inventoryExt;
    BasketManager basketManager;
    PaymentFinalizer paymentFinalizer;

    ReceiptCreator receiptCreator;

    DiscountCreator discountCreator;
    BagelExt bagelO;
    BagelExt bagelP;
    BagelExt bagelE;
    BagelExt bagelS;
    CoffeeExt coffeeB;
    CoffeeExt coffeeW;
    CoffeeExt coffeeC;
    CoffeeExt coffeeL;
    FillingExt fillingB;
    FillingExt fillingE;
    FillingExt fillingC;
    FillingExt fillingX;
    FillingExt fillingS;
    FillingExt fillingH;

    @BeforeEach
    public void prepareToTests() {
        receiptCreator = new ReceiptCreator();
        basketExt = new BasketExt();
        inventoryExt = new InventoryExt();
        discountCreator = new DiscountCreator();
        paymentFinalizer = new PaymentFinalizer(discountCreator);
        basketManager = new BasketManager(basketExt,inventoryExt,discountCreator,receiptCreator,paymentFinalizer);
        bagelO = new BagelExt(SkuExt.BGLO, "Bagel", 0.49);
        bagelP = new BagelExt(SkuExt.BGLP, "Bagel", 0.39);
        bagelE = new BagelExt(SkuExt.BGLE, "Bagel", 0.49);
        bagelS = new BagelExt(SkuExt.BGLS, "Bagel", 0.49);
        coffeeB = new CoffeeExt(SkuExt.COFB, "Coffee", 0.99);
        coffeeW = new CoffeeExt(SkuExt.COFW, "Coffee", 1.19);
        coffeeC = new CoffeeExt(SkuExt.COFC, "Coffee", 1.29);
        coffeeL = new CoffeeExt(SkuExt.COFL, "Coffee", 1.29);
        fillingB = new FillingExt(SkuExt.FILB, "Filling", 0.12);
        fillingE = new FillingExt(SkuExt.FILE, "Filling", 0.12);
        fillingC = new FillingExt(SkuExt.FILC, "Filling", 0.12);
        fillingX = new FillingExt(SkuExt.FILX, "Filling", 0.12);
        fillingS = new FillingExt(SkuExt.FILS, "Filling", 0.12);
        fillingH = new FillingExt(SkuExt.FILX, "Filling", 0.12);
    }


    @Test
    public void shouldAddBagelToBasket() {
        //when
        basketManager.add(bagelO);
        //then
        assertTrue(basketExt.getBagelsInBasket().contains(bagelO));

    }

    @Test
    public void shouldAddCoffeeToBasket(){
        //when
        basketManager.add(coffeeB);
        //then
        assertTrue(basketExt.getCoffeesInBasket().contains(coffeeB));
    }

    @Test
    public void shouldAddFillingToBasket(){
        //when
        basketManager.add(fillingB);
        //then
        assertTrue(basketExt.getFillingInBasket().contains(fillingB));
    }

    @Test
    public void shouldRemoveBagelFromBasket(){
        //given
        basketManager.add(bagelO);
        //when
        basketManager.remove(bagelO);
        //then
        assertFalse(basketExt.getBagelsInBasket().contains(bagelO));
    }

    @Test
    public void shouldRemoveCoffeeFromBasket(){
        //given
        basketManager.add(coffeeB);
        //when
        basketManager.remove(coffeeB);
        //then
        assertFalse(basketExt.getCoffeesInBasket().contains(coffeeB));
    }

    @Test
    public void shouldRemoveFillingFromBasket(){
        //given
        basketManager.add(fillingB);
        //when
        basketManager.remove(fillingB);
        //then
        assertFalse(basketExt.getFillingInBasket().contains(fillingB));
    }

    @Test
    public void shouldNotAdd6ProductToBasket(){
        //given
        basketManager.add(fillingB);
        basketManager.add(fillingC);
        basketManager.add(fillingS);
        basketManager.add(bagelE);
        basketManager.add(coffeeB);
        basketManager.add(coffeeC);
        //when
        basketManager.add(fillingE);
        System.out.println(basketExt.getFillingInBasket());
        //then
        assertFalse(basketExt.getFillingInBasket().contains(fillingE));

    }

    @Test
    public void shouldChangeCapacityTo10() {
        //when
        basketExt.setCapacity(10);
        //then
        assertEquals(10, basketExt.getCapacity());
    }

    @Test
    public void shouldReturnFalseIfSanityIsNotOk() {
        //given
        boolean isOk;
        //when
        isOk = basketManager.remove(bagelE);
        //then
        assertFalse(isOk);
    }

    @Test
    public void shouldReturnTotalCostOfBasket(){
        //given
        basketManager.add(fillingB);
        basketManager.add(bagelE);
        basketManager.add(coffeeB);
        //when
        double totalCost = basketManager.getTotalCost();

        //then
        assertEquals(1.60,totalCost);

    }

    @Test
    public void ShouldAddFillingToTheBagel() {
        //when
        basketManager.addFillingToBagel(bagelE, fillingB);
        //then
        assertEquals(bagelE.getFillingExt(), fillingB);
    }

    @Test
    public void shouldReturnsFillingPriceList() {
        //given
        String pricelist = "Fillings Pricelist:\n" +
                "Name:FILB Bacon Price: 0.12\n" +
                "Name:FILE EGG Price: 0.12\n" +
                "Name:FILC Cheese Price: 0.12\n" +
                "Name:FILX Cream_Cheese Price: 0.12\n" +
                "Name:FILS Smoked_Salmon Price: 0.12\n" +
                "Name:FILH Ham Price: 0.12\n";

        //when
        String fillingPriceList = basketManager.getPriceListOfFillings();
        //then
        assertEquals(pricelist, fillingPriceList);
    }
    @Test
    public void shouldReturnsBagelsPriceList(){
        //given
        String pricelist ="Bagels Pricelist:\n" +
                "Name:BGLO Onion Price: 0.49\n" +
                "Name:BGLP Plain Price: 0.39\n" +
                "Name:BGLE Everything Price: 0.49\n" +
                "Name:BGLS Sesame Price: 0.49\n";
        //when
        String bagelsPriceList = basketManager.getPriceListOfBagels();
        //then
        assertEquals(pricelist, bagelsPriceList);
    }


    @Test
    public void shouldReturnFalseIfProductIsNotInTheInventory(){
        //given
        BagelExt bagelExt = new BagelExt();

        //when
        boolean canAddBagelTheBasketThatIsNotInTheInventory = basketManager.add(bagelExt);
        //then
        assertFalse(canAddBagelTheBasketThatIsNotInTheInventory);
    }



    @Test
    public void shouldReturnTrueForTwelveSameBagels(){
        //given
        basketExt.setCapacity(20);
        for(int i = 0; i < 12; i++){
            basketManager.add(bagelE);
        }
        //when
        basketManager.countBagelsInBasket();
        boolean isDiscount = discountCreator.isSpecialBGLETwelveOffer();
        //then
        assertTrue(isDiscount);
    }


    @Test
    public void shouldReturnFirstPartOfReceiptForOrder(){
        //given
        LocalDateTime date = LocalDateTime.of(2023,7,15,21,36,31);
        receiptCreator.setReceiptCreatedAt(date);
        String howShouldLook = "\n" +
                "    ~~~ Bob's Bagels ~~~    \n" +
                "   2023-JULY-15 21:36:31    \n" +
                "---------------------------";
        //when
        String receipt = receiptCreator.CreateFirstPartOfReceipt(basketExt);
        //then
        assertEquals(howShouldLook,receipt);
    }

    @Test
    public void shouldReturnTrueForCoffeeAndBagelPromo(){
        //given
        basketManager.add(bagelE);
        basketManager.add(coffeeW);
        basketManager.countBagelsInBasket();
        //when
        boolean isCoffeePromo = discountCreator.isSpecialCoffeeAndBagelPromo(basketExt);

        //then
        assertTrue(isCoffeePromo);
    }

    @Test
    public void shouldReturnMainPartOfReceipt(){
       //given
        LocalDateTime date = LocalDateTime.of(2023,7,15,21,36,31);
        receiptCreator.setReceiptCreatedAt(date);
        String correctREceipt = "\n    ~~~ Bob's Bagels ~~~    \n" +
                "   2023-JULY-15 21:36:31    \n" +
                "---------------------------\n" +
                "\n" +
                "Plain Bagel  12  3.99       \n" +
                "               $-0.69\n" +
                "Onion Bagel  12  3.99       \n" +
                "               $-1.89\n" +
                "Cheese Filling  1 0.12\n" +
                "Bacon Filling  2 0.24\n" +
                "---------------------------\n" +
                "      TOTAL: 8.339999999999998\n" +
                "You saved a total of: $2.58\n" +
                "Thank you for your order!\n";
        basketExt.setCapacity(30);
        for(int i = 0; i < 12; i++){
            basketManager.add(bagelO);
            basketManager.add(bagelP);
        }
        basketExt.add(fillingB);
        basketExt.add(fillingB);
        basketManager.add(fillingC);
        //when
       String receipt = basketManager.createReceipt();

        //then
        assertEquals(correctREceipt,receipt);
    }










}

