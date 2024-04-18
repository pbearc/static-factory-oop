package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.capabilities.ActorType;
import game.capabilities.Status;
import game.behaviours.WanderBehaviour;
import game.actions.AttackAction;
import game.grounds.SpawnableActor;

import java.util.HashMap;
import java.util.Map;

public class HuntsmanSpider extends Actor implements SpawnableActor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(0, new AttackBehaviour());
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
            actions.add(new AttackAction(this, direction));

        }
        return actions;
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "kicks", 25);
    }

    @Override
    public void spawn(Location location) {
        location.addActor(new HuntsmanSpider());
    }
}
