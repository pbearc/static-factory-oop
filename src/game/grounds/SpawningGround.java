package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public abstract class SpawningGround extends Ground {

    public SpawningGround(char displayChar) {
        super(displayChar);
    }

    public abstract void tick(Location location);
}
