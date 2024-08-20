package com.booleanuk.core;

public class Bagel extends Item{
    private Filling[] Fillings;

    public Bagel(String type){

        Fillings=new Filling[3];
        this.setPurchase(false);
        switch (type){
            case "Onion":
                this.setSku("BGLO");
                this.setName("Onion");
                this.setPurchase(true);
                this.setPrice(0.49);
                this.setType("Bagel");
                break;
            case "Plain":
                this.setSku("BGLP");
                this.setName("Plain");
                this.setPurchase(true);
                this.setPrice(0.39);
                this.setType("Bagel");
                break;
            case "Everything":
                this.setSku("BGLE");
                this.setName("Everything");
                this.setPurchase(true);
                this.setPrice(0.49);
                this.setType("Bagel");
                break;
            case "Sesame":
                this.setSku("BGLS");
                this.setName("Sesame");
                this.setPurchase(true);
                this.setPrice(0.49);
                this.setType("Bagel");
                break;
            default:
                System.out.println("Not available");




        }

    }

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

