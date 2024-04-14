package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.BigFruit;
import game.items.Fruit;
import game.items.SmallFruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inheritree extends Ground {

    private int age = 0;
    private static final char SAPLING_CHAR = 't';
    private static final char MATURE_CHAR = 'T';

    private static final double SMALL_FRUIT_PROBABILITY = 0.3;
    private static final double LARGE_FRUIT_PROBABILITY = 0.2;

    public Inheritree() {
        super(SAPLING_CHAR);
//        addCapability(Status.ALIVE);
    }

    @Override
    public void tick(Location location) {
//        super.tick(location);
        age++;
        if (age >= 5 && this.getDisplayChar() == SAPLING_CHAR){
            setDisplayChar(MATURE_CHAR);
        }

        // Produce fruits
        if (this.getDisplayChar() == SAPLING_CHAR) {
            produceFruit(location, SMALL_FRUIT_PROBABILITY);
        } else if (this.getDisplayChar() == MATURE_CHAR) {
            produceFruit(location, LARGE_FRUIT_PROBABILITY);
        }
    }

    private String produceFruit(Location location, double probability) {
        if (Math.random() <= probability) {
            List<Exit> exits = new ArrayList<>(location.getExits());
            Collections.shuffle(exits); // Shuffle the list of exits

            for (Exit exit : exits) {
                if (!exit.getDestination().containsAnActor()) {
                    if (this.getDisplayChar() == SAPLING_CHAR) {
                        exit.getDestination().addItem(new SmallFruit());
                        return "A Small Fruit is produced";
                    } else if (this.getDisplayChar() == MATURE_CHAR) {
                        exit.getDestination().addItem(new BigFruit());
                        return "A Big Fruit is produced";
                    }
                }
            }
        }
        return "No fruit is produced";
    }

}
