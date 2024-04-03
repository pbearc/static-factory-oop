package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inheritree extends Ground {

    private int age = 0;
    private static final char SAPLING_CHAR = 't';
    private static final char MATURE_CHAR = 'T';
    private static final char SMALL_FRUIT_CHAR = 'o';
    private static final char LARGE_FRUIT_CHAR = 'O';

    private static final String SMALL_FRUIT_NAME = "Small Fruit";
    private static final String LARGE_FRUIT_NAME = "Big Fruit";

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
            produceFruit(location, SMALL_FRUIT_NAME, SMALL_FRUIT_CHAR, SMALL_FRUIT_PROBABILITY);
        } else if (this.getDisplayChar() == MATURE_CHAR) {
            produceFruit(location, LARGE_FRUIT_NAME, LARGE_FRUIT_CHAR, LARGE_FRUIT_PROBABILITY);
        }
    }

    private String produceFruit(Location location, String fruitName, char fruitChar, double probability){
        if (Math.random() <= probability){
            List<Exit> exits = new ArrayList<>(location.getExits());
            Collections.shuffle(exits); // Shuffle the list of exits

            for (Exit exit : exits) {
                if(!exit.getDestination().containsAnActor()){
                    exit.getDestination().addItem(new Fruit(fruitName, fruitChar));
                    return "A " + fruitName + " is produced";
                }
            }
        }
        return "No fruit is produced";
    }

}
