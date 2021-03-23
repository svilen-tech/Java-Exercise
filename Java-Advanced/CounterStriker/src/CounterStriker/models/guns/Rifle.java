package CounterStriker.models.guns;

public class Rifle extends GunImpl{

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < 10) {
            return 0;
        }
        super.decreaseBullets(10);
        return 10;
    }
}
