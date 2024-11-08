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

        int i = 0;
        while(true) {
            if(Bird.passivelyMoveRight()) {
                gameFrame.updateGamePanel();
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                if(i == 1 && Bird.passivelyFallDown()) {
                    System.out.println("Nachos");
                    gameFrame.updateGamePanel();
                    i = 0;
                } else {
                    i++;
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
