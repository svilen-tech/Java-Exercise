package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.PlayerImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerRepository<T extends Player> implements Repository<T> {
    Collection<T> models;

    public PlayerRepository(){
        models = new ArrayList<>();
    }

    @Override
    public  Collection<T> getModels() {
        return this.models;

    }

    @Override
    public void add(T model) {
        if (model == null) {
            throw new NullPointerException("Cannot add null in Player Repository");
        }
        models.add(model);


    }

    @Override
    public boolean remove(T model) {
        return models.remove(model);

    }

    @Override
    public T findByName(String name) {
        return this.models.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
    }
}
