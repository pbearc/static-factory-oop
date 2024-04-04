package game.items;

import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;

public class SmallFruit extends Fruit {
    public SmallFruit() {
        super("Small Fruit", 'o');
    }

    @Override
    public boolean consumed(Player player, GameMap map) {
        player.heal(1);
        player.removeItemFromInventory(this);
        map.locationOf(player).removeItem(this);
        return true;
    }
}
