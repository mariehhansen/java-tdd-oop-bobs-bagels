package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private int capacity;
    private Map<Item, Integer> items;

    public Basket(int capacity) {
        this.capacity = capacity;
        items = new HashMap<>();
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public boolean add(Item item) {
        return false;
    }

    public boolean remove(String SKU) {
        return false;
    }

    public float getTotalCost() {
        return 0;
    }

    public int getCapacity() {
        return 0;
    }

    public int getAvailableCapacity() {
        // available after items are added
        // getCapacity if items-map is empty
        // check this first, make sure Manager does not screw it up
        return 0;
    }

    public boolean isFull() {
        return false;
    }


}
