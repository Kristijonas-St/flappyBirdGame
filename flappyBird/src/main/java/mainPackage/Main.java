package mainPackage;
import java.awt.*;
import java.util.Random;

public class Main {

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
                System.out.println("Game over...");
                break;
            }

        }




    }
}
