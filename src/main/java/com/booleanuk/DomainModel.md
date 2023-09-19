# Bob's Bagels - Object-oriented Programming

## UML Diagram
![UML.png](..%2F..%2F..%2F..%2F..%2Fassets%2FUML.png)

## Domain Model

| Class     | Method                      | Description                                                                       | Output                                                                                                                                   |
|-----------|-----------------------------|-----------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| Foods     | `getSku()`                  | getter of Foods object                                                            | object's sku: `String`                                                                                                                   |
|           | `getPrice()`                | getter of Foods object                                                            | object's price: `integer`                                                                                                                |
|           | `getCost()`                 | getter of Foods object                                                            | object's price: `double`                                                                                                                 |
|           | `getVariant()`              | getter of Foods object                                                            | object's variant: `String`                                                                                                               |
|           | `setPrice()`                | setter of Foods object                                                            | `void`                                                                                                                                   |
|           | `setVariant()`              | setter of Foods object                                                            | `void`                                                                                                                                   |
| Bagel     | `addFilling()`              | adds filling into bagel object fillingsList                                       | `void`                                                                                                                                   |
|           | `toString()`                | An overriden method that outputs info about bagel object as well as it's fillings | `String`                                                                                                                                 |
| Inventory | `initialize()`              | It is used to initialize the HashMap inventoryList                                | `void`                                                                                                                                   |
|           | `get(String sku)`           | It is used to output a food object based on it's sku code                         | `Foods` object if one is found in the list<br/>/null if not                                                                              |
| Basket    | `add(Food item)`            | It is used to add food objects into the basketList Arraylist                      | `boolean`:<br/>`false` if basket is full<br/>/`false` if item doesn't exist into the inventory list<br/>/`true` if everything checks out |
|           | `remove(String sku)`        | It is used to remove food objects from the basketList ArrayList                   | `boolean`:<br/>`true` if basketList contained the food object<br/>/`false` if not                                                        |
|           | `getCapacity()`             | getter of Basket object                                                           | object's capacity: `integer`                                                                                                             |
|           | `setCapacity(int capacity)` | setter of Basket object                                                           | `void`                                                                                                                                   |
|           | `getTotalCost()`            | getter of Basket object                                                           | Total Cost of Foods in the basket:`double`                                                                                               |
