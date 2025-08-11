## UUUUPDATE don't forget pls

```mermaid
classDiagram
    Inventory <|-- Item
    Item <|-- Bagel
    Item <|-- Filling
    Customer <|-- Manager
    
    
    class Item {
        - SKU: String
        - price: float
        - name: String
        + getSKU(): String
        + getPrice(): float
        + getName(): String
    }
    
    class Bagel {
        - fillings: List<Filling>
        + getFillings(): List<Filling>
    }
    
    class Filling {
       + getPrice(): float
    }
    
    enum Inventory {
        + SKU: List<String>
    }
    
    class Basket {
        - items: Map<Item, Integer>
        - capacity: int
        + add(Item): boolean
        + remove(Item): boolean
        + getTotalCost(): float
    }
    
    class Customer {
        
    }
    
    class Manager {
        + changeCapacity(Basket, int): boolean
        + orderIsInItems(): boolean
    }
    
```