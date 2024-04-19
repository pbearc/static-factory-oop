package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;
import game.spawners.BigFruitSpawner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatureTree extends Inheritree {
    private Spawner fruitToBeSpawn;
    public MatureTree() {
        super('T');
        this.fruitToBeSpawn = new BigFruitSpawner();
    }

    public void produceFruit(Location location, int age){
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
