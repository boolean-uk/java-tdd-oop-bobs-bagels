package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static com.booleanuk.core.Inventory.inventoryProducts;
import static com.booleanuk.core.Inventory.productIsInStock;

public class Basket {

    private ArrayList<Product> products;



    private HashMap<String, Integer> productCount;  //keeps counter of every sku added to the Arraylist
    private int capacity;
    Receipt receipt = new Receipt();

    BigDecimal sumSaved = BigDecimal.ZERO;


    public Basket(int capacity){
        this.products= new ArrayList<>();
        this.capacity = capacity;
        this.productCount= new HashMap<>();
    }

    //Getters and Setters
    public ArrayList<Product> getProducts() {
        return this.products;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        if(capacity>getCapacity()){
            this.capacity = capacity;
        }
    }
    public HashMap<String, Integer> getProductCount() {
        return productCount;
    }
    //gets all fillings added to the bagels of the basket
    public ArrayList<Filling> getAllFillings(){
        ArrayList<Filling> allFillings = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals("Bagel")) {
                for (Filling filling : product.getFillings()) {
                    allFillings.add(filling);
                }
            }
        }
        return allFillings;
    }

    public boolean add( String SKU){
        if(productIsInStock(SKU) && getCapacity()>products.size()){
            Product newProduct= new Product(SKU,inventoryProducts.get(SKU).getName(),inventoryProducts.get(SKU).getProductCost(),inventoryProducts.get(SKU).getVariant());
            products.add(newProduct);

            //adds SKU to HashMap or updates its value
            int thisProductInBasketCount;
            if(productCount.containsKey(SKU)){
                thisProductInBasketCount = productCount.get(SKU);
            }else{
                thisProductInBasketCount = 0;
            }

            thisProductInBasketCount++;
            productCount.put(SKU,thisProductInBasketCount);
            return true;
        }
        return false;
    }

    public boolean remove( String SKU){
        for (Product product:this.products) {
            if (product.getSKU().equals(SKU)) {
                int totalOfThisSKUinBasket = productCount.get(SKU);
                totalOfThisSKUinBasket--;
                if (totalOfThisSKUinBasket == 0) {
                    productCount.remove(SKU);   //removes it if no more of this SKU in basket
                } else{
                    productCount.put(SKU, totalOfThisSKUinBasket);  //updates hashmap
                }
                return products.remove(product);
            }
        }
        return false;
    }

    //used for extension 3
    public double calculateSavings(String SKU, int productsDiscounted, BigDecimal discount){
        BigDecimal ammountSaved = BigDecimal.valueOf(productsDiscounted * inventoryProducts.get(SKU).getProductCost());
        ammountSaved = ammountSaved.subtract(discount);
        sumSaved = sumSaved.add(ammountSaved);
        double ammountSavedDouble = ammountSaved.doubleValue();

        return ammountSavedDouble;
    }

    //used to format the text, needed for extension 3
    public String formatDisplaySavingInReceipt(double saving){
        String ammountSavedStr = "\n\t\t\t\t\t  (-"+receipt.pound+saving+")";
        return ammountSavedStr;
    }

    public double getTotalCost() {

        if (products.size() == 0) {     //if no products were added to basket return 0;
            return 0;
        }

        receipt = new Receipt();
        HashMap<String, Integer> productCountNew= new HashMap<>();
        productCountNew.putAll(productCount);
        BigDecimal sum = BigDecimal.ZERO;
        sumSaved = BigDecimal.ZERO;

        for (String keySKU : productCountNew.keySet()) {
            int totalProductsOfThisSKU = productCountNew.get(keySKU);
            Product currentProduct = inventoryProducts.get(keySKU);

            if (keySKU.equals("BGLP") && totalProductsOfThisSKU >= 12) {    //special offer for 12 plain bagels
                BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 12).multiply(BigDecimal.valueOf(3.99));

                //calculates ammount saved from this special offer
                double ammountSaved = calculateSavings(keySKU, (productCountNew.get(keySKU)/12)*12, discount);
                String ammountSavedStr = formatDisplaySavingInReceipt(ammountSaved);
                //adds the ammount saved and the discount used to the receipt
                String discountPrice = receipt.pound+discount;
                String productToReceipt = currentProduct.getVariant() +" "+ currentProduct.getName() +"\t\t\t"+ ((productCountNew.get(keySKU)/12)*12) +"\t"+ discountPrice+ammountSavedStr;
                receipt.getProductsBought().add(productToReceipt);

                productCountNew.put("BGLP",productCountNew.get("BGLP")-(productCountNew.get("BGLP")/12)*12);
                sum = sum.add(discount);

            } else if ( (keySKU.equals("BGLO") || keySKU.equals("BGLE"))  && totalProductsOfThisSKU >= 6) { //special offer for 6 onion or everything bagels
                BigDecimal discount = BigDecimal.valueOf(totalProductsOfThisSKU / 6).multiply(BigDecimal.valueOf(2.49));

                //adds this discount to receipt
                double ammountSaved = calculateSavings(keySKU, (productCountNew.get(keySKU)/6)*6, discount);
                String ammountSavedStr = formatDisplaySavingInReceipt(ammountSaved);
                String discountPrice = receipt.pound+discount;
                String productToReceipt = currentProduct.getVariant() +" "+ currentProduct.getName() +"\t\t\t"+ ((productCountNew.get(keySKU)/6)*6) +"\t"+ discountPrice+ammountSavedStr;
                receipt.getProductsBought().add(productToReceipt);

                productCountNew.put(keySKU,productCountNew.get(keySKU)-(productCountNew.get(keySKU)/6)*6);
                sum = sum.add(discount);
            }
        }

        //coffe and bagel special offer check
        int count_black_coffee = productCountNew.getOrDefault("COFB",0);
        int[] bagels_remaining= {productCountNew.getOrDefault("BGLP",0), productCountNew.getOrDefault("BGLE",0), productCountNew.getOrDefault("BGLO",0),productCountNew.getOrDefault("BGLS",0)};
        int coffee_discounts=0;
        //count black coffee discounts
        for(int i=0;i<bagels_remaining.length;i++){
            if(count_black_coffee>0 && bagels_remaining[i]>0){
                if(count_black_coffee<=bagels_remaining[i]){
                    coffee_discounts +=count_black_coffee;
                    bagels_remaining[i]-=count_black_coffee;
                    count_black_coffee -= count_black_coffee;
                }else{
                    coffee_discounts += bagels_remaining[i];
                    count_black_coffee -= bagels_remaining[i];
                    bagels_remaining[i]-=bagels_remaining[i];
                }
            }
        }

        BigDecimal ammountSaved = BigDecimal.ZERO;
        if (coffee_discounts>0){
            BigDecimal discount = BigDecimal.valueOf(coffee_discounts * 1.25);
            BigDecimal priceWithoutDiscount = BigDecimal.valueOf(coffee_discounts * 1.48);
            ammountSaved = priceWithoutDiscount.subtract(discount);
            if (productCountNew.getOrDefault("BGLP", 0) != bagels_remaining[0]) {   //if the bagel used in discount is plain then the saving is 0.10 pounds less
                ammountSaved = ammountSaved.subtract(BigDecimal.valueOf(productCountNew.get("BGLP")-bagels_remaining[0]).multiply(BigDecimal.valueOf(0.1)));
            }
            sumSaved = sumSaved.add(ammountSaved);
        }

        //calculate how many bagels and black coffees remained (were not used in any special offer)
        productCountNew.put("BGLP",bagels_remaining[0]);
        productCountNew.put("BGLE",bagels_remaining[1]);
        productCountNew.put("BGLO",bagels_remaining[2]);
        productCountNew.put("BGLS",bagels_remaining[3]);

        productCountNew.put("COFB",productCountNew.getOrDefault("COFB",0)-coffee_discounts);

        sum =sum.add(BigDecimal.valueOf((coffee_discounts*1.25)));

        //adds this discount to receipt
        if ( coffee_discounts > 0) {
            String ammountSavedStr = formatDisplaySavingInReceipt(ammountSaved.doubleValue());
            String discountPrice = receipt.pound+BigDecimal.valueOf((coffee_discounts*1.25));
            String productToReceipt = "Coffee and Bagel\t" + coffee_discounts +"\t"+ discountPrice+ammountSavedStr;
            receipt.getProductsBought().add(productToReceipt);
        }

        for(String SKU: productCountNew.keySet()){
            BigDecimal costOfProduct = BigDecimal.valueOf(inventoryProducts.get(SKU).getProductCost()).multiply(BigDecimal.valueOf(productCountNew.getOrDefault(SKU,0)));
            Product currentProduct = inventoryProducts.get(SKU);
            sum = sum.add(costOfProduct);

            if (costOfProduct.doubleValue()>0){
                //adds rest of products to receipt
                String discountPrice = receipt.pound+costOfProduct;
                String productToReceipt = currentProduct.getVariant() +" "+ currentProduct.getName() +"\t\t"+ productCountNew.get(SKU) +"\t"+ discountPrice;
                receipt.getProductsBought().add(productToReceipt);
            }
        }
        if (getAllFillings().size()>0){
            double fillingsTotalPrice = getAllFillings().size() * 0.12;
            String productToReceipt = "Fillings" +"\t\t\t"+ getAllFillings().size() +"\t"+ receipt.pound+fillingsTotalPrice;
            receipt.getProductsBought().add(productToReceipt);
            sum = sum.add(BigDecimal.valueOf(fillingsTotalPrice));
        }

        return sum.doubleValue();
    }

    public boolean printReceipt(){
        if (products.size() == 0) {     //if there are no products return false, does not print receipt;
            return false;
        }
        double totalPayed = getTotalCost();

        StringBuilder output = new StringBuilder();

        output.append("\t ~~~ Bob's Bagels ~~~\n");
        output.append("\t ").append(receipt.getDateTime()).append("\n");
        output.append("-----------------------------\n");
        for (int i = 0; i < receipt.getProductsBought().size(); i++) {
            output.append(receipt.getProductsBought().get(i)).append("\n");
        }
        output.append("-----------------------------\n");
        output.append("Total\t\t\t\t\t").append(receipt.pound).append(totalPayed).append("\n");
        output.append("\n   You saved a total of ").append(receipt.pound).append(sumSaved).append("\n\t    on this shop\n");
        output.append("\n\t     Thank you \n\t  for your order!\n");

        String outputString = output.toString();
        System.out.println(outputString);
        return true;
    }

    public boolean placeOrder(String fromPhoneNumber,String toPhoneNumber){
        double totalPayed = getTotalCost();
        SMS orderSMS = new SMS();
        StringBuilder SMSContent = new StringBuilder();
        SMSContent.append("\t ~~~ Bob's Bagels ~~~\n");
        SMSContent.append("\t ~~~ Order Summary ~~~\n");

        SMSContent.append("\t ").append(receipt.getDateTime()).append("\n");
        SMSContent.append("-----------------------------\n");
        for (int i = 0; i < receipt.getProductsBought().size(); i++) {
            SMSContent.append(receipt.getProductsBought().get(i)).append("\n");
        }
        SMSContent.append("-----------------------------\n");
        SMSContent.append("Total\t\t\t\t\t").append(receipt.pound).append(totalPayed).append("\n");
        SMSContent.append("\n   You saved a total of ").append(receipt.pound).append(sumSaved).append("\n\t    on this shop\n");
        SMSContent.append("\n\t     Thank you \n\t  for your order!\n");
        int estimatedTime = new Random().nextInt(51)+5;

        SMSContent.append("Estimated delivery time: "+estimatedTime+" minutes.");
        orderSMS.setSMSContent(SMSContent);
        orderSMS.printSMS();//TODO: 17-May-23 send sms


        String response =orderSMS.sendSMS(fromPhoneNumber,toPhoneNumber,SMSContent.toString());
        if(response!=null){
            System.out.println("successful SMS SSID : "+response);

        }else{
            System.out.println("SMS failed");

        }

        return true;
    }



}
