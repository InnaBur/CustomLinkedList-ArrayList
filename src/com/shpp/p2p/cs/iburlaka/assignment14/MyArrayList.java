package com.shpp.p2p.cs.iburlaka.assignment14;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class implements methods for the custom array list - dynamical list, based on the array
 * in the class there are field array with starts size
 * and a field index - pointer on the current element in the array
 */
public class MyArrayList<T> implements Iterable<T> {

    // the initial size of the array
    final static int ARRAY_SIZE = 10;
    private Object[] array = new Object[ARRAY_SIZE];

    // current pointer`s position in the array
    private int index = 0;

    /**
     * adds an element into array list and if array is full it`s increased
     * field index is increased
     *
     * @param value - inputted value
     */
    public void add(T value) {
        if (index == array.length) {
            increaseArray();
        }
        array[index] = value;
        index++;
    }

    /**
     * adds array with multiply values to the array list
     * (the convenience is that you don't have to add an element many times through an add method)
     *
     * @param arr - inputted array with values
     */
    public void arrayToMyList(T[] arr) {
        for (T t : arr) {
            array[index] = t;
            index++;
            if (index == array.length) {
                increaseArray();
            }
        }
    }

    /**
     * converts dynamical array to a string
     *
     * @return array list into String
     */
    public String toString() {
        if (index == 0) {
            return "[]";
        } else if (index < array.length) {
            Object[] arrayNew = array.clone();
            array = new Object[index];
            System.arraycopy(arrayNew, 0, array, 0, index);
            return Arrays.toString(array);
        } else {
            return Arrays.toString(array);
        }
    }

    /**
     * outputs the list to the console as a string
     */
    public void printList() {
        for (int k = 0; k < index; k++) {
            if ((k == index - 1)) {
                System.out.println(array[k] + "]");
            } else if (k == 0) {
                System.out.print("[" + array[k] + ", ");
            } else {
                System.out.print(array[k] + ", ");
            }
        }
    }

    /**
     * removes an element from the list by the index
     * decreases index
     * if index is more than array length, IndexOutOfBoundsException() is thrown
     *
     * @param j - inputted index
     */
    public void removeElement(int j) {
        if (j >= array.length) {
            throw new IndexOutOfBoundsException();
        } else {
            Object[] temp = array.clone();
            array = new Object[temp.length - 1];
            for (int i = 0; i < array.length; i++) {
                if (i < j) {
                    array[i] = temp[i];
                } else {
                    array[i] = temp[i + 1];
                }
            }
            index--;
        }
    }

    /**
     * replaces the element in place of the element with the given index
     *
     * @param j     - inputted index
     * @param value - inputted value
     */
    public void setElement(int j, T value) {
        if (isEmpty() || j >= size()) {
            throw new IndexOutOfBoundsException("Index " + j + " is out of bounds. ArrayList length is " + size());
        } else {
            for (int i = 0; i < array.length; i++) {
                if (i == j) {
                    array[i] = value;
                }
            }
        }
    }

    /**
     * gets an element by the inputted index
     * if inputted index more than current position in array
     *
     * @param j - inputted index
     * @return - value from the list in inputted index
     */
    public T getElement(int j) {
        if (j >= index) {
            throw new IndexOutOfBoundsException();
        } else {
            return (T) array[j];
        }
    }

    /**
     * gets an index by the inputted value
     * if this value isn`t in the list, returns -1 (like in real ArrayList)
     *
     * @param value - inputted value
     * @return - index of the needed value
     */
    public int getIndex(T value) {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * checks if there is needed value in the ArrayList
     *
     * @param value - inputted value
     * @return - true is value is in the list
     */
    public boolean containsValue(T value) {
        for (Object o : array) {
            if (o == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return size of the MyArrayList
     */
    public int size() {
        return index;
    }

    /**
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return (index == 0);
    }

    /**
     * cleans the list
     */
    public void cleanList() {
        for (int i = index - 1; i >= 0; i--) {
            array[i] = null;
            index--;
        }
    }

    /**
     * increases an array (inside an ArrayList) if the size is not enough
     * array is increased in half of the first size
     */
    private void increaseArray() {
        Object[] arrayNew = array.clone();
        array = new Object[array.length + array.length / 2];
        System.arraycopy(arrayNew, 0, array, 0, arrayNew.length);
        index = arrayNew.length;
    }

    /**
     * iterator for iterations into MyArrayList
     */
    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {

            // the pointer on the current element in the list
            int pointer = 0;

            @Override
            public boolean hasNext() {
                return index != pointer;
            }

            @Override
            public T next() {
                T next = (T) array[pointer];
                pointer++;
                return next;
            }
        };
    }
}
