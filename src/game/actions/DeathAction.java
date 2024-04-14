package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.FancyMessage;

public class DeathAction extends Action {
    private GameMap mapDie;
    private Actor attacker;

    public DeathAction(Actor actor, GameMap map) {
        this.attacker = actor;
        this.mapDie = map;
    }
    @Override
    public String execute(Actor target, GameMap map) {

        return menuDescription(target);
    }

    @Override
    public String menuDescription(Actor target) {
        String result = "";
        result += "\n" + FancyMessage.YOU_ARE_FIRED;
        result += "\n" + target.unconscious(this.attacker, this.mapDie);
        return result;
    }
}
