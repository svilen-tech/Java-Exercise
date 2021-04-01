package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.CarRepository;
import easterRaces.repositories.DriverRepository;
import easterRaces.repositories.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.DRIVER_EXISTS;

public class ControllerImpl implements Controller {
    protected Repository<Car> carRepository;
    protected Repository<Race> raceRepository;
    protected Repository<Driver> driverRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        if (driverRepository.getByName(driver) == null) {
            Driver driver1 = new DriverImpl(driver);
            driverRepository.add(driver1);
            return String.format("Driver %s is created.", driver);
        }
        throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (carRepository.getByName(model) == null) {
            String msg;
            if (type.equals("Muscle")) {
                Car car = new MuscleCar(model, horsePower);
                carRepository.add(car);
                return String.format("MuscleCar %s is created.", model);
            } else {
                Car car = new SportsCar(model, horsePower);
                carRepository.add(car);
                return String.format("SportsCar %s is created.", model);
            }
        }
        throw new IllegalArgumentException(String.format("Car %s is already created.", model));
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (driverRepository.getAll().stream().noneMatch(n -> n.getName().equals(driverName))) {
            throw new IllegalArgumentException(String.format("Driver %s could not be found.", driverName));
        } else if (carRepository.getAll().stream().noneMatch(c -> c.getModel().equals(carModel))) {
            throw new IllegalArgumentException(String.format("Car %s could not be found.", carModel));
        }
        Car ourCar = carRepository.getByName(carModel);
        driverRepository.getByName(driverName).addCar(ourCar);
        return String.format("Driver %s received car %s.", driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (raceRepository.getAll().stream().noneMatch(r -> r.getName().equals(raceName))) {
            throw new IllegalArgumentException(String.format("Race %s could not be found.", raceName));
        } else if (driverRepository.getAll().stream().noneMatch(n -> n.getName().equals(driverName))) {
            throw new IllegalArgumentException(String.format("Driver %s could not be found.", driverName));
        }

        raceRepository.getByName(raceName).addDriver(driverRepository.getByName(driverName));
        return String.format("Driver %s added in %s race.", driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getAll().stream().noneMatch(r -> r.getName().equals(raceName))) {
            throw new IllegalArgumentException(String.format("Race %s could not be found.", raceName));
        } else if (raceRepository.getByName(raceName).getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format("Race %s cannot start with less than 3 participants.", raceName));
        }
        //To do this you should sort all Drivers in descending order by the result of
        // CalculateRacePoints method in the Car object. At the end, if everything is
        // valid remove this Race from the race repository.
        int laps = raceRepository.getByName(raceName).getLaps();

        List<Driver> collect = raceRepository.getByName(raceName).getDrivers().stream()
                .sorted(Comparator.comparingDouble(a -> a.getCar().calculateRacePoints(laps)))
                .limit(3)
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();

        List<Driver> collect1 = new ArrayList<>();
        for (int i = collect.size()-1; i >=0 ; i--) {
            collect1.add(collect.get(i));
        }
        sb.append(String.format("Driver %s wins %s race.", collect1.get(0).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format("Driver %s is second in %s race.", collect1.get(1).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format("Driver %s is third in %s race.", collect1.get(2).getName(), raceName));
        return sb.toString();
        //raceRepository.getByName(raceName).getDrivers().stream()
        //                .sorted((a,b)-> {
        //                    double result = 0;
        //                    result=a.getCar().calculateRacePoints(laps)-b.getCar().calculateRacePoints(laps);
        //                    return result;
        //                }).
        //(a,b)-> a.getCar().calculateRacePoints(laps)-b.getCar().calculateRacePoints(laps)

    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getAll().stream().anyMatch(r -> r.getName().equals(name))) {
            throw new IllegalArgumentException(String.format("Race %s is already created.", name));
        }
        Race race = new RaceImpl(name, laps);
        raceRepository.add(race);
        return String.format("Race %s is created.", name);
    }
}
