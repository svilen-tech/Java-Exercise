package bakery.entities.bakedFoods;

import bakery.entities.bakedFoods.interfaces.BakedFood;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseFood implements BakedFood {
    private String name;
    private double portion;
    private double price;

    public BaseFood(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    private void setName(String name) {
        if (name==null||name.trim().length()==0){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if (portion<=0){
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setPrice(double price) {
        //o	If the portion is less or equal to 0,
        // throw an IllegalArgumentException with message "Price cannot be less or equal to zero!"
        if (price<=0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
    public String toString(){
        //Returns a String with information about each food. The returned String must be in the following format:
//"{currentBakedFoodName}: {currentPortion - formatted to the second digit}g - {currentPrice - formatted to the second digit}"
        return String.format("%s: %.2fg - %.2f",getName(),getPortion(),getPrice());

    }
}
