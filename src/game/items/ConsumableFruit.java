package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.actors.Player;

public class ConsumableFruit extends Fruit implements Consumable{
    private int effectValue;
    public ConsumableFruit(String fruitName, char displayChar, int effectValue) {
        super(fruitName, displayChar);
        this.effectValue = effectValue;
    }

    public int getEffectValue(){
        return this.effectValue;
    }

    @Override
    public boolean consumed(Player player, GameMap map) {
        player.heal(this.getEffectValue());
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

//    @Override
//    public int getPoint() {
//        return 0;
//    }
}
