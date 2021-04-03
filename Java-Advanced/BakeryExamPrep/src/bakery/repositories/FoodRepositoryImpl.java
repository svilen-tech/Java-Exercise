package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl<T> implements FoodRepository<BakedFood> {
    Collection<BakedFood> foods;

    public FoodRepositoryImpl(){
        foods=new ArrayList<>();
    }
    @Override
    public BakedFood getByName(String name) {
        BakedFood foodToRet = null;
        for (BakedFood food : foods) {
            if (food.getName().equals(name)){
                foodToRet=food;
                break;
            }
        }
        return foodToRet;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return foods;
    }

    @Override
    public void add(BakedFood bakedFood) {
        foods.add(bakedFood);
    }
}
