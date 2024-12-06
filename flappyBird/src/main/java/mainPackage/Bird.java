package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird {


    protected int height, length;
    protected boolean birdHasHitObstacle = false;

    Map map = new Map();

    public void spawnBird() {
        map.modifyMap(map.getMapWidth() / 2, 1, 2);
        height = map.getMapWidth() / 2;
        length = 1;
    }



    public boolean obstacleDetection(KeyEvent e) {
        if(birdHasHitObstacle) {
            return true;
        } else if(map.thereIsObstacleAhead(height + 1, length) || map.thereIsObstacleAhead(height, length)  ) {
            return true;
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if(map.thereIsObstacleAhead(height - 1, length)) {
                        birdHasHitObstacle = true;
                    } else {
                        height--;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(map.thereIsObstacleAhead(height + 1, length)) {
                        birdHasHitObstacle = true;
                    } else {
                        height++;
                    }
                    break;
            }
        }
        return false;

    }

    public boolean passivelyMoveRight() {
        if (birdHasHitObstacle) {
            return false;
        } else if (map.thereIsObstacleAhead(height, length + 1)) {
            birdHasHitObstacle = true;
        } else {
            map.modifyMap(height, length, 0);
            length++;
            map.modifyMap(height, length, 2);
        }
        return true;
    }

    public boolean passivelyFallDown() {
        if (birdHasHitObstacle) {
            return false;
        } else if (map.thereIsObstacleAhead(height + 1, length)) {
            birdHasHitObstacle = true;
        } else {
            map.modifyMap(height, length, 0);
            height++;
            map.modifyMap(height, length, 2);
        }
        return true;
    }

    public  boolean passesThroughPipes() {
        int[][] mapForPipes = map.getMapFrame();
        int currentColumn = length;

        for (int i = 0; i < map.getMapWidth(); i++) {
            if (mapForPipes[i][currentColumn] == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean crashDown() {
        int[][] mapForPipes = map.getMapFrame();

        if (height + 1 >= map.getMapWidth() || mapForPipes[height + 1][length] == 1 || mapForPipes[height + 1][length] == 3) {
            return false;
        } else {
            map.modifyMap(height, length, 0);
            height++;
            map.modifyMap(height, length, 2);
            return true;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}
