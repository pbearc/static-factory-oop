package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

public class ConsumeAction extends Action {

    Consumable item;


    public ConsumeAction(Consumable item){
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        item.consumed(actor,map);

        return actor + " consumes " + item + " and " + item + item.getEffectDescription();
    }

    @Override
    public String menuDescription(Actor actor) {
//        Player player = (Player) actor;
        return actor + " consumes " + item;
    }
}
