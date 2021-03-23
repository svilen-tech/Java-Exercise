package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GunRepository<T extends Gun> implements Repository<T>{
   private Collection<T> models;

   public GunRepository(){
       models = new ArrayList<>();
   }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public void add(T model) {
        if (model == null) {
            throw new NullPointerException("Cannot add null in Gun Repository");
        }
        models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return getModels().remove(model);

    }

    @Override
    public T findByName(String name) {
        return this.models.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);

    }
}
