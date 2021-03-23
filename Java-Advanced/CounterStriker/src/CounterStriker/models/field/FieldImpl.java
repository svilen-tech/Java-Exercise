package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field{

    @Override
    public String start(Collection<Player> players) {
        String winner;
        List<Player> terrorists = new ArrayList<>();
        List<Player> counterTerrorists = new ArrayList<>();
        for (Player player : players) {
            String name = player.getClass().getSimpleName();
            if (name.equals("Terrorist")) {
                terrorists.add(player);
            } else {
                counterTerrorists.add(player);
            }
        }
        int index = 0;
        boolean changePlayer = true;
        while (counterTerrorists.stream().anyMatch(Player::isAlive) && terrorists.stream().anyMatch(Player::isAlive)) {
            for (Player terrorist : terrorists) {
                for (Player contraTerrorist : counterTerrorists) {
                    contraTerrorist.takeDamage(terrorist.getGun().fire());
                }
            }

            counterTerrorists = counterTerrorists.stream().filter(Player::isAlive).collect(Collectors.toList());

            for (Player contraTerrorist : counterTerrorists) {
                for (Player terrorist : terrorists) {
                    terrorist.takeDamage(contraTerrorist.getGun().fire());
                }
            }

            terrorists = terrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
        }
        return terrorists.stream().anyMatch(Player::isAlive) ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }
}
