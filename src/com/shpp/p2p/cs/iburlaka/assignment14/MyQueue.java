package com.shpp.p2p.cs.iburlaka.assignment14;

import java.util.Iterator;

/**
 * interface for custom Queue, which based on a linked list
 */
public interface MyQueue<T> {

    /** adds an element one by one into Queue
     */
    void addElement(T value);

    /** returns first value in Queue (first added element)
     */
    T getPeek();

    /** removes an element added first in Queue and returns it
     */
    T getRemoved();

    /** iterator for iterating into Queue
     */
    Iterator<T> iterator();

    /** outputs Queue into console
     */
    void printList();

    /** returns the size of the Queue
     */
    int size();
}
