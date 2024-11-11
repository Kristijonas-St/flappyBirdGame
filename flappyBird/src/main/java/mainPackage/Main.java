package mainPackage;
import java.awt.*;
import java.util.Random;

public class Main {
    static boolean gameOver = false;
    static int score = 0;

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
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if(i == 1 && Bird.passivelyFallDown()) {
                    gameFrame.updateGamePanel();
                    i = 0;
                } else {
                    i++;
                }
                if(Bird.passesThroughPipes() && !Bird.birdHasHitObstacle) {
                    score++;
                }
            } else {
                if(Bird.birdHasHitObstacle) {
                    gameOver = true;
                    while(Bird.crashDown()) {
                        gameFrame.updateGamePanel();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                }
            }

        }


    }
}
