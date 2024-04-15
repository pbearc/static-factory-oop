package game.items;

import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;

public class SmallFruit extends Fruit {

    private int healPoint;
    public SmallFruit() {
        super("Small Fruit", 'o');
        this.healPoint = 1;
    }

    public int getPoint(){
        return this.healPoint;
    }

    @Override
    public boolean consumed(Player player, GameMap map) {
        player.heal(this.healPoint);
        player.removeItemFromInventory(this);
        map.locationOf(player).removeItem(this);
        return true;
    }

}
