package bakery.entities.tables;

import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    protected int tableNumber;
    protected int capacity;
    protected int numberOfPeople;
    protected double pricePerPerson;
    protected boolean isReserved;
    protected double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson=pricePerPerson;

    }
    private void setCapacity(int capacity){
        if (capacity<0){
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity=capacity;
    }
    private void setNumberOfPeople(int numberOfPeople){
        if (numberOfPeople<=0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople=numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.isReserved=true;
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double sumDrink = drinkOrders.stream().mapToDouble(Drink::getPrice).reduce(0, Double::sum);
        double sumFood = foodOrders.stream().mapToDouble(BakedFood::getPrice).reduce(0, Double::sum);
        return sumDrink+sumFood+(this.pricePerPerson*numberOfPeople);
    }

    @Override
    public void clear() {
        drinkOrders= new ArrayList<>();
        foodOrders= new ArrayList<>();
        this.price=0;
        this.numberOfPeople=0;
    }

    @Override
    public String getFreeTableInfo() {
    //"Table: {table number}"
        //"Type: {table type}"
        //"Capacity: {table capacity}"
        //"Price per Person: {price per person for the current table}"
        StringBuilder sb = new StringBuilder();
        sb.append("Table: "+tableNumber);
        sb.append(System.lineSeparator());
        sb.append("Type: "+this.getClass().getSimpleName());
        sb.append(System.lineSeparator());
        sb.append("Capacity: "+capacity);
        sb.append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f",pricePerPerson));
        return sb.toString();

    }
}
