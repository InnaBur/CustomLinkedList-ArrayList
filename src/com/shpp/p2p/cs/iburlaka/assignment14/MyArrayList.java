package com.shpp.p2p.cs.iburlaka.assignment14;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class MyArrayList<T> implements Iterable<T> {

    private Object[] array = new Object[ARRAY_SIZE];
    final static int ARRAY_SIZE = 10;
    private int index = 0;


    public void add(T value) {

        if (index == array.length) {
            increaseArray();
        }
        array[index] = value;
        index++;
    }

    public void arrayToMyList(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
            index++;
            if (index == array.length) {
                increaseArray();
            }
        }
    }

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

    public void removeElement(int j) {
        if (j >= array.length) {
//            System.out.println("Index " + j + " out of bounds for length " + (index - 1));
            throw new IndexOutOfBoundsException();
        } else {
            Object[] temp = array.clone();
            array = new Object[temp.length - 1];
            for (int k = 0; k < array.length; k++) {
                if (k < j) {
                    array[k] = temp[k];
                } else {
                    array[k] = temp[k + 1];
                }
            }
            index--;
        }
    }

    public void setElement(int j, T value) {
        for (int k = 0; k < array.length; k++) {
            if (k == j) {
                array[k] = value;
            }
        }
    }


    public T getElement(int j) {
        if (j >= index) {
            throw new IndexOutOfBoundsException();
        } else {
            return (T) array[j];
        }// !!!!
    }

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

    public boolean containsValue(T value) {
        for (Object o : array) {
            if (o == value) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return (index == 0);
    }

    public void cleanList() {
        for (int i = index-1; i >= 0; i--) {
            array[i] = null;
            index--;
        }
    }

    private void increaseArray() {
        Object[] arrayNew = array.clone();
        array = new Object[array.length + array.length / 2];
        System.arraycopy(arrayNew, 0, array, 0, arrayNew.length);
        index = arrayNew.length;
    }


    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            int a = 0;

            @Override
            public boolean hasNext() {
                return index != a;
            }

            @Override
            public T next() {
                T next = (T) array[a];
                a++;

                return next;
            }
        };
    }


}
