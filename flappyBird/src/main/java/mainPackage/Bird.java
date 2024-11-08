package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird {


    static int height, length;

    public static void spawnBird() {
        Map.modifyMap(Map.getMapWidth() / 2, 1, 2);
        height = Map.getMapWidth() / 2;
        length = 1;
    }


    public static void obstacleDetection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if(Map.thereIsObstacleAhead(height - 1, length)) {
                    System.out.println("Obstacle hit");
                } else {
                    height--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(Map.thereIsObstacleAhead(height + 1, length)) {
                    System.out.println("Obstacle hit");
                } else {
                    height++;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(Map.thereIsObstacleAhead(height, length - 1)) {
                    System.out.println("Obstacle hit");
                } else {
                    length--;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(Map.thereIsObstacleAhead(height, length + 1)) {
                    System.out.println("Obstacle hit");
                } else {
                    length++;
                }
                break;
        }
    }

    public static int getHeight() {
        return height;
    }

    public static int getLength() {
        return length;
    }
}
