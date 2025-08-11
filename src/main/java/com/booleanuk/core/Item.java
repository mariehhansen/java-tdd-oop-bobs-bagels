package com.booleanuk.core;

abstract public class Item {
    private String SKU;
    private float price;
    private String name;
    private String variant;

    public Item(String SKU, float price, String name, String variant) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String getSKU() {
        return null;
    }

    public float getPrice() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public String getVariant() {
        return null;
    }
}
