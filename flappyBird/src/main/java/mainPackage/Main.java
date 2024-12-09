package mainPackage;
import java.awt.*;
import java.util.Random;

public class Main {
    static int score = 0;
    public static void main(String[] args) {
        GameElementFactory factory = new DefaultGameElementFactory();

        Map map = factory.createMap();
        Bird bird = factory.createBird();
        GameFrame gameFrame = new GameFrame(map, bird);

        while(bird.canPassivelyMoveRight(map)) {
            bird.move(map);
            map.modifyBirdPosition(bird.getHeight(), bird.getLength());
            gameFrame.repaint();
            bird.countScore(map);
        }
        bird.crashDown(map, gameFrame);
        System.out.println("Game over");
    }
}

