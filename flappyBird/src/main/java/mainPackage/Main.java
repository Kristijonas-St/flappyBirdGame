package mainPackage;
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Map.formatMap();
        Map.generatePipesForWholeMap();
        Bird.spawnBird();

        new GameFrame();
        GameFrame gameFrame = new GameFrame();


        while(true) {
            Bird.passivelyMoveRight();
            gameFrame.updateGamePanel();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }




    }
}
