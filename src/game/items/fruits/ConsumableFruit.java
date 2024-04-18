package game.items.fruits;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.items.Consumable;

public class ConsumableFruit extends Item implements Consumable {
    private int effectValue;
    public ConsumableFruit(String fruitName, char displayChar, int effectValue) {
        super(fruitName, displayChar, true);
        this.effectValue = effectValue;
    }

    public int getEffectValue(){
        return this.effectValue;
    }

    @Override
    public void consumed(Actor player, GameMap map) {
        player.heal(this.getEffectValue());
        player.removeItemFromInventory(this);
        map.locationOf(player).removeItem(this);
    }

    @Override
    public ActionList allowableActions(Actor actor) {
        ActionList actions = super.allowableActions(actor);
        actions.add(new ConsumeAction(this));
        return actions;
    }

}
