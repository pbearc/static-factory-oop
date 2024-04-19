package game.actors.actorspawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.HuntsmanSpider;

public class HuntsmanSpiderSpawner implements ActorSpawner {
    @Override
    public void spawn(Location location) {
        location.addActor(new HuntsmanSpider());
    }
}
