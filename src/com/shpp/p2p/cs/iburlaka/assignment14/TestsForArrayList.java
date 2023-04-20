package com.shpp.p2p.cs.iburlaka.assignment14;

import com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses.Food;
import com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses.Fruits;
import com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses.TestMethods;
import com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses.Vegetables;

public class TestsForArrayList {
    public static void main(String[] args) {

        System.out.println("\n---------------MyArrayList <String>--------------------");
        String[] city = {"Kyiv", "Lviv", "Lytsk", "Odesa", "Kharkiv", "Zhytomyr", "Kherson", "Kropyvnytskyi", "Rivne",
                "Zaporizhzhia", "Uzhorod", "Chernihiv"};
        MyArrayList<String> cities = new MyArrayList<>();
        cities.arrayToMyList(city); // adding element into list from array
        cities.printList();
        cities.add("Poltava");
        cities.setElement(2, "Khotyn");
        System.out.println(cities + " - array list after adding and setting elements");
        TestMethods.testSize(cities, 13);
        TestMethods.testElementByIndex(cities, 1, "Lviv");
        TestMethods.testElementByIndex(cities, 1, "Lutsk");

        cities.removeElement(0);
        System.out.println(cities + " - array list after removing element");
        TestMethods.testIsEmpty(cities, false);
        cities.cleanList();
        TestMethods.testIsEmpty(cities, true);

        if (cities.isEmpty()) {
            cities.add("Vinnytsia");
            cities.add("Ternopil");
        }
        for (String oneCty : cities) {
            System.out.println(oneCty + " - is added city");
        }
        TestMethods.testIndexByValue(cities, "Ternopil", 1);

        System.out.println(" \n -----------------MyArrayList <Integer>------------------");
        MyArrayList<Integer> digits = new MyArrayList<>();
        for (int i = 0; i < 26; i++) {
            digits.add(i);
        }
        digits.printList();
        TestMethods.testIsEmpty(digits, false);
        TestMethods.testIndexByValue(digits, 15, 15);
        TestMethods.testSize(digits, 26);
        TestMethods.testElementByIndex(digits, 5, 5);
        for (int element: digits) {
            if (element > 23) {
                System.out.println(element + " - is an element greater then 23");
            }
        }
        System.out.println(digits.getElement(10) + digits.getElement(20) + " - sum of the elements by index" );


        System.out.println("\n----------------MyArrayList <Object>-------------------");
        Fruits apple = new Fruits("apple", 100, 10);
        Fruits banana = new Fruits("banana", 50, 40);
        Fruits kiwi = new Fruits("kiwi", 50, 55);
        Vegetables potato = new Vegetables("Potato", 200, 20);
        Vegetables carrot = new Vegetables("carrot", 100, 15);

        MyArrayList<Food> food = new MyArrayList<>();
        food.add(apple);
        food.add(kiwi);
        food.add(potato);
        food.add(carrot);
        food.add(banana);
        food.printList();

        TestMethods.testIsEmpty(food, false);
        TestMethods.testIndexByValue(food, kiwi, 1);
        food.setElement(0, banana);
        TestMethods.testSize(food, 5);
        food.removeElement(3);
        TestMethods.testSize(food, 4);


        System.out.println("\n----------------Calculator test-------------------");
        String[] math = {"2", "+", "2", "*", "10", "/", "2"};
        String[] math2 = {"5", "^", "2", "^", "3"};
        TestMethods.testCalculator(math, 12);
        TestMethods.testCalculator(math2, 390625);

        System.out.println("-----------------------------------");

    }


}