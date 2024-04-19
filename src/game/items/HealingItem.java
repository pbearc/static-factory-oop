package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;

public abstract class HealingItem extends Item implements Consumable {
    private int effectValue;
    public HealingItem(String name, char displayChar, int effectValue) {
        super(name, displayChar, true);
        this.effectValue = effectValue;
    }

    public int getEffectValue(){
        return this.effectValue;
    }
    public String getEffectDescription(){
        return " heals " + this.getEffectValue() + " hit points";
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
