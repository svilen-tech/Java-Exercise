package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.BaseComputer;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new HashMap<>();
        this.components = new HashMap<>();
        this.peripherals = new HashMap<>();
    }

    //•	computerType – String
//•	id – int
//•	manufacturer – String
//•	model – String
//•	price – double
    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        } else if (computerType.equals("DesktopComputer")) {
            Computer computer = new DesktopComputer(id, manufacturer, model, price);
            computers.put(id, computer);
        } else if (computerType.equals("Laptop")) {
            Laptop laptop = new Laptop(id, manufacturer, model, price);
            computers.put(id, laptop);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }

        return "Computer with id " + id + " added successfully.";

    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        if (peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        BasePeripheral basePeripheral;
        switch (peripheralType) {
            case "Headset":
                basePeripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                basePeripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                basePeripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                basePeripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        computers.get(computerId).addPeripheral(basePeripheral);
        peripherals.put(id, basePeripheral);
        return String.format("Peripheral %s with id %d added successfully in computer with id %d.",
                peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        if (!computers.containsKey(computerId)){
            return "Computer with this id does not exist.";
        }

        boolean success = false;
        int peripheralId = 0;
        for (Map.Entry<Integer, Peripheral> peripheralEntry : peripherals.entrySet()) {
            if (peripheralEntry.getValue().getClass().getSimpleName().equals(peripheralType)) {
                peripheralId = peripheralEntry.getKey();
                peripherals.remove(peripheralEntry.getKey());
                computers.get(computerId).removePeripheral(peripheralType);
                success = true;
                break;
            }
        }
        if (success) {
            return String.format("Successfully removed %s with id %d.", peripheralType, peripheralId);
        }
       return String.format("Peripheral %s does not exist in %s with Id %d.",peripheralType,computers.get(computerId).getClass().getSimpleName(),computerId);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        if (components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        BaseComponent baseComponent;
        switch (componentType) {
            case "CentralProcessingUnit":
                baseComponent = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                baseComponent = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                baseComponent = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                baseComponent = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                baseComponent = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                baseComponent = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        if (computers.containsKey(computerId)){

            computers.get(computerId).addComponent(baseComponent);
            components.put(id, baseComponent);
            return String.format("Component %s with id %d added successfully in computer with id %d.",
                    componentType, id, computerId);
        }
        return "Computer with this id does not exist.";
    }

    @Override
    public String removeComponent(String componentType, int computerId) {

        if (!computers.containsKey(computerId)){
            return "Computer with this id does not exist.";
        }


        boolean success = false;
        int componentId = 0;
        for (Map.Entry<Integer, Component> componentEntry : components.entrySet()) {
            String name = componentEntry.getValue().getClass().getSimpleName();
            if (componentEntry.getValue().getClass().getSimpleName().equals(componentType)) {
                componentId = componentEntry.getKey();
                components.remove(componentEntry.getKey());
                computers.get(computerId).removeComponent(componentType);
                success = true;
                break;
            }
        }
        if (success) {
            return String.format("Successfully removed %s with id %d.", componentType, componentId);
        }
        return String.format("Component %s does not exist in %s with Id %d.",componentType,computers.get(computerId).getClass().getSimpleName(),computerId);
    }

    @Override
    public String buyComputer(int id) {
        //Removes a computer, with the given id, from the collection of computers.
        //If it's successful, it returns toString method on the removed computer.
        StringBuilder sb = new StringBuilder();
        if (computers.containsKey(id)) {
            sb.append(computers.get(id).toString());
            computers.remove(id);
        }else {
            sb.append("Computer with this id does not exist.");
        }
        return sb.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {

        double oldBestPerformance = 0;
        int computerIdBestPerformance = 0;
        for (Map.Entry<Integer, Computer> computerEntry : computers.entrySet()) {
            double performance = computerEntry.getValue().getOverallPerformance();
            if (computerEntry.getValue().getPrice() <= budget) {
                if (oldBestPerformance < performance) {
                    oldBestPerformance = performance;
                    computerIdBestPerformance = computerEntry.getKey();
                }
            }
        }
        if (oldBestPerformance == 0 || computers.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        StringBuilder sb = new StringBuilder(computers.get(computerIdBestPerformance).toString());
        computers.remove(computerIdBestPerformance);
        return sb.toString();

    }

    @Override
    public String getComputerData(int id) {
        if (computers.containsKey(id)) {
            return computers.get(id).toString();
        }
        return "Computer with this id does not exist.";
    }
}
