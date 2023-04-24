package com.shpp.p2p.cs.iburlaka.assignment14;

import com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses.*;

/**
 * Class with tests for the custom LinkedList and custom Queue and Stack
 * Tests LinkedList of Integers, Objects, also Stack and Queue of Strings
 */
public class TestForLinkedList {

    public static void main(String[] args) {

        System.out.println("------------------MyLinkedList<Integer>--------------------");
        /* Tests for LinkedList of Integers. Integers are added into MyArrayList through a loop
         * Methods of adding the first element and last element are tested
         * Also used class TestMethods for testing methods size(), printList(), getElement(), containsElement(),
         * isEmpty().
         */
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.printList();
        for (int i = 0; i < 7; i++) {
            testList.addElement(i * 2);
        }
        testList.addLastElement(77);
        testList.addFirstElement(99);
        testList.addFirstElement(77);
        testList.printList();

        // testing list of integers
        TestMethods.testSize(testList, 10);
        TestMethods.testFirstElement(testList, 77);
        TestMethods.testGetElement(testList, 3, 2);
        TestMethods.testContainsElement(testList, 50, false);
        TestMethods.testContainsElement(testList, 77, true);
        TestMethods.testTheSameLastAndFirstValue(testList, true);
        testList.cleanList();
        TestMethods.testIsEmpty(testList, true);

        System.out.println(testList.size());

        // testing of printing empty list
        testList.printList();

        System.out.println("------------------MyLinkedList<Object>--------------------");

        /* Tests for LinkedList of Objects.
         * Methods of adding the first element and last element are tested
         * Also used class TestMethods for testing methods size(), printList(), getElement(), containsElement(),
         * removeElement().
         */
        Fruits apple = new Fruits("apple", 100, 10);
        Fruits banana = new Fruits("banana", 50, 40);
        Fruits kiwi = new Fruits("kiwi", 50, 55);
        Vegetables potato = new Vegetables("Potato", 200, 20);
        Vegetables carrot = new Vegetables("carrot", 100, 15);

        MyLinkedList<Food> foods = new MyLinkedList<>();
        foods.addLastElement(apple);
        foods.addFirstElement(potato);
        foods.addFirstElement(carrot);
        foods.addElement(banana);
        foods.addElement(kiwi, 3);
        foods.printList();

        TestMethods.testSize(foods, 5);
        TestMethods.testContainsElement(foods, carrot, true);
        TestMethods.testTheSameLastAndFirstValue(foods, false);
        TestMethods.testIsEmpty(foods, false);
        TestMethods.testGetElement(foods, 3, kiwi);

        foods.removeLastElement();
        foods.removeElement(3);
        TestMethods.testContainsElement(foods, kiwi, false);
        TestMethods.testSize(foods, 3);
        TestMethods.testFirstElement(foods, carrot);


        System.out.println("-----------------MyStack<String>---------------------");

        /* Tests for Stack of Strings. Firstly elements are added into MyLinkedList, then added into Stack
         * (with testing method getElement() for LinkedList)
         * Methods peek(), push() and pop() are tested
         */
        MyLinkedList<String> cities = new MyLinkedList<>();
        cities.addElement("Kyiv");
        cities.addElement("Paris");
        cities.addElement("Graz");
        cities.addElement("Prague");
        cities.addElement("Warshaw");

        MyStack<String> stack = new MyLinkedList<>();
        stack.push(cities.getElement(2));
        stack.push(cities.getElement(0));
        stack.push(cities.getElement(1));
        stack.push(cities.getElement(3));
        stack.push(cities.getElement(4));
        System.out.println(stack.size());
        stack.printList();
        for (String s : stack) {
            System.out.println("Stack peek is " + stack.peek());
            stack.pop();
            System.out.println("Stack size after removing peek " + stack.size());
        }

        System.out.println("-----------------MyQueue<Object>---------------------");

        /* Tests for Queue of Strings. Elements are added into Queue with addElement() method
         * Methods getPeek(), getRemoved(), size() are tested
         */
        MyQueue<Train> schedule = new MyLinkedList<>();

        schedule.addElement(new Train(100, "Kyiv", "10.00"));
        schedule.addElement(new Train(96, "Lviv", "11.45"));
        schedule.addElement(new Train(80, "Poltava", "12.12"));
        schedule.addElement(new Train(62, "Kherson", "15.35"));
        schedule.addElement(new Train(12, "Odesa", "19.20"));

        schedule.printList();

        System.out.println("Queue size is " + schedule.size());

        System.out.println("Peek in the Queue is " + schedule.getPeek());
        System.out.println("Removed element is " + schedule.getRemoved());
        System.out.println("Removed element is " + schedule.getRemoved());
        System.out.println("Removed element is " + schedule.getRemoved());
        System.out.println("Remaining items: ");
        schedule.printList();
    }
}
