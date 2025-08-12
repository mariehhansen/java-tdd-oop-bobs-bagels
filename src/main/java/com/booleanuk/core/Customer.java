package com.booleanuk.core;

import java.util.List;

public class Customer extends Guest {

    public Customer(String name) {
        super(name);
    }

    public float getTotalPriceBasket() {
        return this.getBasket().getTotalCost();
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
