package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bird extends JFrame implements KeyListener {


    Bird() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Flappy Bird Game");
        this.setSize(800, 500);
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int cellSize = 20;
        int[][] map = Map.getMapFrame();

        for (int i = 0; i < Map.getMapWidth(); i++) {
            for (int j = 0; j < Map.getMapLength(); j++) {
                if (map[i][j] == 1) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } else if (map[i][j] == 2) {
                    g.setColor(Color.RED);
                    g.fillOval(j * cellSize, i * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
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
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

}
