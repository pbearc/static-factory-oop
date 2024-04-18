package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.SpawnableActor;

public class Crater extends SpawningGround {

    private SpawnableActor spawnableActor;

    public Crater(SpawnableActor spawnableActor) {
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
