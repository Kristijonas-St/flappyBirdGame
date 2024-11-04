package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird extends JFrame implements KeyListener {


    Bird() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bird");
        this.setSize(500, 500);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setVisible(true);
    }

    static int height, length;

    public static void spawnBird() {
        Map.modifyMap(Map.getMapWidth() / 2, 1, 2);
        height = Map.getMapWidth() / 2;
        length = 1;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int previousLength = length;
        int previousHeight = height;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                height--;
                break;
            case KeyEvent.VK_DOWN:
                height++;
                break;
            case KeyEvent.VK_LEFT:
                length--;
                break;
            case KeyEvent.VK_RIGHT:
                length++;
                break;
        }

        Map.modifyMap(previousHeight, previousLength, 0);
        Map.modifyMap(height, length, 2);

        Map.printMap(2);
    }

}
