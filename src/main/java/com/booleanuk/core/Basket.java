package com.booleanuk.core;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Basket {
    String[] basketArr;
    String[] fillingArr;
    public ArrayList<Inventory> inventoryList;

    public Basket(){
        this.basketArr = new String[35];
        //This should have been arraylist, but yeah
        this.fillingArr = new String[50];
        this.inventoryList = new ArrayList<>();
        inventoryList.add(new Bagel("BGLO",0.49d,"Bagel","Onion"));
        inventoryList.add(new Bagel("BGLP",0.39d,"Bagel","Plain"));
        inventoryList.add(new Bagel("BGLE",0.49d,"Bagel","Everything"));
        inventoryList.add(new Bagel("BGLS",0.49d,"Bagel","Sesame"));
        inventoryList.add(new Coffee("COFB",0.99d,"Coffee","Black"));
        inventoryList.add(new Coffee("COFW",1.19d,"Coffee","White"));
        inventoryList.add(new Coffee("COFC",1.29d,"Coffee","Cappuccino"));
        inventoryList.add(new Coffee("COFL",1.29d,"Coffee","Latte"));
        inventoryList.add(new Filling("FILB",0.12d,"Filling","Bacon"));
        inventoryList.add(new Filling("FILE",0.12d,"Filling","Egg"));
        inventoryList.add(new Filling("FILC",0.12d,"Filling","Cheese"));
        inventoryList.add(new Filling("FILX",0.12d,"Filling","Cream Cheese"));
        inventoryList.add(new Filling("FILS",0.12d,"Filling","Smoked Salmon"));
        inventoryList.add(new Filling("FILH",0.12d,"Filling","Ham"));
    }

    public String addProductToBasket(String product,String variant,String yesOrNo){
        //String for return
        String output = "";
        //First check if the basket is full
        if (this.basketArr[this.basketArr.length - 1] == null) {
            System.out.println("Basket has space");
            //Check if the product exists
            if(checkProduct(product)){
                    //Check what variant the user wants exists, and belongs to the product
                    if(checkVariantForProduct(product,variant)){
                        for(Inventory item : inventoryList) {
                            if (item.getName().equals(product) && item.getVariant().equals(variant)) {
                                //Ask the user if they still want it
                                ///(for the test)
                                double price = item.getPrice();
                                if (yesOrNo.equals("Yes")) {
                                    //Go through the array to find the first empty slot
                                    for (int j = 0; j < basketArr.length; j++) {
                                        //Add the bagel if the slot is empty
                                        if (this.basketArr[j] == null) {
                                            this.basketArr[j] = item.getSKU();
                                            output += item.getName() +" "+ item.getVariant() + " added to basket";
                                            //Stops the loop when the product is added
                                            break;
                                        }
                                    }
                                } else {
                                    //Stops the loop if the user doesnt want it
                                    output = "Okey then";
                                    break;
                                }
                            }
                        }
                    }else{
                        //If product doesnt exist return new output
                        output = "That variant doesnt exist";
                    }
                } else{
                    //If product doesnt exist return new output
                    output = "That product doesnt exist";
                }
        } else{
            output = "Basket is full";
        }
        return output;
    }

    public String addFilling(String variant,String yesOrNo){
        String output = "";
        if (this.fillingArr[this.fillingArr.length - 1] == null) {
            System.out.println("Fillingbasket has space");
            if (checkVariantForProduct("Filling",variant)) {
                System.out.println("Variant exists");
                for(Inventory item : inventoryList) {
                    if (item.getName().equals("Filling") && item.getVariant().equals(variant)) {
                        double price = item.getPrice();
                        System.out.println("The price is: £"+price+". Do you still want it? Write yes!");
                        if (yesOrNo.equals("Yes")) {
                            for (int j = 0; j < fillingArr.length; j++) {
                                if (this.fillingArr[j] == null) {
                                    this.fillingArr[j] = item.getSKU();
                                    this.fillingArr[j+1] = Integer.toString(lastItemBasketPosition());
                                    output += item.getName() +" "+ item.getVariant() + " added to basket";
                                    break;
                                }
                            }
                        } else {
                            output = "Okey then";
                            break;
                        }
                    }
                }
            } else{
                System.out.println("Write a valid variant");
            }
        }else{
            System.out.println("Fillingbasket is full");
        }
        return output;
    }

    public int lastItemBasketPosition(){
        //Reversed for loop to get the last item
        for (int i = basketArr.length-1; i >= 0; i--) {
            if (basketArr[i]!=null){
                for (Inventory item : inventoryList){
                    if(item.getName().equals("Bagel")){
                        if (item.getSKU().equals(basketArr[i])){
                            return i;
                        }
                    }
                }

            }
        }
        return -1;
    }

    public boolean checkProduct(String product){
        //String for return
        boolean bool = false;
            //Check if the product exists
            for (int i = 0; i < inventoryList.size(); i++) {
                Inventory item = inventoryList.get(i);
                if (item.getName().equals(product)) {
                    bool = true;
                }
            }
        return bool;
    }

    public boolean checkVariantForProduct(String product,String variant){
        //String for return
        boolean bool = false;
        //Check if the product exists
        for (int i = 0; i < inventoryList.size(); i++) {
            Inventory item = inventoryList.get(i);
            if (item.getName().equals(product) && item.getVariant().equals(variant)) {
                bool = true;
            }
        }
        return bool;
    }

    public boolean removeFromBasket(String SKU){
        //Go through the array to find the bagel
        boolean bool = false;
        for (int i = 0; i < basketArr.length; i++) {
            //Check if it is empty
            if(basketArr[i]!=null){
                //If it is the same String, remove it
                if(basketArr[i].equals(SKU)){
                    basketArr[i] = null;
                    bool = true;
                    break;
                }
            }

        }
        return bool;

    }

    public void changeBasketCapacity(int size){
        String[] newArray = new String[size];
        //Sorting algorithm from stackoverflow
        //needed it to sort the array because of null values
        Arrays.sort(basketArr, (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.compareTo(o2);
        });

        //Loop that adds values into the new array
        for (int i = 0; i < basketArr.length; i++) {
            if(basketArr[i] != null){
                newArray[i] = this.basketArr[i];
            }

        }

        //Makes the original array == the new array
        this.basketArr = newArray;
    }
    public double checkCurrentPrice(String product,String variant){
        double currentPrice = 0;
        for(Inventory item : inventoryList){
            if(item.getName().equals(product) && item.getVariant().equals(variant)){
                currentPrice += item.getPrice();
            }
        }
        return currentPrice;
    }

    public double totalCost(){
        //Item counter for discount
        int bglCounter = 0;
        int bglpCounter = 0;
        int cofbCounter = 0;
        //Return double
        double total=0.0d;
        for (int i = 0; i < basketArr.length; i++) {
            //Check if it is empty
            if(basketArr[i]!=null){
                for (Inventory item : inventoryList) {
                    if (basketArr[i].equals(item.getSKU())) {
                        //Check for discounts, if it is found, count discounts
                        if(item.getSKU().equals("BGLP")){
                            bglpCounter++;
                        }else if(item.getName().equals("Bagel")){
                            bglCounter++;
                        }else if(item.getSKU().equals("COFB")) {
                            cofbCounter++;
                        }
                        //Add the price of every item that is found
                        total+=item.getPrice();
                    }
                }
            }
        }
        //Discount boolean if discount detected
        boolean bglDisc = false;
        boolean bglpDisc = false;
        boolean cofb = false;

        //Check amount of discounts
        int bgl12Discounts = 0;
        int bgl6Discounts = 0;
        //Check if discounts are found for bagels with toppings
        if(bglCounter>=6) {
            while (bglCounter >= 6) {
                if (bglCounter >= 12) {
                    bgl12Discounts++;
                    //Subtract the difference of bagels with toppings
                    double difference = 1.89d;
                    total = total - difference;
                    //Discount detected
                    bglDisc = true;
                    //Remove the bagels to run the loop again
                    bglCounter = bglCounter - 12;
                } else if (bglCounter >= 6) {
                    bgl6Discounts++;
                    double difference1 = 0.45d;
                    total = total - difference1;
                    bglDisc = true;
                    bglCounter = bglCounter - 6;
                }
            }
        }
        //Discounts for bagel plain
        int bglp12Discounts = 0;
        if(bglpCounter>=12) {
            while (bglpCounter>=12){
                bglp12Discounts++;
                //Subtract the difference of bagel plain
                double difference = 0.69d;
                total = total - difference;
                //Discount detected
                bglpDisc = true;
                //Remove the bagels to run the loop again
                bglpCounter = bglpCounter - 12;
            }
        }

        //Check if coffee is combined with a bagel
        int cofbDiscCounter = 0;
        if (cofbCounter!=0) {
            while (cofbCounter > 0) {
                if (bglCounter > 0) {
                    //Remove the difference for every extra bagel that combines with a coffee
                    double differenceBgl = 0.23d;
                    for (int i = 0; i < bglCounter; i++) {
                        //Remove the coffee that has been discounted with a bagel
                        cofbCounter = cofbCounter - 1;
                        //Remove the bagel
                        bglCounter = bglCounter-1;
                        total = total - differenceBgl;
                        cofbDiscCounter++;
                    }
                    //Coffee discount detected
                    cofb = true;
                } else if (bglpCounter > 0) {
                    //Difference for bagel plain
                    double differenceBglp = 0.13d;
                    for (int i = 0; i < bglpCounter; i++) {
                        cofbCounter = cofbCounter - 1;
                        bglpCounter = bglpCounter-1;
                        total = total - differenceBglp;
                        cofbDiscCounter++;
                    }
                    cofb = true;
                } else{
                    //Exit the loop if none of the conditions are met
                    cofbCounter=0;
                }
            }
        }
        if(bglDisc){
            System.out.println("You got: "+bgl12Discounts+" discounts for 12 bagels with toppings");
            System.out.println("You got: "+bgl6Discounts+" discounts for 6 bagels with toppings");
        }
        if(bglpDisc){
            System.out.println("You got: "+bglp12Discounts+" discounts for 12 plain bagels");
        }
        if(cofb){
            System.out.println("You got: "+cofbDiscCounter+" discounts on your coffee black with a bagel");
        }
        //Add the total of fillingcost
        total = total + totalFillingCost();

        return Double.parseDouble(String.format("%.2f",total));

    }
    public double totalFillingCost(){
        double fillingCost = 0.0d;
        for (int i = 0; i < fillingArr.length; i++) {
            //Check if it is empty
            if(fillingArr[i]!=null){
                for (Inventory item : inventoryList) {
                    if (fillingArr[i].equals(item.getSKU())) {
                        fillingCost+=item.getPrice();
                    }
                }
            }
        }
        return fillingCost;
    }

    public String makeSimpleReceipt(){
        ArrayList<String> outputList = new ArrayList<>();
        ArrayList<String> priceList = new ArrayList<>();
        //Receipt format and text
        String output = "\t~~~ Bob's Bagels ~~~\n\n";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        output += "\t"+dateTime+"\n\n----------------------------\n\n";
        //Add products to output
        for (int i = 0; i < basketArr.length; i++) {
            //Check if it is empty
            if(basketArr[i]!=null){
                for (Inventory item : inventoryList) {
                    if (basketArr[i].equals(item.getSKU())) {
                        outputList.add(item.getName()+" "+item.getVariant()+"\t\t");
                        priceList.add(Double.toString(item.getPrice()));
                    }
                }
            }
        }
        //Add filling to the output
        for (int i = 0; i < fillingArr.length; i++) {
            //Check if it is empty
            if(fillingArr[i]!=null){
                for (Inventory item : inventoryList) {
                    if (fillingArr[i].equals(item.getSKU())) {
                        //Find the bagel it belongs to
                        int pos = Integer.parseInt(fillingArr[i+1]);
                        //Get the content of the bagel in the list
                        String oldString = outputList.get(pos);
                        //New content with added filling
                        String newString = oldString + " \n\tFilling: "+item.getVariant();
                        outputList.set(pos,newString);
                        //Get the old price and add the fillingprice
                        double price = Double.parseDouble(priceList.get(pos));
                        price = price + item.getPrice();
                        priceList.set(pos,Double.toString(price));
                    }
                }
            }
        }
        outputList = updateListForReceipt(outputList);

        //output += "Product\t\t\t\tAmount\t\tPrice\n";

        //Add the price to the array
        ArrayList<String> combined = new ArrayList<>();
        for (int i = 0; i < outputList.size(); i+=2) {
            combined.add(outputList.get(i));
            double amount = Double.parseDouble(outputList.get(i+1));
            combined.add(Double.toString(amount));

            int priceIndex = i/2;
            if (priceIndex<priceList.size()){
                double newPrice = Double.parseDouble(priceList.get(i/2))*amount;
                combined.add(Double.toString(newPrice));
            }
        }
        //Make copy over the list
        outputList = combined;


        for (int i = 0; i < outputList.size(); i+=3) {
            output += outputList.get(i)+"\t\t"+outputList.get(i+1)+"\t\t"+outputList.get(i+2)+"\n";
        }

        output += "\n\n----------------------------\nTotal: \t\t\t\t\t"+totalCost();
        output += "\n\n\t\t Thank you\n \t\tfor your order!";
        return output;
    }

    public ArrayList<String> updateListForReceipt(ArrayList<String> originalList){
        ArrayList<String> updatedList = new ArrayList<>();
        ArrayList<Integer> removeItems = new ArrayList<>();
        //Copy the content of the list and add a counter for each
        //object in the list
        for (int i = 0; i < originalList.size(); i++) {
            updatedList.add(originalList.get(i));
            updatedList.add("1");
        }
        //Count how many times the same object is inside the list
        for (int i = 0; i < updatedList.size(); i+=2) {
            for (int j = i+2; j < updatedList.size(); j+=2) {
                if(updatedList.get(i).equals(updatedList.get(j))){
                    int count = Integer.parseInt(updatedList.get(i+1));
                    count += 1;
                    updatedList.set(i+1,Integer.toString(count));
                    removeItems.add(j);
                }
            }
        }
        //Remove the position in the updatedlist that is stored in the removeItems list
        for (int i = removeItems.size()-1;i>=0; i--) {
            int removeIndex = removeItems.get(i);

            if(removeIndex+1 < updatedList.size()){
                //Remove the counter
                updatedList.remove(removeIndex+1);
            }
            if(removeIndex < updatedList.size()){
                updatedList.remove(removeIndex);
            }

        }

        return updatedList;
    }
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addFilling("Egg","Yes");
        basket.addFilling("Bacon","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addFilling("Egg","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Coffee","Black","Yes");
        basket.addProductToBasket("Coffee","Cappuccino","Yes");
        basket.addFilling("Egg","Yes");
        System.out.println(basket.makeSimpleReceipt());


        /*
        Scanner scanner = new Scanner(System.in);
        String input = "";
        //Menu for the user
        while (!input.equals("x")){
            System.out.println("\nWhat would you like to do?");
            System.out.println("Choose 'a' to add to basket\nChoose a1 to add a filling for your bagel\n" +
                    "Choose 'b' to remove from basket\n" +
                    "Choose 'c' to see total costs\nChoose 'd' to change the basket capacity\n" +
                    "Choose 'e' to check your current basket\nChoose 'x' to leave the program\n");
            input = scanner.nextLine();

            //Runs the add product funtion
            if(input.equals("a")){
                System.out.println("What product would you like?");
                String product = scanner.nextLine();
                String variant = "";
                String yesOrNo = "";
                if(basket.checkProduct(product)){
                    System.out.println("Okey! What variant would you like?");
                    variant = scanner.nextLine();
                    if(basket.checkVariantForProduct(product,variant)){
                        double price = basket.checkCurrentPrice(product,variant);
                        System.out.println("Okey! That will be £"+price+" would you still buy this? 'Yes' for yes");
                        yesOrNo = scanner.nextLine();
                        if(yesOrNo.equals("Yes")){
                            System.out.println(basket.addProductToBasket(product,variant,yesOrNo));
                            System.out.println(Arrays.toString(basket.fillingArr));
                        }else{
                            System.out.println("Okey then");
                        }
                    }else{
                        System.out.println("That variant doesnt exist");
                    }
                }else{
                    System.out.println("That product doesnt exist");
                }

            }else if(input.equals("a1")){
                System.out.println("What filling would you like for your bagel?");
                String variant = scanner.nextLine();
                String product = "Filling";
                String yesOrNo = "";
                if(basket.checkVariantForProduct(product,variant)){
                    double price = basket.checkCurrentPrice(product,variant);
                    System.out.println("Okey! That will be £"+price+" would you still buy this? 'Yes' for yes");
                    yesOrNo = scanner.nextLine();
                    if(yesOrNo.equals("Yes")){
                        System.out.println(basket.addFilling(variant,yesOrNo));
                    }else{
                        System.out.println("Okey then");
                    }
                }else{
                    System.out.println("That variant doesnt exist");
                }


            }else if(input.equals("b")){
                System.out.println("Your basket: "+Arrays.toString(basket.basketArr));
                System.out.println("What product would you like to remove?");
                String SKU = scanner.nextLine();
                boolean bool = false;
                for (int i = 0; i < basket.basketArr.length; i++) {
                    if(SKU.equals(basket.basketArr[i])){
                        bool = true;
                    }
                }
                if(bool){
                    basket.removeFromBasket(SKU);
                    System.out.println(SKU+" has been removed from basket");
                }else{
                    System.out.println("That SKU doesnt exist in basket");
                }

            }else if(input.equals("c")){
                System.out.println("The total cost of your basket is: "+basket.totalCost());
            }else if(input.equals("d")){
                System.out.println("What size should the basket be?");
                String newSize = scanner.nextLine();
                try{
                    basket.changeBasketCapacity(Integer.parseInt(newSize));
                    System.out.println("Capacity changed to "+newSize);
                }catch (Exception e){
                    System.out.println("Write a valid number");
                }
            }else if(input.equals("e")){
                System.out.println(basket.makeCleanBasket());
            }
        }



         */
    }
}

