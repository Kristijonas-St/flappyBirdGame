package mainPackage;
import java.awt.*;
import java.util.Random;

public class Main {
    static int score = 0;
    public static void main(String[] args) {
        Map map = new Map();
        Bird bird = new Bird();

        map.formatMap();
        map.generatePipesForWholeMap();

        GameFrame gameFrame = new GameFrame(map, bird);

        bird.spawn(map.getMapWidth() / 2, 1);
        map.modifyBirdPosition(bird.getHeight(), bird.getLength());

        while(bird.canPassivelyMoveRight(map)) {
            bird.move(map);
            map.modifyBirdPosition(bird.getHeight(), bird.getLength());
            gameFrame.repaint();
        }
        bird.crashDown(map, gameFrame);
        System.out.println("Game over");

    }

}

