package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.actors.Player;

public abstract class Fruit extends Item{

    public Fruit(String fruitName, char displayChar){
        super(fruitName, displayChar, true);
    }


}
