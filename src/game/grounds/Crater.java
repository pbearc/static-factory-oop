package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.HuntsmanSpider;

public class Crater extends SpawningGround {

    public Crater() {
        super('u');
    }

    @Override
    public void tick(Location location) {
        if(Math.random() <= 0.05 && !location.containsAnActor()){
            location.addActor(new HuntsmanSpider());
        }
    }


}
