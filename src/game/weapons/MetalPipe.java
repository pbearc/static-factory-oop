package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.PickUpWeaponAction;
import game.capabilities.Status;

public class MetalPipe extends WeaponItem {

    public MetalPipe() {
        super("Metal Pipe", '!', 1, "hits", 20);
        this.addCapability(Status.HIT_WITH_PIPE);
    }

    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if (portable)
            return new PickUpWeaponAction(this);
        return null;
    }
}
