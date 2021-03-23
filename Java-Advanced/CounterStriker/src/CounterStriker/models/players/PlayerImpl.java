package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private Gun gun;
    private boolean isAlive;


    public PlayerImpl(String username, int health, int armor, Gun gun) {

        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
    }

    private void setUsername(String username) {
        if (username==null||username.trim().length()<1){
            throw new NullPointerException("Username cannot be null or empty.");
        }
        this.username=username;
    }


    private void setHealth(int health) {
        if (health<0){
            throw new IllegalArgumentException("Player health cannot be below 0.");
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor<0){
            throw new IllegalArgumentException("Player armor health cannot be below 0.");
        }
        this.armor = armor;
    }

    private void setGun(Gun gun) {
     if (gun==null){
         throw new NullPointerException( "Gun cannot be null.");
     }
     this.gun=gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return getHealth()>0;
    }



    @Override
    public void takeDamage(int points) {

        int dmg = points;
        if (dmg>=this.getArmor()){
            this.armor = 0;
            this.health -=dmg;
        }else {
            this.armor -= dmg;
        }
        //The takeDamage() method decreases the Player's armor and health. First you need to reduce the armor.
        // If the armor reaches 0, transfer the damage to health points.
        // If the health points are less than or equal to zero, the player is dead.
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s", this.getClass().getSimpleName(), this.username)).append(System.lineSeparator());
        sb.append(String.format("--Health: %d", this.health)).append(System.lineSeparator());
        sb.append(String.format("--Armor: %d", this.armor)).append(System.lineSeparator());
        sb.append(String.format("--Gun: %s", this.gun.getName()));

        return sb.toString().trim();
    }
}
