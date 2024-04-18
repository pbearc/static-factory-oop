package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.SpawningGround;

public abstract class Inheritree extends SpawningGround {

    private int age = 0;

    public Inheritree(char displayChar) {
        super(displayChar);
    }

    @Override
    public void tick(Location location) {
        age++;
        produceFruit(location, age);
    }

    public void produceFruit(Location location, int age) {

    }
}
