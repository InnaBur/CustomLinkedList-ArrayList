package com.shpp.p2p.cs.iburlaka.assignment14;

import com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses.Calculator;

/**
 * Class for testing custom ArrayList and LinkedList
 * uses generic methods
 */
public class TestMethods {

    /**
     * tests getIndex() method for MyArrayList
     */
    public static <T> void testIndexByValue(MyArrayList<T> arrayList, T value, int index) {
        if (arrayList.containsValue(value)) {
            if (arrayList.getIndex(value) == index) {
                System.out.println("Pass! Index of " + value + " is " + arrayList.getIndex(value) +
                        " expecting result is " + index + " - Test 'Index by value'");
            } else {
                System.out.println("Fail!  Index of " + value + " is " + arrayList.getIndex(value) +
                        " expecting result is  " + index + "- Test 'Index by value'");
            }
        }
    }

    /**
     * tests calculator for MyArrayList
     */
    static void testCalculator(String[] math, double expectedResult) {
        MyArrayList<String> formula = new MyArrayList<>();
        formula.arrayToMyList(math);
        System.out.println("Formula " + formula);
        double result = Calculator.calculate(formula);
        if (result == expectedResult) {
            System.out.println("Pass! " + Calculator.calculate(formula) +
                    " is " + expectedResult + " - Test 'Calculator'");
        } else {
            System.out.println("Fail! " + Calculator.calculate(formula) +
                    " is not " + expectedResult + " - Test 'Calculator'");
        }
    }

    /**
     * tests size() method for MyArrayList
     */
    static <T> void testSize(MyArrayList<T> arrayList, int expectedResult) {
        if (arrayList.size() == expectedResult) {
            System.out.println("Pass! Size is " + arrayList.size() +
                    ", expected result is " + expectedResult + " - Test 'Size'");
        } else {
            System.out.println("Fail! Size is " + arrayList.size() +
                    ", expected result is " + expectedResult + " - Test 'Size'");
        }
    }

    /**
     * tests isEmpty() method for MyArrayList
     * expected result can be true and false
     */
    static <T> void testIsEmpty(MyArrayList<T> arrayList, boolean expectedResult) {
        if ((arrayList.size() == 0) && (expectedResult)) {
            System.out.println("Pass! List is empty, expected result is " + true + " - Test 'Is Empty'");
        } else if ((arrayList.size() != 0) && (!expectedResult)) {
            System.out.println("Pass! List is not empty, expected result is " + false + " - Test 'Is Empty'");
        } else {
            System.out.println("Fail! List is not empty, expected result is " + expectedResult + " - Test 'Is Empty'");
        }
    }

    /**
     * tests getElement() method for MyArrayList
     */
    static <T> void testElementByIndex(MyArrayList<T> arrayList, int index, T expectedResult) {
        if (arrayList.getElement(index).equals(expectedResult)) {
            System.out.println("Pass! " + arrayList.getElement(index) +
                    " is " + expectedResult + " - Test 'ElementByIndex'");
        } else {
            System.out.println("Fail! " + arrayList.getElement(index) +
                    " is not " + expectedResult + " - Test 'ElementByIndex'");
        }
    }

    /**
     * tests getElement() method for MyArrayList and tests Class for Objects
     */
    static <T> void testClass(MyArrayList<T> arrayList, int index, int index2) {
        if (arrayList.getElement(index).getClass() == arrayList.getElement(index2).getClass()) {
            System.out.println("Same classes! " + arrayList.getElement(index2).getClass() + " - Test 'Class'");
        } else {
            System.out.println("Different classes! " + arrayList.getElement(index).getClass() +
                    " is not " + arrayList.getElement(index2).getClass() + " - Test 'Class'");
        }
    }

    /**
     * tests size() method into MyLinkedList
     */
    static <T> void testSize(MyLinkedList<T> linkedList, int expectedResult) {
        if (linkedList.size() == expectedResult) {
            System.out.println("Pass! Size is " + linkedList.size() +
                    ", expected result is " + expectedResult + " - Test 'Size'");
        } else {
            System.out.println("Fail! Size is " + linkedList.size() +
                    ", expected result is " + expectedResult + " - Test 'Size'");
        }
    }

    /**
     * tests getFirst() method into MyLinkedList
     */
    static <T> void testFirstElement(MyLinkedList<T> linkedList, T expectedResult) {
        if (linkedList.getFirst().equals(expectedResult)) {
            System.out.println("Pass! First element is " + linkedList.getElement(0) +
                    ", expected result  is " + expectedResult + " - Test 'FirstElement'");
        } else {
            System.out.println("Fail! " + linkedList.getElement(0) +
                    ",  expected result is  " + expectedResult + " - Test 'FirstElement'");
        }
    }

    /**
     * tests getElement(int index) method into MyLinkedList
     */
    static <T> void testGetElement(MyLinkedList<T> linkedList, int index, T expectedResult) {
        if (linkedList.getElement(index).equals(expectedResult)) {
            System.out.println("Pass! Element is " + linkedList.getElement(index) +
                    ", expected result  is " + expectedResult + " - Test 'GetElement'");
        } else {
            System.out.println("Fail! Element is " + linkedList.getElement(index) +
                    ",  expected result is  " + expectedResult + " - Test 'GetElement'");
        }
    }

    /**
     * tests isEmpty() method into MyLinkedList
     */
    static <T> void testIsEmpty(MyLinkedList<T> linkedList, boolean expectedResult) {
        if ((linkedList.size() == 0) && (expectedResult)) {
            System.out.println("Pass! List is empty, expected result is " + true + " - Test 'Is Empty'");
        } else if ((linkedList.size() != 0) && (!expectedResult)) {
            System.out.println("Pass! List is not empty, expected result is " + false + " - Test 'Is Empty'");
        } else {
            System.out.println("Fail! List is not empty, expected result is " + expectedResult + " - Test 'Is Empty'");
        }
    }

    /**
     * tests containsElement() method into MyLinkedList
     */
    static <T> void testContainsElement(MyLinkedList<T> linkedList, T element, boolean expectedResult) {
        if (linkedList.containsElement(element)) {
            System.out.println("Pass! Element " + element + " is in the list, expected result is " +
                    expectedResult + " - Test 'containsElement'");
        } else if (!linkedList.containsElement(element) && !expectedResult) {
            System.out.println("Pass! Element " + element + " is not in the list, expected result is " +
                    false + " - Test 'containsElement'");
        } else {
            System.out.println("Fail! Element " + element + " is not in the list, expected result is " +
                    expectedResult + " - Test 'containsElement'");
        }
    }

    /**
     * tests getFirst() and getLast() methods into MyLinkedList
     */
    static <T> void testTheSameLastAndFirstValue(MyLinkedList<T> linkedList, boolean expectedResult) {
        if (linkedList.getFirst() == linkedList.getLast()) {
            System.out.println("Pass! First value " + linkedList.getFirst() + " equals last value " +
                    linkedList.getLast() + ", expected result is " + expectedResult + " - Test 'Same values'");
        } else if (!(linkedList.getFirst() == linkedList.getLast()) && !expectedResult) {
            System.out.println("Pass! First value " + linkedList.getFirst() + " not equals last value " +
                    linkedList.getLast() + ", expected result is " + false + " - Test 'Same values'");
        } else {
            System.out.println("Fail! First value " + linkedList.getFirst() + " not equals last value " +
                    linkedList.getLast() + ", expected result is " + expectedResult + " - Test 'Same values'");
        }
    }
}
