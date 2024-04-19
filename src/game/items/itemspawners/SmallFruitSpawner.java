package game.items.itemspawners;

import edu.monash.fit2099.engine.positions.Location;
import game.items.fruits.SmallFruit;

public class SmallFruitSpawner implements ItemSpawner {
    @Override
    public void spawn(Location location) {
        location.addItem(new SmallFruit());
    }
}
