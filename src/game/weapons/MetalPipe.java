package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.ConsumeAction;
import game.actions.PickUpWeaponAction;
import game.capabilities.Status;

public class MetalPipe extends WeaponItem {

    public MetalPipe() {
        super("Metal Pipe", '!', 1, "hits", 20);
//        this.addCapability(Status.HIT_WITH_PIPE);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = super.allowableActions(otherActor, location);
        // Check if the otherActor is not hostile to enemies
        if (!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Add the AttackAction only if the otherActor is not hostile to enemies
            actions.add(new AttackAction(otherActor, location, this));
        }
        return actions;

    }
}
