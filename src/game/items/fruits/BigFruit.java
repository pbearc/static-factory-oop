package game.items.fruits;

import edu.monash.fit2099.engine.positions.Location;
import game.items.SpawnableItem;

public class BigFruit extends ConsumableFruit implements SpawnableItem {

    public BigFruit() {
        super("Big Fruit", 'O', 2);
    }

    public void spawn(Location location){
        location.addItem(new BigFruit());
    }

}
