package mainPackage;
import java.awt.*;
import java.util.Random;

public class Main {
    static boolean gameOver = false;

    public static void main(String[] args) {
        Map.formatMap();
        Map.generatePipesForWholeMap();
        Bird.spawnBird();

        GameFrame gameFrame = new GameFrame();


        while(true) {
            if(Bird.passivelyMoveRight()) {
                gameFrame.updateGamePanel();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                gameOver = true;
                gameFrame.updateGamePanel();
                System.out.println("Game over...");
                break;
            }

        }




    }
}
