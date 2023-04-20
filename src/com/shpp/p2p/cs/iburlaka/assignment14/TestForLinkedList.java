package com.shpp.p2p.cs.iburlaka.assignment14;

import com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestForLinkedList {

    public static void main(String[] args) {

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
//        testList.cleanList();
        TestMethods.testIsEmpty(testList, true);

        System.out.println(testList.size());
        testList.printList();

        System.out.println("--------------------------------------");

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


        System.out.println("--------------------------------------");
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
            System.out.println(stack.peek());
            stack.pop();
            System.out.println(stack.size());
        }


        Queue<Integer> a = new LinkedList<>();
        a.add(12);
        a.add(13);
        a.add(14);
        System.out.println(a.poll());
        System.out.println("Peek");
        System.out.println(a.peek());
        System.out.println(" rem " + a.remove());
        System.out.println(a.poll());


        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);


        MyQueue<Train> schedule = new MyLinkedList<>();

        schedule.addElement(new Train(100, "Kyiv", "10.00"));
        schedule.addElement(new Train(96, "Lviv", "11.45"));
        schedule.addElement(new Train(80, "Poltava", "12.12"));
        schedule.addElement(new Train(62, "Kherson", "15.35"));
        schedule.addElement(new Train(12, "Odesa", "19.20"));

        schedule.printList();

        System.out.println(schedule.size());
        System.out.println("Last element in cities is " + cities.getLast());
        System.out.println(testList.getLast());

        System.out.println("Peek in the Queue is " + schedule.getPeek());
        System.out.println("Removed element is " + schedule.getRemoved());
        System.out.println("Removed element is " + schedule.getRemoved());
        System.out.println("Removed element is " + schedule.getRemoved());
        System.out.println("Remaining items: ");
        schedule.printList();

        testList.cleanList();
        if ( testList.containsElement(12)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
