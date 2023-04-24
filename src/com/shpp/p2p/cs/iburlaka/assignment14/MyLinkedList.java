package com.shpp.p2p.cs.iburlaka.assignment14;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** The class implements methods for custom linked list
 * and methods for custom Queue and Stack are included
 */
public class MyLinkedList<T> implements Iterable<T>, MyQueue<T>, MyStack<T> {


    /** Objects for linked list are created
     * every object contains value (parametrized),
     * and links to the next and to the previous objects
     */
    public class MyObject {
        private T value;
        private MyObject next;
        private MyObject previous;
    }

    private MyObject first;
    private MyObject last;
    private int size = 0;


    /**
     * adds the first element into the list
     * increasing field size
     *
     * @param value - inputted value
     */
    public void addFirstElement(T value) {
        MyObject firstElement = new MyObject();
        if (!isEmpty()) {
            firstElement.next = first;
            firstElement.previous = null;
            firstElement.value = value;
            first.previous = firstElement;
        } else {
            firstElement.next = null;
            firstElement.previous = null;
            firstElement.value = value;
        }
        first = firstElement;
        size++;
    }

    /**
     * adds the last element into the list
     * increasing field size
     *
     * @param value - inputted value
     */
    public void addLastElement(T value) {
        MyObject lastElement = new MyObject();
        if (first != null) {
            last = first;
            while (last.next != null) {
                last = last.next;
            }
            lastElement.value = value;
            lastElement.next = null;
            last.next = lastElement;
            lastElement.previous = last;
            last = lastElement;
        } else {
            lastElement.next = null;
            lastElement.previous = null;
            lastElement.value = value;
            first = last = lastElement;
        }
        size++;
    }

    /**
     * adds an element to the end of the list
     *
     * @param value - inputted value
     */
    public void addElement(T value) {
        if (isEmpty()) {
            addFirstElement(value);
        } else {
            addLastElement(value);
        }
    }

    /**
     * removes first element from the list
     * and decrease field size
     * if the list is empty, NoSuchElementException() is thrown
     */
    public void removeFirstElement() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (hasOneElement()) {
            first = null;
            size--;
        } else {
            MyObject temp = first.next;
            temp.previous = null;
            first.next = null;
            first = temp;
            size--;
        }
    }

    /**
     * removes last element from the list
     * if the list is empty, NoSuchElementException() is thrown
     */
    public void removeLastElement() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (hasOneElement()) {
            first = null;
            size--;
        } else {
            MyObject temp = last.previous;
            last.previous = null;
            temp.next = null;
            last = temp;
            size--;
        }
    }

    /**
     * gets element`s value from the list by the inputted index
     * if the list is empty or index more than number of indexes, NoSuchElementException() is thrown
     * @param index - inputted index
     * @return - element value
     */
    public T getElement(int index) {
        if (isEmpty() || index >= size) {
            throw new NoSuchElementException();
        } else {
            MyObject element = first;
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
            return element.value;
        }
    }

    /**
     * adds element with inputted value into needed position
     * if the inputted index less than 0 or more than size, IndexOutOfBoundsException is thrown
     * @param value - inputted value
     * @param index - needed position for the new value
     */
    public void addElement(T value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(" " + index + " is out of " + size);
        } else if (index == size) {
            addLastElement(value);
        } else {
            MyObject temp = first;
            for (int i = 0; i < index; i++) { // found an element in which position new element added
                temp = temp.next;
            }
            MyObject newElement = new MyObject();
            newElement.next = temp;
            newElement.previous = temp.previous;
            newElement.value = value;
            temp.previous.next = newElement; // link on the new element from the previous element
            size++;
        }
    }

    /**
     * removes an element from the needed position (inputted index)
     * if the inputted index less than 0 or more than size (or index is size), IndexOutOfBoundsException is thrown
     * if the list is empty, NoSuchElementException() is thrown
     *
     * @param index - needed position
     */
    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" " + index + " is out of " + size);
        } else if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (index == size - 1) {
            removeLastElement();
        } else if (index == 0) {
            removeFirstElement();
        } else {
            MyObject temp = first;
            for (int i = 0; i < index; i++) { // found an element in which position new element added
                temp = temp.next;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            size--;
        }
    }

    /**
     * checks if the list contains a value
     *
     * @param value - inputted value
     * @return - true is value is in the list, and false if not
     */
    public boolean containsElement(T value) {
        MyObject temp = first;
        for (int i = 0; i < size - 1; i++) {
            if (temp.value == value) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    /**
     * cleans the list from all objects if the list is not empty
     */
    public void cleanList() {
        if (!isEmpty()) {
            MyObject temp = last;
            if (temp != null) {
                while (temp.previous != null) {
                    temp.previous.next = null;
                    temp = temp.previous;
                    size--;
                }
                first = null;
                size--;
            }
        }
    }

    /**
     * outputs the list to the console as a string
     * (looks like in a real linked list outputs)
     */
    public void printList() {
        MyObject temp = first;
        if (temp != null) {
            System.out.print("[" + first.value + ((temp.next == null) ? "]" : ", "));
            while (temp.next != null) {
                System.out.print(temp.next.value);
                temp = temp.next;
                System.out.print((temp.next == null) ? "]" : ", ");
            }
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

    /**
     * gets the first element from the list
     * if the list is empty, NoSuchElementException() is thrown
     *
     * @return value from the first element
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.value;
    }

    /**
     * gets the last element from the list
     * if the list is empty, NoSuchElementException() is thrown
     *
     * @return value from the last element
     */
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.value;
    }

    /**
     * returns the size  of the list
     *
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * checks if list is empty
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * checks if the list has only one element
     *
     * @return true is the list has only one element
     */
    private boolean hasOneElement() {
        return size == 1;
    }

    /**
     * the method for custom Queue implementation using linked list (FIFO)
     * if the list is empty, NoSuchElementException() is thrown
     * @return first value in list
     */
    @Override
    public T getPeek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.value;
    }

    /**
     * the method for custom Queue implementation using linked list (FIFO)
     * if the list is empty, NoSuchElementException() is thrown
     * element added first is removed from the list and returns
     *
     * @return removed element
     */
    @Override
    public T getRemoved() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = first.value;
        removeFirstElement();
        return value;
    }

    /**
     * the method for custom Stack implementation using linked list (LIFO)
     * if the list is empty, NoSuchElementException() is thrown
     *
     * @return value of the first element in list
     * (on the firs place is the last added element into a list)
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.value;
    }

    /**
     * the method for custom Stack implementation using linked list (LIFO)
     * deleted the first element in the list (last added element)
     * if the list is empty, NoSuchElementException() is thrown
     */
    @Override
    public void pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        removeFirstElement();
    }

    /**
     * the method for custom Stack implementation using linked list (LIFO)
     * adds elements into a list on the first place, one by one
     *
     * @param value - inputted value
     */
    @Override
    public void push(T value) {
        addFirstElement(value);
    }

    /**
     * implemented an iterator (for using for-each loop)
     * included methods: hasNext() (return true if there is next element)
     * and  next() - returns next object in the list
     *
     * @return an iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            MyObject temp = first;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T next = temp.value;
                temp = temp.next;

                return next;
            }
        };
    }
}
