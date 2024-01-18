package com.booleanuk.core;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Basket {
    String[] basketArr;
    public ArrayList<Inventory> inventoryList;

    public Basket(){
        this.basketArr = new String[5];
        this.inventoryList = new ArrayList<>();
        inventoryList.add(new Inventory("BGLO",0.49d,"Bagel","Onion"));
        inventoryList.add(new Inventory("BGLP",0.39d,"Bagel","Plain"));
        inventoryList.add(new Inventory("BGLE",0.49d,"Bagel","Everything"));
        inventoryList.add(new Inventory("BGLS",0.49d,"Bagel","Sesame"));
        inventoryList.add(new Inventory("COFB",0.99d,"Coffee","Black"));
        inventoryList.add(new Inventory("COFW",1.19d,"Coffee","White"));
        inventoryList.add(new Inventory("COFC",1.29d,"Coffee","Cappuccino"));
        inventoryList.add(new Inventory("COFL",1.29d,"Coffee","Latte"));
        inventoryList.add(new Inventory("FILB",0.12d,"Filling","Bacon"));
        inventoryList.add(new Inventory("FILE",0.12d,"Filling","Egg"));
        inventoryList.add(new Inventory("FILC",0.12d,"Filling","Cheese"));
        inventoryList.add(new Inventory("FILX",0.12d,"Filling","Cream Cheese"));
        inventoryList.add(new Inventory("FILS",0.12d,"Filling","Smoked Salmon"));
        inventoryList.add(new Inventory("FILH",0.12d,"Filling","Ham"));
    }

    public ArrayList<Inventory> getInventoryList(){
        return inventoryList;
    }

    public String addProductToBasket(String product,String variant,String yesOrNo){
        //String for return
        String output = "";
        System.out.println("What product would you like?");
        System.out.println(product);
        //First check if the basket is full
        if (this.basketArr[this.basketArr.length - 1] == null) {
            System.out.println("Basket has space");
            //Check if the product exists
            if(checkProduct(product)){
                    System.out.println("Product exists");
                    System.out.println("What variant would you like?");
                    System.out.println(variant);
                    //Check what variant the user wants exists, and belongs to the product
                    if(checkVariantForProduct(product,variant)){
                        for(Inventory item : inventoryList) {
                            if (item.getName().equals(product) && item.getVariant().equals(variant)) {
                                //Ask the user if they still want it
                                double price = item.getPrice();
                                System.out.println("The price is: " + price + ". Do you still want it?");
                                System.out.println(yesOrNo);
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
        basketArr = newArray;
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
        double total=0.0d;
        for (int i = 0; i < basketArr.length; i++) {
            //Check if it is empty
            if(basketArr[i]!=null){
                for (Inventory item : inventoryList) {
                    if (basketArr[i].equals(item.getSKU())) {
                        total+=item.getPrice();
                    }
                }
            }

        }
        return total;
    }
    public static void main(String[] args) {
        Basket basket = new Basket();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        basket.addProductToBasket("Coffee","Black","Yes");
        //Menu for the user
        while (!input.equals("x")){
            System.out.println("\nWhat would you like to do?");
            System.out.println("Choose 'a' to add to basket\nChoose 'b' to remove from basket\n" +
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
                        }else{
                            System.out.println("Okey then");
                        }
                    }else{
                        System.out.println("That variant doesnt exist");
                    }
                }else{
                    System.out.println("That product doesnt exist");
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
                }catch (Exception e){
                    System.out.println("Write a valid number");
                }
            }else if(input.equals("e")){
                System.out.println("Your basket: "+Arrays.toString(basket.basketArr));
            }
        }


        /*
        String product = "Coffee";
        String variant = "Black";
        System.out.println(basket.addProductToBasket(product,variant,"Yes"));
        System.out.println(basket.addProductToBasket(product,variant,"Yes"));
        System.out.println(basket.addProductToBasket("Bagel","Plain","Yes"));
        System.out.println("Totalcost: "+basket.totalCost());
        System.out.println(Arrays.toString(basket.basketArr));
        basket.removeFromBasket("COFB");
        System.out.println(Arrays.toString(basket.basketArr));

        /*
        System.out.println(basket.addBagelToBasket("Bogle"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(basket.addBagelToBasket("Bagel"));
        System.out.println(Arrays.toString(basket.basketArr));

         */

    }
    /*
    public String addBagelToBasket(String product,String variant,String yesOrNo){
        //String for return
        String output = "";
        System.out.println("What product would you like?");
        System.out.println(product);
        //First check if the basket is full
        if (this.basketArr[this.basketArr.length - 1] == null) {
            System.out.println("Basket has space");
            //Check if the product exists
            for (int i = 0;i<inventoryList.size();i++) {
                Inventory item = inventoryList.get(i);
                if (item.getName().equals(product)) {
                    System.out.println("Product exists");
                    System.out.println("What variant would you like?");
                    System.out.println(variant);
                    //Check what variant the user wants
                    for (Inventory item2 : inventoryList){
                        if (item2.getVariant().equals(variant)){
                            System.out.println("Variant exists");
                            //Ask the user if they still want it
                            double price = item2.getPrice();
                            System.out.println("The price is: "+price+". Do you still want it?");
                            System.out.println(yesOrNo);
                            if (yesOrNo.equals("Yes")) {
                                //Go through the array to find the first empty slot
                                for (int j = 0; j < basketArr.length; j++) {
                                    //Add the bagel if the slot is empty
                                    if (this.basketArr[j] == null) {
                                        this.basketArr[j] = item2.getSKU();
                                        output += item2.getName() + item2.getVariant()+" added to basket";
                                        //Stops the loop when the product is added
                                        break;
                                    }
                                }
                            }else{
                                //Stops the loop if the user doesnt want it
                                output = "Okey then";
                                break;
                            }
                        } else{
                            //If variant doesnt exist return new output
                            output = "That variant doesnt exist";
                            break;
                        }
                    }


                } else{
                    //If product doesnt exist return new output
                    output = "That product doesnt exist";
                    break;
                }

            }

        } else{
            output = "Basket is full";
        }

        return output;
    }



     */
}

