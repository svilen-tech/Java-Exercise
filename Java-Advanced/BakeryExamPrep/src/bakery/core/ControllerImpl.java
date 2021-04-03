package bakery.core;


import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bakery.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    protected FoodRepository<BakedFood> foodRepository;
    protected DrinkRepository<Drink> drinkRepository;
    protected TableRepository<Table> tableRepository;
    protected double allBills;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository,
                          DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }


    @Override
    public String addFood(String type, String name, double price) {
        if (foodRepository.getAll().stream().anyMatch(a -> a.getName().equals(name))) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        BakedFood neuFood;
        if (type.equals("Bread")) {
            neuFood = new Bread(name, price);
        } else {
            neuFood = new Cake(name, price);
        }
        foodRepository.add(neuFood);
        return String.format("Added %s (%s) to the menu", name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        if (drinkRepository.getAll().stream().anyMatch(a -> a.getName().equals(name))) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        Drink neuDrink;
        if (type.equals("Tea")) {
            neuDrink = new Tea(name, portion, brand);
        } else {
            neuDrink = new Water(name, portion, brand);
        }
        drinkRepository.add(neuDrink);
        return String.format("Added %s (%s) to the drink menu", name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        if (tableRepository.getAll().stream().anyMatch(a -> a.getTableNumber() == tableNumber)) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }
        Table neuTable;
        if (type.equals("InsideTable")) {
            neuTable = new InsideTable(tableNumber, capacity);
        } else {
            neuTable = new OutsideTable(tableNumber, capacity);
        }
        tableRepository.add(neuTable);
        return String.format("Added table number %d in the bakery", tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table findedTable = tableRepository.getAll()
                .stream().filter((a) -> a.getCapacity() >= numberOfPeople && !a.isReserved()).findFirst().orElse(null);
        if (findedTable == null) {
            return String.format("No available table for %s people", numberOfPeople);
        } else {
            tableRepository.getByNumber(findedTable.getTableNumber()).reserve(numberOfPeople);
        }
        return String.format("Table %d has been reserved for %d people",
                findedTable.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        if (tableRepository.getAll().stream().noneMatch(a -> a.getTableNumber() == tableNumber)||!tableRepository.getByNumber(tableNumber).isReserved()) {
            return String.format("Could not find table with %d", tableNumber);
        } else if (foodRepository.getAll().stream().noneMatch(a -> a.getName().equals(foodName))) {
            return String.format("No %s in the menu", foodName);
        }
        tableRepository.getByNumber(tableNumber).orderFood(foodRepository.getByName(foodName));
        return String.format("Table %d ordered %s", tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        if (drinkRepository.getAll().stream().noneMatch(a -> a.getName().equals(drinkName) && a.getBrand().equals(drinkBrand))) {
            return String.format("There is no %s %s available", drinkName, drinkBrand);
        } else if (tableRepository.getAll().stream().noneMatch(a -> a.getTableNumber() == tableNumber)) {
            return String.format("Could not find table with %d", tableNumber);
        }
        tableRepository.getByNumber(tableNumber).orderDrink(drinkRepository.getByNameAndBrand(drinkName,drinkBrand));
        return String.format("Table %d ordered %s %s", tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        double bill = tableRepository.getByNumber(tableNumber).getBill();
        tableRepository.getByNumber(tableNumber).clear();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Table: %d", tableNumber));
        sb.append(System.lineSeparator());
        sb.append(String.format("Bill: %.2f", bill));
        allBills+=bill;
        return sb.toString();
    }

    @Override
    public String getFreeTablesInfo() {

        List<Table> collect = tableRepository.getAll().stream().filter(a -> !a.isReserved()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Table table : collect) {
            sb.append(table.getFreeTableInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {

        return String.format("Total income: %.2flv",allBills);
    }
}
