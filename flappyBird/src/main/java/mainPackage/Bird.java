package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird {

    protected int height, length;
    protected boolean birdHasHitObstacle = false;
    protected int directionIndex = 0;

    public void spawn(Map map) {
        height = map.getMapWidth() / 2;
        length = 1;
        directionIndex = 0;
    }

    public void moveThrough(Map map) {
        if(canPassivelyMoveRight(map)) {
            moveRight();
            delayMovement(200);
        } else {
            birdHasHitObstacle = true;
        }
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


    public void moveRight() {
        length++;
        directionIndex = 1;
    }
    public void delayMovement(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void jump(KeyEvent e, Map map) {
        if (canJumpUp(map)) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                height -= 1;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                height += 1;
            }
        } else {
            birdHasHitObstacle = true;
        }
    }
    public boolean canJumpUp(Map map) {
        if (birdHasHitObstacle) {
            return false;
        } else if (map.thereIsObstacleAhead(height - 1, length)) {
            return false;
        } else {
            return true;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
    public int getDirectionIndex() {
        return directionIndex;
    }
}
