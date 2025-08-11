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
        return this.SKU;
    }

    public float getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getVariant() {
        return this.variant;
    }
}
