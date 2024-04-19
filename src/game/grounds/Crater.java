package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;

public class Crater extends SpawningGround {

    private Spawner spawnableActor;

    public Crater(Spawner spawnableActor) {
        super('u');
        this.spawnableActor = spawnableActor;
    }

    @Override
    public void tick(Location location) {
        if(!location.containsAnActor() && Math.random() <= 0.05){
            spawnableActor.spawn(location);
        }

    }


}
