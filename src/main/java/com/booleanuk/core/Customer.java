package com.booleanuk.core;

import java.util.List;

public class Customer extends Guest {

    public Customer(String name) {
        super(name);
    }

    public float getTotalPriceBasket() {
        float total = 0;
        for (Item i : this.getBasket().getItems().keySet()) {
            if (i instanceof Bagel) {
                total += ((Bagel) i).getPriceWithFillings();
            }
            else {
                total += i.getPrice();
            }
        }
        return total;
    }

    public float getPriceBagel(Bagel b) {
        return b.getPriceWithFillings();
    }

    public float getPriceFilling(Filling f) {
        return f.getPrice();
    }

    public boolean setFillings(List<Filling> fillingList) {
        return false;
    }
}
