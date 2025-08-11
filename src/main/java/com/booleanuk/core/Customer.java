package com.booleanuk.core;

import java.util.List;

public class Customer extends Guest {

    public Customer(String name) {
        super(name);
    }

    public float getTotalPriceBasket() {
        return 0;
    }

    public float getPriceBagel(Bagel b) {
        return 0;
    }

    public float getPriceFilling(Filling f) {
        return 0;
    }

    public boolean setFillings(List<Filling> fillingList) {
        return false;
    }
}
