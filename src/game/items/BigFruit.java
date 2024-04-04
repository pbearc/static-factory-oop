package game.items;

import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;

public class BigFruit extends Fruit{
    public BigFruit() {
        super("Big Fruit", 'O');
    }

    @Override
    public boolean consumed(Player player, GameMap map) {
        player.heal(2);
        player.removeItemFromInventory(this);
        map.locationOf(player).removeItem(this);
        return true;
    }
}
