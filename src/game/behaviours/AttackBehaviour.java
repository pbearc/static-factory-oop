package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.capabilities.Status;

public class AttackBehaviour implements Behaviour {

    public Action getAction(Actor actor, GameMap map) {
        // Get the location of the actor and the target
        Location here = map.locationOf(actor);
//        Location targetLocation = map.locationOf(target);

        // Iterate over the actor's exits
        for (Exit exit : here.getExits()) {
            // Check if the exit's destination is the same as the target's location
            if (exit.getDestination().containsAnActor()) {
                Actor target = exit.getDestination().getActor();
                if (target.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    // If the target is within the actor's exits, return an attack action
                    return new AttackAction(target, "surrounding");
                }

            }
        }

        // If the target is not within the actor's exits, return null
        return null;
    }
}
