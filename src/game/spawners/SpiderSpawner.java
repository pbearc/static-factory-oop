package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.HuntsmanSpider;

public class SpiderSpawner implements Spawner {
    @Override
    public void spawn(Location location) {
        location.addActor(new HuntsmanSpider());
    }
}
