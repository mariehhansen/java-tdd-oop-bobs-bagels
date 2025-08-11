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

    public boolean setCapacity(int newCap) {
        if (newCap < 0 || newCap > 100) {
            return false;
        }
        this.capacity = newCap;
        return true;
    }

    public boolean add(Item item) {
        if (this.isFull()) {
            return false;
        }
        else {
            if (this.items.containsKey(item)) {
                int amount = this.items.get(item) + 1;
                this.items.put(item, amount);
            }
            else {
                this.items.put(item, 1);
            }
            return true;
        }
    }

    public boolean remove(Item item) {
        if (!this.items.containsKey(item)) {
            return false;
        }
        this.items.remove(item);
        return true;
    }

    public float getTotalCost() {
        return 0;
    }

    public int getCapacity() {
        return this.capacity - this.items.size();
    }

    public int getAvailableCapacity() {
        // available after items are added
        // getCapacity if items-map is empty
        // check this first, make sure Manager does not screw it up

        return 0;
    }

    public boolean isFull() {
        return getCapacity() < this.items.size();
    }
}
