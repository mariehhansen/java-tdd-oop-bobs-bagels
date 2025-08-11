package com.booleanuk.core;

public class Guest {
    // "MEMBER OF PUBLIC"
    private String name;
    private Basket basket;
    private int defaultCap = 10;

    public Guest(String name) {
        this.name = name;
        this.basket = new Basket(defaultCap);
    }

    public Basket getBasket() {
        return null;
    }

    public boolean addToBasket(Item it) {
        return false;
    }

    public boolean removeFromBasket(Item it) {
        return false;
    }

    public boolean isBasketFull() {
        return false;
    }

    public boolean hasItemInBasket(Item it) {
        return false;
    }
}
