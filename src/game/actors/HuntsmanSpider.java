package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.behaviours.AttackBehaviour;
import game.capabilities.ActorType;
import game.capabilities.Status;
import game.behaviours.WanderBehaviour;
import game.actions.AttackAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuntsmanSpider extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.behaviours.put(999, new WanderBehaviour());
        this.addCapability(ActorType.SPIDER);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map); // will return new ActionList()
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            this.behaviours.put(0, new AttackBehaviour(otherActor, direction));

            // Retrieve the player's inventory
            List<Item> playerInventory = otherActor.getItemInventory();

            // Iterate over each item in the player's inventory
            for (Item item : playerInventory) {
                // Check if the item has the "hit_with_pipe" status
                if (item.hasCapability(Status.HIT_WITH_PIPE)) {
                    // Pass the item to the AttackAction constructor when creating the attack action
                    actions.add(new AttackAction(this, direction, (Weapon) item));  // player can hit spider with metalpipe
                    break; // Stop iterating after finding the first item with the status
                }
            }
            actions.add(new AttackAction(this, direction));

        }
        return actions;
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "kicks", 25);
    }

}
