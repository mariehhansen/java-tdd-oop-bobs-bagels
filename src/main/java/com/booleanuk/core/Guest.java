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
        return this.basket;
    }

    public boolean addToBasket(Item item) {
        return this.basket.add(item);
    }

    public boolean removeFromBasket(Item item) {
        return this.basket.remove(item);
    }

    public boolean guestBasketIsFull() {
        return this.basket.isFull();
    }

    public boolean hasItemInBasket(Item item) {
        return this.basket.getItems().containsKey(item);
    }
}
