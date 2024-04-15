package game.items;

import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;

public interface Consumable {

    boolean consumed(Player player, GameMap map);

    int getPoint();
}