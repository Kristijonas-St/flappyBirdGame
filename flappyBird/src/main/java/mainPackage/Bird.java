package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird {


    static int height, length;
    static boolean birdHasHitObstacle = false;

    public static void spawnBird() {
        Map.modifyMap(Map.getMapWidth() / 2, 1, 2);
        height = Map.getMapWidth() / 2;
        length = 1;
    }

    public static boolean obstacleDetection(KeyEvent e) {
        if(birdHasHitObstacle) {
            return true;
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if(Map.thereIsObstacleAhead(height - 1, length)) {
                        System.out.println("Upper obstacle hit");
                        birdHasHitObstacle = true;
                    } else {
                        height--;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(Map.thereIsObstacleAhead(height + 1, length)) {
                        System.out.println("Lower obstacle hit");
                        birdHasHitObstacle = true;
                    } else {
                        height++;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if(Map.thereIsObstacleAhead(height, length - 1)) {
                        System.out.println("Left side obstacle hit");
                        birdHasHitObstacle = true;
                    } else {
                        length--;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(Map.thereIsObstacleAhead(height, length + 1)) {
                        System.out.println("Right side obstacle hit");
                        birdHasHitObstacle = true;
                    } else {
                        length++;
                    }
                    break;
            }
        }
        return false;

    }

    public static boolean passivelyMoveRight() {
        if (birdHasHitObstacle) {
            return false;
        } else if (Map.thereIsObstacleAhead(height, length + 1)) {
            System.out.println("PASSIVE right obstacle hit");
            birdHasHitObstacle = true;
        } else {
            Map.modifyMap(height, length, 0);
            length++;
            Map.modifyMap(height, length, 2);
        }
        return true;
    }

    public static boolean passivelyFallDown() {
        if (birdHasHitObstacle) {
            return false;
        } else if (Map.thereIsObstacleAhead(height + 1, length)) {
            System.out.println("PASSIVE right obstacle hit");
            birdHasHitObstacle = true;
        } else {
            Map.modifyMap(height, length, 0);
            height++;
            Map.modifyMap(height, length, 2);
        }
        return true;
    }



    public static int getHeight() {
        return height;
    }

    public static int getLength() {
        return length;
    }
}
