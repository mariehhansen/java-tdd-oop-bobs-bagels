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
        // make void? or keep boolean and set max number of fillings?
        fillingList.add(f);
        return true;
    }

    public List<Filling> getFillingList() {
        return this.fillingList;
    }

    public float getPriceWithFillings() {
        float updatedPrice = this.getPrice();
        for (Filling f : this.getFillingList()) {
            updatedPrice += f.getPrice();
        }
        return updatedPrice;
    }
}
