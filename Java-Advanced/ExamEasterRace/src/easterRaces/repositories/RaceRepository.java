package easterRaces.repositories;

import easterRaces.entities.racers.Race;
import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class RaceRepository<T extends Race>implements Repository<T> {
    private Collection<T> models;
    public RaceRepository(){
        this.models=new ArrayList<>();
    }
    @Override
    public T getByName(String name) {
        return this.models.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
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
