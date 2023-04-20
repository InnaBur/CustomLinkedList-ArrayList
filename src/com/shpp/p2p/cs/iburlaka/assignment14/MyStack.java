package com.shpp.p2p.cs.iburlaka.assignment14;

import java.util.Iterator;

/**
 * interface for custom Stack, based on a linked list
 */
public interface MyStack<T> extends Iterable<T> {

    /**
     * adds elements into a Stack one by one, on the first place
     * in the beginning of the list is last added element
     */
    void push(T value);

    /** returns value of the first element in Stack
    (on the first place is the last added element) */
    T peek();

    /** removes element from the Stack beginning
     (last added element) */
    void pop();

    /** iterator for iterating into Stack
     */
    Iterator<T> iterator();

    /** returns the size of the Stack
     */
    int size();

    /** outputs Stack into console
     */
    void printList();
}
