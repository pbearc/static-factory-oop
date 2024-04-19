package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Consumable {

    void consumed(Actor actor, GameMap map);

    int getEffectValue();
    String getEffectDescription();
}