package com.booleanuk.core;

public class Manager {

    public Manager() {

    }

    public boolean setCapacity(Basket b, int cap) {
        return b.setCapacity(cap);
    }

    public boolean isInItems(Basket b) {
        // make a map for inventory, check here
        return false;
    }
}
