package mainPackage;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Map.formatMap();
        Map.generatePipesForWholeMap();

        Bird.spawnBird();

        Map.printMap(2);


    }
}
