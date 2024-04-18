package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.items.fruits.SmallFruit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SaplingTree extends Inheritree {
    private SmallFruit fruitToBeSpawn;
    public SaplingTree() {
        super('t');
        this.fruitToBeSpawn = new SmallFruit();
    }

    public void produceFruit(Location location, int age){
        if (age > 5){
            location.setGround(new MatureTree());
        }
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
