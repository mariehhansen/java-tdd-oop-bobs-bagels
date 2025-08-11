package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Item {

    private List<Filling> fillingList;

    public Bagel(String SKU, float price, String name, String variant) {
        super(SKU, price, name, variant);
        fillingList = new ArrayList<>();
    }

    public boolean addFilling(Filling f) {
        return false;
    }

    public List<Filling> getFillingList() {
        return null;
    }

    public float getPriceWithFillings() {
        return 0;
    }
}
