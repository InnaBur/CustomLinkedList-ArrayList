package com.shpp.p2p.cs.iburlaka.assignment14.helpsClasses;

/**
 * Class uses for testing custom LinkedList
 */
public class Train {
    private final int number;
    private final String direction;
    private final String time;

    public Train(int number, String direction, String time) {
        this.number = number;
        this.direction = direction;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Train {" +
                "number=" + number +
                ", direction='" + direction + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
