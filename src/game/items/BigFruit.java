package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actors.Player;

public class BigFruit extends ConsumableFruit implements SpawnableItem{

    public BigFruit() {
        super("Big Fruit", 'O', 2);
    }

    public void spawn(Location location){
        location.addItem(new BigFruit());
    }

}
