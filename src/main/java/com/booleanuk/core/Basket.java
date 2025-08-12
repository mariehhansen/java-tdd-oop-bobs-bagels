package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    private int capacity;
    private Map<Item, Integer> items;

    public Basket(int capacity) {
        this.capacity = capacity;
        items = new HashMap<>();
    }

    private boolean hasBGL6Offer() {

        if (this.items.isEmpty()) {
            return false;
        }

        int numBagels = 0;
        for (Map.Entry<Item, Integer> entry : this.items.entrySet()) {
            if (entry.getKey() instanceof Bagel) {
                numBagels += entry.getValue();
            }
        }
        return numBagels >= 6;
    }

    private boolean hasCOFBOffer() {
        if (items.isEmpty() || items.size() < 2 || getCapacity() < 2) {
            return false;
        }
        return this.items.keySet().stream().anyMatch(Coffee.class::isInstance) && this.items.keySet().stream().anyMatch(Bagel.class::isInstance);
    }

    private boolean hasBGL12Offer() {
        if (this.items.isEmpty()) {
            return false;
        }

        int numBagels = 0;
        for (Map.Entry<Item, Integer> entry : this.items.entrySet()) {

            if (entry.getKey() instanceof Bagel) {
                numBagels += entry.getValue();
            }
        }
        return numBagels >= 12;
    }

    private int getDozens(Map<Item, Integer> items) {

        int bagelCount = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {

            if (entry.getKey() instanceof Bagel) {
                bagelCount += entry.getValue();
            }
        }
        return bagelCount / 12;
    }

    private int getSixes(Map<Item, Integer> items) {

        int bagelCount = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {

            if (entry.getKey() instanceof Bagel) {
                bagelCount += entry.getValue();
            }
        }
        return bagelCount / 6;
    }

    private int getCoffeeBagelCombos(Map<Item, Integer> items) {

        int bagelCount = 0;
        for (Item it : items.keySet()) {
            if (it instanceof Bagel) {
                bagelCount ++;
            }
        }

        int coffeeCount = 0;
        for (Item it : items.keySet()) {
            if (it instanceof Coffee) {
                coffeeCount ++;
            }
        }
        return Math.min(bagelCount, coffeeCount);
    }

    private void removeBagels(Map<Item, Integer> its, int countToRemove) {

        // have to make sure countToRemove and current count is checked!!
        for (Item it : new ArrayList<>(its.keySet())) {

             if (it instanceof Bagel && countToRemove > 0) {

                 int thisCount = its.get(it);
                 int remove = Math.min(thisCount, countToRemove);
                 its.put(it, thisCount - remove);

                 if (its.get(it) == 0) {
                     its.remove(it);
                 }
             }
        }
    }

    private void removeCoffeeAndBagels(Map<Item, Integer> its, int combos) {

        removeBagels(its, combos);
        for (Item it : new ArrayList<>(its.keySet())) {

            if (it instanceof Coffee && combos > 0) {

                int thisCount = its.get(it);
                int remove = Math.min(thisCount, combos);
                its.put(it, thisCount - remove);

                if (its.get(it) == 0) {
                    its.remove(it);
                }
            }
        }
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
        float total = 0f;
        Map<Item, Integer> remainingItems = new HashMap<>(this.items); // copy of this.items

        // check 12 bagel offer
        if (this.hasBGL12Offer()) {

            int dozens = getDozens(remainingItems);
            total += dozens * 3.99f;

            removeBagels(remainingItems, dozens * 12);
        }
        // check 6 bagel offer
        if (this.hasBGL6Offer()) {

            int sixes = getSixes(remainingItems);
            total += sixes * 2.49f;

            removeBagels(remainingItems, sixes * 6);
        }

        // check if remaining items can get coffee+bagel offer
        if (hasCOFBOffer()) {

            int combos = getCoffeeBagelCombos(remainingItems);
            total += combos * 1.25f;

            removeCoffeeAndBagels(remainingItems, combos);
        }

        for (Item it : remainingItems.keySet()) {

            if (it instanceof Bagel) {
                total += ((Bagel) it).getPriceWithFillings();
            } else {
                total += it.getPrice();
            }
        }
        return total;
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
