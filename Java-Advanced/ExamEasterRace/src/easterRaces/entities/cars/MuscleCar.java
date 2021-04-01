package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar{

    public MuscleCar(String model, int horsePower) {
        super(model,horsePower,5000);

    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower<400||horsePower>600){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }
        super.horsePower=horsePower;
    }

}
