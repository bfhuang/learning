package com.bookshelf.oldWay.listener;

/**
 * Created by twer on 3/5/15.
 */
public class TestClass {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        System.out.println("---------testValue--------"+value);
        this.value = value;
    }
}
