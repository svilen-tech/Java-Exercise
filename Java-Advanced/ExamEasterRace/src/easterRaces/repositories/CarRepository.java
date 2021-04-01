package easterRaces.repositories;

import easterRaces.entities.cars.Car;
import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class CarRepository<T extends Car> implements Repository<T> {
    private Collection<T> models;
    public CarRepository(){
        this.models=new ArrayList<>();
    }
    @Override
    public T getByName(String name) {
        return this.models.stream().filter(m -> m.getModel().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<T> getAll() {
        return models;
    }

    @Override
    public void add(T model) {
        models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return models.remove(model);
    }
}
