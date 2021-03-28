package onlineShop.models.products.computers;

import com.sun.source.tree.LiteralTree;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.COMPUTER_COMPONENTS_TO_STRING;
import static onlineShop.common.constants.OutputMessages.COMPUTER_PERIPHERALS_TO_STRING;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component>components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        components= new ArrayList<>();
        peripherals=new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
      return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.stream().anyMatch(c->c.getClass()==component.getClass())){
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,component.getClass().getSimpleName(),
                    this.getClass().getSimpleName(),this.getId()));
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
      //If the components collection is empty or does not have a component of that type,
        // throw an IllegalArgumentException with the message "Component {component type} does not exist in {computer type} with Id {id}."
        if (components.isEmpty()||components.stream().noneMatch(c->c.getClass().getSimpleName().equals(componentType))){
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,componentType,this.getClass().getSimpleName(),getId()));
        }
        int index = 0;
        for (int i = 0;i<components.size();i++) {
            Component component = components.get(i);
            if (component.getClass().getSimpleName().equals(componentType)){
                index=i;
                break;
            }
        }
        return components.remove(index);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(p->p.getClass() == peripheral.getClass())){
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,peripheral.getClass().getSimpleName(),this.getClass().getSimpleName(),getId()));
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
       //If the peripherals collection is empty or does not have a peripheral of that type,
        // throw an IllegalArgumentException with the message "Peripheral {peripheral type} does not exist in {computer type} with Id {id}."
        if (peripherals.isEmpty()||peripherals.stream().noneMatch(p->p.getClass().getSimpleName().equals(peripheralType))){
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,peripheralType,this.getClass().getSimpleName(),getId()));
        }
        int index = 0;
        for (int i = 0;i<peripherals.size();i++) {
            Peripheral peripheral = peripherals.get(i);
            if (peripheral.getClass().getSimpleName().equals(peripheralType)){
                index=i;
                break;
            }
        }
        return peripherals.remove(index);
    }
    @Override
    public double getOverallPerformance() {
        double componentPerformance=
                components.stream()
                .mapToDouble(Component::getOverallPerformance)
                .average()
                .orElse(0);
        return super.getOverallPerformance()+componentPerformance;
    }
    public double overallPerformancePeripheral(){
        double peripheral=
                peripherals.stream()
                        .mapToDouble(Peripheral::getOverallPerformance)
                        .average()
                        .orElse(0);
        return super.getOverallPerformance()+peripheral;
    }

    @Override
    public double getPrice(){
        double componentPrice = components.stream().mapToDouble(Component::getPrice)
                .sum();
        double peripheralPrice = peripherals.stream().mapToDouble(Peripheral::getPrice)
                .sum();
        return super.getPrice()+componentPrice+peripheralPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format(COMPUTER_COMPONENTS_TO_STRING,components.size()));
        sb.append(System.lineSeparator());

        for (Component component : components) {
            sb.append("  ").append(component.toString())
                    .append(System.lineSeparator());

        }
        sb.append(String.format(COMPUTER_PERIPHERALS_TO_STRING,peripherals.size(),
                peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0)));
        sb.append(System.lineSeparator());

        for (Peripheral peripheral : peripherals) {
            sb.append("  ").append(peripheral.toString())
                    .append(System.lineSeparator());
        }

         return sb.toString().trim();
    }
}
//" Components ({components count}):"
//"  {component one}"
//"  {component two}"
//"  {component n}"
//" Peripherals ({peripherals count}); Average Overall Performance ({average overall performance peripherals}):"
//"  {peripheral one}"
//"  {peripheral two}"
//"  {peripheral n}"