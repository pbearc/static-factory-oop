package game.items.itemspawner;

import edu.monash.fit2099.engine.positions.Location;
import game.items.fruits.BigFruit;

public class BigFruitSpawner implements ItemSpawner {
    @Override
    public void spawn(Location location) {
        location.addItem(new BigFruit());
    }
}
