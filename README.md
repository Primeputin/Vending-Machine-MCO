
# Vending-Machine-MCO

This project is the simulation of any vending machine. There are two main features of the program, the vending and maintenance features. There are two types of vending machine. Namely, these are regular vending machine and special vending machine.


## Regular Vending Machine Features

A Regular Vending Machine consists of item slots that act as an interface for the user to know what is available for purchase. Each slot is mapped to a specific item and – to keep things simple – kindly assume that items stored in the slots are unique from each other. The vending machine does not hold infinite items, so there is a common limit for the number of items that can be stocked. For the project, there must be at least eight (8) slots and the vending machine should have a capacity of at least ten (10) items per slot1. The availability of an item should be obvious to the user. In terms of vending features, the machine should be allowed to receive payment from the user in different denominations2, dispense the item based on the choice of the user, and produce change. Note that a user may proceed directly with producing change and skip choosing an item – as if they changed their mind about making a purchase. Additionally, if there is not enough change in the machine, a transaction should not take place and the user should be informed of the issue. Note that all vending machines must also inform the user of the amount of calories found in the item. Lastly, as vending machines do not hold infinite items, you may assume that the owner/operator of the vending machine regularly performs maintenance. Maintenance features include restocking/stocking specific items, setting the price of each item type, collecting the payment/money, and replenishing the money (for different denominations) that will be used by the machine to provide change. Also, the vending machine has the capability of printing a summary of transactions. In other words, the vending machine should at least list the quantity of each item sold and the total amount collected in the sales starting from the previous stocking. This implies that there should also be a display of the starting inventory and the ending inventory from the last restocking.

## Special Vending Machine
Special Vending Machines can also be produced by the simulation program. These machines are special because, apart from the features of a regular vending machine, the machine can also prepare a selected product based on (a) the items that are stored in the machine and (b) the choices of items for the product that the user wants. This means that the amount of calories for the final product is the combination of the calorie count of each chosen item to include (which might involve more than just addition). Note that since this is a simulation of the machine's work, your program will display how the final product is “prepared”.

As an example, imagine a vending machine that can dispense a customizable ramen, on top of other items. The owner of this particular ramen vending machine (RVM) will also set the items that can be chosen in the customizable ramen and the prices for each. In this case, items that can be included in the customizable ramen are noodles, egg, chashu pork, fried tofu, negi, tonkotsu broth, ukokkei broth, miso broth, and shio broth. Please note that another owner may choose to stock the following (on top of what is previously indicated): different types of noodles, boiled chicken slices, fish cake, and black garlic oil.

Keeping the RVM example in mind, we can imagine that a customer can order the following customized ramen: 1 order of noodles, 2 orders of chasyu pork, and 1 order of tonkotsu broth. During the preparation, the machine will display something like this:
Blanching noodles... Heating broth...
Placing noodles in cup... Topping with chashu pork... Pouring broth...
Ramen Done!
Another customer may order a customizable ramen having 2 orders of noodles, 1 order of aji tamago, fried tofu, and miso broth and the display will be something like this:
Blanching noodles...
Heating broth...
Putting noodles in cup...
Topping with fried tofu and aji tamago... Pouring broth...
Ramen Done!
It should be noted that another customer may only order chashu pork from the RVM. In this case, this is treated as an item. Therefore no “preparation” is necessary and the item is dispensed directly. However, some items that do not make sense to stand alone as a food item should not be allowed to be sold separately. For example, black garlic oil may not be chosen as an item and is only available when choosing add-ons to the customizable ramen.

**For this project, burger is the customized item.**

## Some more specifics

A stock of an item is instantiated rather than counted to simulate it just for the sake of it. The program also utilized MVC (Model Controller View pattern).


## Running Tests
Before running, please compile the code inside the src/ directory
```bash
javac Main.java
```

To run tests, run the following command

```bash
java Main
```


## Authors

- [@Primeputin](https://github.com/Primeputin)
- [@nimbus7462](https://github.com/nimbus7462)

