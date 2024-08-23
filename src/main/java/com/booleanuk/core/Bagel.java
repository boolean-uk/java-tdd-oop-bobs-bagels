package com.booleanuk.core;
// The Bagel class allows for the creation of bagels
// It has a member variable Filling, which can contain up to three fillings
public class Bagel extends Item{
    private Filling[] Fillings;

    public Bagel(String type){
        // Here I create vector which contains no filling and set the purchaseability of the bagel to false
        // to ensure it cannot be bought before getting an identity, the Switch determines type and price
        Fillings=new Filling[3];
        switch (type){
            case "Onion":
                SKU="BGLO";
                name="Onion Bagel";
                Purchase=true;
                Price=0.49;
                break;
            case "Plain":
                SKU="BGLP";
                name="Plain Bagel";
                Purchase=true;
                Price=0.39;
                break;
            case "Everything":
                SKU="BGLE";
                name="Everything Bagel";
                Purchase=true;
                Price=0.49;
                break;
            case "Sesame":
                SKU="BGLS";
                name="Sesame Bagel";
                Purchase=true;
                Price=0.49;
                break;
            default:
                System.out.println("Not available");




        }

    }

    // the following functions determine fillings and access them. One cannot add the same filling multiple times
    // the price of the fillings are added to the bagel

    public boolean addFilling(Filling filling){
        for (int i=0; i<3; i++){
            if (Fillings[i]!=null){
                if(Fillings[i].getName()==filling.getName()){
                    System.out.println("Bagel already contains this filling");
                    return false;
                }

            }
            else{
                Fillings[i]=filling;
                this.setPrice(this.getPrice()+ filling.getPrice());
                this.setName(this.getName()+", "+filling.getName());
                return true;

            }

        }
        System.out.println("Bagel is full");
        return false;

    }

    public String[] getFillings(){
        String[] fillings= new String[3];
        for (int i=0; i<3; i++){

            fillings[i]=Fillings[i].getName();
        }
        return fillings;
    }
}

