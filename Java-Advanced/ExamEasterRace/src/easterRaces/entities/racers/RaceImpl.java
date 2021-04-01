package easterRaces.entities.racers;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

import static easterRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    protected String name;
    protected int laps;
    protected Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.name = name;
        this.laps = laps;
        drivers=new ArrayList<>();
    }

    //	If the name is null,
    // empty or less than 5 symbols throw an IllegalArgumentException with message "Name {name} cannot be less than 5 symbols."
    @Override
    public String getName() {
        if (this.name==null||this.name.trim().length()<5){
            throw new IllegalArgumentException(String.format(INVALID_NAME,this.name,5));
        }
        return this.name;
    }

    @Override
    public int getLaps() {
        if (this.laps<1){
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS,1));
        }
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver==null){
            throw new IllegalArgumentException(DRIVER_INVALID);
        }else if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
        }
        for (Driver driver1 : drivers) {
            if (driver1==driver){
                throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED,driver.getName(),this.name));
            }
        }
        drivers.add(driver);
    }
}
