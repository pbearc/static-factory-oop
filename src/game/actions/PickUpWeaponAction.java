package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class PickUpWeaponAction extends PickUpAction {
    private final WeaponItem weapon;

    public PickUpWeaponAction(WeaponItem weapon) {
        super(weapon);
        this.weapon = weapon;
    }
}