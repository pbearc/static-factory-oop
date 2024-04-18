package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actors.Player;

public class SmallFruit extends ConsumableFruit implements SpawnableItem{


    public SmallFruit() {
        super("Small Fruit", 'o', 1);

    }

    public void spawn(Location location){
        location.addItem(new SmallFruit());
    }


//
//    public int getPoint(){
//        return this.healPoint;
//    }
//
//    @Override
//    public boolean consumed(Player player, GameMap map) {
//        player.heal(this.healPoint);
//        player.removeItemFromInventory(this);
//        map.locationOf(player).removeItem(this);
//        return true;
//    }
//
//    @Override
//    public ActionList allowableActions(Actor actor) {
//        ActionList actions = super.allowableActions(actor);
//        actions.add(new ConsumeAction(this));
//        return actions;
//    }

}
