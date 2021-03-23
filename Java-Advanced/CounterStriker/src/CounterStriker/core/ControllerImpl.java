package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.GunImpl;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.PlayerImpl;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Gun> guns;
    private Repository<Player> players;
    private Field field;
    public ControllerImpl(){
        this.guns = new GunRepository<>();
        this.players = new PlayerRepository<>();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        if (type.equals("Pistol")) {
            Gun pistol = new Pistol(name, bulletsCount);
            guns.add(pistol);
        } else if (type.equals("Rifle")) {
            Gun rifle = new Rifle(name, bulletsCount);
            guns.add(rifle);
        } else {
            throw new IllegalArgumentException("Invalid gun type.");
        }
        return "Successfully added gun " + name + ".";
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        if (guns.findByName(gunName) == null) {
            throw new NullPointerException("Gun cannot be found!");
        }
        if (type.equals("Terrorist")) {
            Player terrorist = new Terrorist(username, health, armor,guns.findByName(gunName));
            players.add(terrorist);
        } else if (type.equals("CounterTerrorist")) {
            Player counterTerrorist =
                    new CounterTerrorist(username, health, armor,guns.findByName(gunName));
            players.add(counterTerrorist);
        }else{
            throw new IllegalArgumentException("Invalid player type!");
        }
        return "Successfully added player "+username+".";
    }

    @Override
    public String startGame() {
        Collection<Player> players = this
                .players
                .getModels()
                .stream()
                .filter(Player::isAlive)
                .collect(Collectors.toList());
        return this.field.start(players);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        this
                .players
                .getModels()
                .stream()
                .sorted((p1, p2) -> {
                    int result = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
                    if (result == 0) {
                        result = Integer.compare(p2.getHealth(), p1.getHealth());
                    }
                    if (result == 0) {
                        result = p1.getUsername().compareTo(p2.getUsername());
                    }
                    return result;
                })
                .forEach(p -> sb
                        .append(p.toString())
                        .append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
