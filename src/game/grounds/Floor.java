package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.capabilities.GroundType;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Floor extends Ground {
    public Floor() {
        super('_');
        addCapability(GroundType.RESTRICTED);
    }
}
