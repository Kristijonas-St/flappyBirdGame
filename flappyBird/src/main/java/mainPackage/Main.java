package mainPackage;
import java.awt.*;
import java.util.Random;

public class Main {
    static boolean gameOver = false;
    static int score = 0;

    public static void main(String[] args) {
        Map map = new Map();
        Bird bird = new Bird();

        map.formatMap();
        map.generatePipesForWholeMap();

        GameFrame gameFrame = new GameFrame(map, bird);
        map.printMapInConsole();
    }
}

