package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;

public class DrinkRepositoryImpl<T> implements DrinkRepository<Drink> {
    Collection<Drink> drinkCollection;

    public DrinkRepositoryImpl() {
        drinkCollection = new ArrayList<>();

    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        Drink drinkToRet = null;
        for (Drink drink : drinkCollection) {
           if (drink.getBrand().equals(drinkBrand)&&drink.getName().equals(drinkName)) {
               drinkToRet = drink;
               break;
           }
        }
        return drinkToRet;
    }

    @Override
    public Collection<Drink> getAll() {
        return drinkCollection;
    }

    @Override
    public void add(Drink drink) {
        drinkCollection.add(drink);
    }
}
