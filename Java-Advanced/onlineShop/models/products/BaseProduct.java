package onlineShop.models.products;

import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.peripherals.Peripheral;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.PRODUCT_TO_STRING;

public abstract class BaseProduct implements Product {
    private int id;
    private String manufacturer;
    private String model;
    private Double price;
    private Double overallPerformance;
    protected BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance){
        this.setId(id);
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
        this.setOverallPerformance(overallPerformance);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getOverallPerformance() {
        return this.overallPerformance;
    }

    @Override
    public String toString() {
       return String.format(PRODUCT_TO_STRING,getOverallPerformance(),
               getPrice(),this.getClass().getSimpleName(),getManufacturer(),getModel(),getId());
    }

    private void setId(int id) {
        if (id<=0){
            throw new IllegalArgumentException(INVALID_PRODUCT_ID);
        }
        this.id = id;
    }

    private void setManufacturer(String manufacturer) {
        if (manufacturer==null||manufacturer.trim().length()==0){
            throw new IllegalArgumentException(INVALID_MANUFACTURER);
        }
        this.manufacturer = manufacturer;
    }

    private void setModel(String model) {
        if (model==null||model.trim().length()==0){
            throw new IllegalArgumentException(INVALID_MODEL);
        }
        this.model = model;
    }

    private void setPrice(Double price) {
        if (price<=0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }
    private void setOverallPerformance(Double overallPerformance) {
        if (overallPerformance<=0){
            throw new IllegalArgumentException(INVALID_OVERALL_PERFORMANCE);
        }
        this.overallPerformance = overallPerformance;
    }
}
