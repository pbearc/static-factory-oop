package game.items;


import edu.monash.fit2099.engine.positions.Location;


public class SmallFruit extends ConsumableFruit implements SpawnableItem{


    public SmallFruit() {
        super("Small Fruit", 'o', 1);

    }

    public void spawn(Location location){
        location.addItem(new SmallFruit());
    }

}
