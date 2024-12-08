package mainPackage;
import java.awt.*;
import java.util.Random;

public class Main {
    static boolean birdIsAlive = true;
    static int score = 0;

    public static void main(String[] args) {
        Map map = new Map();
        Bird bird = new Bird();

        map.formatMap();
        map.generatePipesForWholeMap();

        GameFrame gameFrame = new GameFrame(map, bird);

        bird.spawn(map);
        map.modifyBirdPosition(bird.getHeight(), bird.getLength(), bird.getDirectionIndex());

        while(true) {
            if(bird.canPassivelyMoveRight(map)) {
                bird.moveThrough(map);
                map.modifyBirdPosition(bird.getHeight(), bird.getLength(), bird.getDirectionIndex());
                gameFrame.repaint();
            } else {
                System.out.println("Game over");
                break;
            }

        }
    }
}

