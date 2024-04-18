package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;

public class ConsumableFruit extends Item implements Consumable{
    private int effectValue;
    public ConsumableFruit(String fruitName, char displayChar, int effectValue) {
        super(fruitName, displayChar, true);
        this.effectValue = effectValue;
    }

    public int getEffectValue(){
        return this.effectValue;
    }

    @Override
    public boolean consumed(Actor player, GameMap map) {
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
