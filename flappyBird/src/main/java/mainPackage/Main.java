package mainPackage;
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Map.formatMap();
        Map.generatePipesForWholeMap();
        Bird.spawnBird();

        new GameFrame();





    }
}
