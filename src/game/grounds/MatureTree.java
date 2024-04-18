package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.BigFruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatureTree extends Inheritree{
    private BigFruit fruitToBeSpawn;
    public MatureTree() {
        super('T');
        this.fruitToBeSpawn = new BigFruit();
    }

    public void produceFruit2(Location location, int age){
        if (Math.random() <= 0.3) {
            List<Exit> exits = new ArrayList<>(location.getExits());
            Collections.shuffle(exits); // Shuffle the list of exits

            for (Exit exit : exits) {
                if (!exit.getDestination().containsAnActor()) {
                    fruitToBeSpawn.spawn(exit.getDestination());
                    break; // Stop after adding fruit to one destination
                }
            }
        }

    }
}
