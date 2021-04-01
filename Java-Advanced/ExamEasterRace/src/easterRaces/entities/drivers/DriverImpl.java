package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

import static easterRaces.common.ExceptionMessages.CAR_INVALID;

public class DriverImpl implements Driver {
    protected String name;
    protected Car car;
    protected int numberOfWins;
    protected boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        this.canParticipate = false;
    }
    private void setName(String name){
        if (name.length()<5){
            throw new IllegalArgumentException(String.format("Name %s cannot be less than 5 symbols.",name));
        }
        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.car=car;
        canParticipate=true;
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return canParticipate;
    }
}
