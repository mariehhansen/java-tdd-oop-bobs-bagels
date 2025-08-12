package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CoreTest {

    // GUEST
    @Test
    public void shouldAddToBasket() {
        Guest g = new Guest("Gio");
        Bagel bg = new Bagel("A", 20, "Aa", "Ab");
        g.addToBasket(bg);
        Assertions.assertTrue(g.getBasket().getItems().containsKey(bg));
    }

    @Test
    public void shouldRemoveFromBasket() {
        Guest g = new Guest("Gio");
        Bagel bg = new Bagel("A", 20, "Aa", "Ab");
        g.removeFromBasket(bg);
        Assertions.assertFalse(g.getBasket().getItems().containsKey(bg));
    }

    @Test
    public void shouldBeFull() {
        Guest g = new Guest("Gio");
        Manager m = new Manager();
        m.setCapacity(g.getBasket(), 2);
        g.addToBasket(new Bagel("A", 20, "Aa", "Ab"));
        g.addToBasket(new Bagel("B", 20, "Bb", "Bc"));
        Assertions.assertTrue(g.getBasket().isFull());
    }

    @Test
    public void shouldNotHaveItemToRemove() {
        Basket b = new Basket(2);
        b.add(new Bagel("A", 20, "Aa", "Ab"));
        b.add(new Bagel("B", 20, "Bb", "Bc"));
        Item c = new Bagel("C", 100, "Cc", "Cd");
        Assertions.assertFalse(b.remove(c));
    }

    // CUSTOMER
    @Test
    public void shouldGetTotalPriceBasket() {
        Customer c = new Customer("Dave");
        Bagel a = new Bagel("A", 20, "Aa", "Ab");
        Bagel b = new Bagel("B", 20, "Bb", "Bc");
        c.getBasket().add(a);
        c.getBasket().add(b);
        Assertions.assertEquals(a.getPrice()+b.getPrice(), c.getTotalPriceBasket());
    }

    @Test
    public void shouldGetBagelPrice() {
        Customer c = new Customer("Dave");
        Bagel a = new Bagel("A", 20, "Aa", "Ab");
        a.addFilling(new Filling("F", 20, "Ff", "Fg"));
        c.getBasket().add(a);
    }

    @Test
    public void shouldGetFillingPrice() {
        Customer c = new Customer("Dave");
        Bagel a = new Bagel("A", 20, "Aa", "Ab");
        Filling f = new Filling("F", 20, "Ff", "Fg");
        Assertions.assertEquals(f.getPrice(), c.getPriceFilling(f));
    }

    @Test
    public void shouldSetFillings() {
        Customer c = new Customer("Dave");
        Bagel a = new Bagel("A", 20, "Aa", "Ab");
        Filling f = new Filling("F", 20, "Ff", "Fg");
        Filling g = new Filling("F", 20, "Ff", "Fg");
        c.getBasket().add(a);
        c.setFillings(a, List.of(f, g));
        Assertions.assertEquals(List.of(f, g), a.getFillingList());
    }

    @Test
    public void shouldGetPriceWithFillings() {
        Customer c = new Customer("Dave");
        Bagel a = new Bagel("A", 20, "Aa", "Ab");
        Filling f = new Filling("F", 20, "Ff", "Fg");
        Filling g = new Filling("F", 20, "Ff", "Fg");
        c.getBasket().add(a);
        c.setFillings(a, List.of(f, g));
        Assertions.assertEquals(a.getPrice()+f.getPrice()+g.getPrice(), c.getPriceBagel(a));
    }

    // ITEM: Bagel, Coffee, Filling
    @Test
    public void shouldGetSKUItem() {
        Item b = new Bagel("B", 20, "Aa", "Ab");
        Coffee c = new Coffee("C", 100, "Cc", "Cd");
        Filling f = new Filling("F", 20, "Ff", "Fg");
        Assertions.assertEquals("F", f.getSKU());
        Assertions.assertEquals("B", b.getSKU());
        Assertions.assertEquals("C", c.getSKU());
    }

    @Test
    public void shouldGetPriceItem() {
        Item b = new Bagel("B", 20, "Aa", "Ab");
        Coffee c = new Coffee("C", 30, "Cc", "Cd");
        Filling f = new Filling("F", 10, "Ff", "Fg");
        Assertions.assertEquals(20, b.getPrice());
        Assertions.assertEquals(30, c.getPrice());
        Assertions.assertEquals(10, f.getPrice());
    }

    @Test
    public void shouldGetNameItem() {
        Item b = new Bagel("B", 20, "Aa", "Ab");
        Coffee c = new Coffee("C", 20, "Cc", "Cd");
        Filling f = new Filling("F", 5, "Ff", "Fg");
        Assertions.assertEquals("Aa", b.getName());
        Assertions.assertEquals("Cc", c.getName());
        Assertions.assertEquals("Ff", f.getName());
    }

    @Test
    public void shouldGetVariant() {
        Item b = new Bagel("B", 20, "Aa", "Ab");
        Coffee c = new Coffee("C", 30, "Cc", "Cd");
        Filling f = new Filling("F", 20, "Ff", "Fg");
        Assertions.assertEquals("Ab", b.getVariant());
        Assertions.assertEquals("Cd", c.getVariant());
        Assertions.assertEquals("Fg", f.getVariant());
    }

    @Test
    public void getPriceBagelWithFilling() {
        Bagel b = new Bagel("B", 20, "Aa", "Ab");
        Filling f1 = new Filling("F", 10, "Ff", "Fg");
        Filling f2 = new Filling("F", 10, "Ff", "Fg");
        b.addFilling(f1); b.addFilling(f2);
        Assertions.assertEquals(40, b.getPriceWithFillings());
    }

    // MANAGER
    @Test
    public void shouldSetNewCapacity() {
        Manager m = new Manager();
        Basket b = new Basket(10);
        Assertions.assertEquals(10, b.getCapacity());
        m.setCapacity(b, 5);
        Assertions.assertEquals(5, b.getCapacity());
    }

    @Test
    public void shouldFindInItems() {
        Manager m = new Manager();
        Basket bas = new Basket(10);
        Item b = new Bagel("B", 20, "Aa", "Ab");
        Coffee c = new Coffee("C", 30, "Cc", "Cd");
        Filling f = new Filling("F", 10, "Ff", "Fg");
        bas.add(b); bas.add(c); bas.add(f);
        // FIX THIS
        // think I may need a map or something like in the Scrabble exercise
        // predefined inventory to "match" if item is valid
    }

    // BASKET
    @Test
    public void shouldNotBeFull() {
        Basket bas = new Basket(10);
        Assertions.assertFalse(bas.isFull());
        Item b = new Bagel("B", 20, "Aa", "Ab");
        Coffee c = new Coffee("C", 30, "Cc", "Cd");
        Filling f = new Filling("F", 10, "Ff", "Fg");
        bas.add(b); bas.add(c); bas.add(f);
        Assertions.assertFalse(bas.isFull());
    }
    @Test
    public void shouldAdd() {
        Basket bas = new Basket(10);
        Item b = new Bagel("B", 20, "Aa", "Ab");
        Coffee c = new Coffee("C", 30, "Cc", "Cd");
        Filling f = new Filling("F", 10, "Ff", "Fg");
        bas.add(b);
        bas.add(c);
        bas.add(f);
        Assertions.assertEquals(3, bas.getItems().size());
    }

    @Test
    public void shouldRemove() {
        Basket bas = new Basket(10);
        Item b = new Bagel("B", 20, "Aa", "Ab");
        Coffee c = new Coffee("C", 30, "Cc", "Cd");
        Filling f = new Filling("F", 10, "Ff", "Fg");
        bas.add(b); bas.add(c); bas.add(f);
        bas.remove(c);
        Assertions.assertEquals(2, bas.getItems().size());
    }

    @Test
    public void shouldGetTotalCost() {
        Basket bas = new Basket(10);
        Item b = new Bagel("B", 20, "Aa", "Ab");
        Coffee c = new Coffee("C", 30, "Cc", "Cd");
        Filling f = new Filling("F", 10, "Ff", "Fg");
        bas.add(b); bas.add(c); bas.add(f);
        Assertions.assertEquals(60, bas.getTotalCost());
    }

    @Test
    public void shouldGetCap() {
        Basket bas = new Basket(10);
        Assertions.assertEquals(10, bas.getCapacity());
        Manager m = new Manager();
        m.setCapacity(bas, 100);
        Assertions.assertEquals(100, bas.getCapacity());
    }
}
