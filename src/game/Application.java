package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Inheritree());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        ".............#___#...........~",
                        ".............#___#..........~~",
                        ".............##_##.........~~~",
                        ".................~~........~~~",
                        "................~~~~....t..~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.......t.~",
                        ".....~~~...~~~~~~~~~....t.....",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        gameMap.at(7, 9).addActor(new HuntsmanSpider());
        gameMap.at(3, 9).addItem(new LargeBolt());
        gameMap.at(18, 2).addItem(new LargeBolt());
        gameMap.at(24, 10).addItem(new LargeBolt());
        gameMap.at(6, 3).addItem(new MetalSheet());
        gameMap.at(22, 6).addItem(new MetalSheet());
        gameMap.at(7, 13).addItem(new MetalSheet());

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));

        world.run();
    }
}
