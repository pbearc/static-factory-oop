package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.actors.Player;

public class BigFruit extends Fruit implements Consumable{
    private int healPoint;
    public BigFruit() {
        super("Big Fruit", 'O');
        this.healPoint = 2;
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

    @Override
    public ActionList allowableActions(Actor actor) {
        ActionList actions = super.allowableActions(actor);
        actions.add(new ConsumeAction(this));
        return actions;
    }
}
