package game.grounds;

import edu.monash.fit2099.engine.positions.Location;

public class Crater extends SpawningGround {

    private SpawnableActor spawnableActor;

    public Crater(SpawnableActor spawnableActor) {
        super('u');
        this.spawnableActor = spawnableActor;
    }

    @Override
    public void tick(Location location) {
        if(!location.containsAnActor() && Math.random() <= 0.05){
//            location.addActor(new HuntsmanSpider());
            spawnableActor.spawn(location);
        }

    }


}
