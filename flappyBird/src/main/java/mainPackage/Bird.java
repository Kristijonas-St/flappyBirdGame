package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird {


    protected int height, length;
    protected boolean birdHasHitObstacle = false;


    public void spawn(Map map) {
        map.modifyMap(map.getMapWidth() / 2, 1, 2);
        height = map.getMapWidth() / 2;
        length = 1;
    }

    public boolean hasHitObstacle() {
        boolean gameOver = (birdHasHitObstacle) ? true : false;
        return gameOver;
    }

    public void moveRight(Map map, GameFrame gameFrame) {
        if(canPassivelyMoveRight(map)) {
            map.modifyMap(height, length, 0);
            length++;
            map.modifyMap(height, length, 2);
            delayMovement();
        } else {
            birdCrashDown(map);
            birdHasHitObstacle = true;
        }
        gameFrame.repaint();
    }
    public boolean canPassivelyMoveRight(Map map) {
        if (birdHasHitObstacle) {
            return false;
        } else if (map.thereIsObstacleAhead(height, length + 1)) {
            return false;
        } else {
            return true;
        }
    }
    public void delayMovement() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void birdCrashDown(Map map) {
        int[][] mapForPipes = map.getMapFrame();
        while (true) {
            if (height + 1 >= map.getMapWidth() ||
                    mapForPipes[height + 1][length] == 1 ||
                    mapForPipes[height + 1][length] == 3) {
                break;
            }
            map.modifyMap(height, length, 0);
            height++;
            map.modifyMap(height, length, 2);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}
