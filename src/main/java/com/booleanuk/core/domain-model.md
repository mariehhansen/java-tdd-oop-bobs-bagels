| Classes   | Members                            | Methods                             | Scenarios                   | Outputs                    |
|-----------|------------------------------------|-------------------------------------|-----------------------------|----------------------------| 
| Basket    | Map<Item, Integer>, int capacity   | add(Item it)                        | it not an Item              | false                      |
|           |                                    |                                     | it is an Item               | true                       | 
|           |                                    | remove(Item it)                     | it not an Item              | false                      | 
|           |                                    |                                     | it is an Item & in Basket   | true                       | 
|           |                                    |                                     | it is an Item not in Basket | false (+ print message?)   |
|           |                                    | getTotalCost()                      | Basket empty                | 0                          | 
|           |                                    |                                     | Basket not empty            | totalCost                  | 
| Item      | String SKU, int price, String name | getSKU()                            | item not in inventory       | null                       | 
|           |                                    |                                     | item in inventory           | String                     | 
|           |                                    | getPrice()                          | item not in inventory       | null                       | 
|           |                                    |                                     | item in inventory           | float                      | 
|           |                                    | getName()                           | item not in inventory       | null                       | 
|           |                                    |                                     | item in inventory           | String                     | 
| Bagel     | List<Filling>                      | setFilling(Filling[] f)             | empty f                     | false (error: must choose) |
|           |                                    |                                     | f not empty                 | true                       | 
| Filling   |                                    | getPrice()                          | not a Filling               | null                       |
|           |                                    |                                     | is a Filling                | price                      |
| Manager   |                                    | changeCapacity(Basket b, int cap)   | b not a Basket              | null                       |
|           |                                    | isInItems()                         | all items in Item           | true                       | 
|           |                                    |                                     | not all items in Item       | false                      | 
|           |                                    |                                     | b is a Basket               | capacity += cap            | 
| Guest     | String name                        | addToBasket(Bagel bagel)            | bagel is in inventory       | true                       | 
|           |                                    |                                     | bagel not in inventory      | false                      |
|           |                                    | removeFromBasket(Bagel bagel)       | bagel is in Basket          | true                       | 
|           |                                    |                                     | bagel not in Basket         | false                      | 
|           |                                    | isBasketFull()                      | basket is full              | true                       | 
|           |                                    |                                     | basket not full             | false                      | 
|           |                                    | hasItemInBasket(Item item)          | basket has item             | true                       | 
|           |                                    |                                     | basket does not have item   | false                      | 
| Customer  |                                    | getTotalCostBasket()                | basket empty                | 0                          |
|           |                                    |                                     | basket not empty            | float                      | 
|           |                                    | getPriceBagel(Bagel bagel)          | bagel in inventory          | float                      | 
|           |                                    |                                     | bagel not in inventory      | 0                          | 
|           |                                    | setFillings(List<Filling> fillings) | filling in inventory        | true                       | 
|           |                                    |                                     | filling not in inventory    | false                      |
|           |                                    | getPriceFilling(Filling filling)    | filling in inventory        | float                      | 
|           |                                    |                                     | filling not in inventory    | false                      |
| Inventory | enum! how to list it here          |                                     |                             |                            | 

