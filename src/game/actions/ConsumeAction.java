package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.items.Consumable;

public class ConsumeAction extends Action {

    Consumable item;


    public ConsumeAction(Consumable item){
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
//        Player player = (Player) actor;
        item.consumed(actor,map);

        return actor + " consumes " + item + " and " + item + " heals " + actor + " by " + item.getEffectValue() + " hit point";
    }

    @Override
    public String menuDescription(Actor actor) {
//        Player player = (Player) actor;
        return actor + " consumes " + item;
    }
}
