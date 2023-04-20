package com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses;

public class Food {

   private final String name;
   private final int number;
   private final int price;

    public Food(String name, int number, int price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                '}';
    }
}
