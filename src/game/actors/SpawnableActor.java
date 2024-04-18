package game.actors;

import edu.monash.fit2099.engine.positions.Location;

public interface SpawnableActor {
    default void spawn(Location location) {
    }
}
