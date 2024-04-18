package game.grounds;

import edu.monash.fit2099.engine.positions.Location;

public abstract class Inheritree extends SpawningGround {

    private int age = 0;

    public Inheritree(char displayChar) {
        super(displayChar);
    }

    @Override
    public void tick(Location location) {
        age++;
        produceFruit2(location, age);
    }

    public void produceFruit2(Location location, int age) {

    }
}
