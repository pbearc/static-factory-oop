package game.items;

import edu.monash.fit2099.engine.positions.Location;

public interface SpawnableItem {
    default void spawn(Location location) {
    }
}