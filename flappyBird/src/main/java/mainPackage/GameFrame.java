package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements KeyListener {
    GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Flappy Bird Game");
        this.setSize(800, 500);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setVisible(true);
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
        int previousLength = Bird.getLength();
        int previousHeight = Bird.getHeight();

        Bird.obstacleDetection(e);
        Map.modifyMap(previousHeight, previousLength, 0);
        Map.modifyMap(Bird.getHeight(), Bird.getLength(), 2);


        updateGamePanel();
    }

    public void updateGamePanel() {
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}
