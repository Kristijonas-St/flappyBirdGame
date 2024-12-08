package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements KeyListener {
    private Map map;
    private Bird bird;

    public GameFrame(Map map, Bird bird) {
        this.map = map;
        this.bird = bird;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Flappy Bird Game");
        this.setSize(1500, 500);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int cellSize = 20, yOffset = 30;
        int[][] mapForPaint = map.getMapFrame();

        for (int i = 0; i < map.getMapWidth(); i++) {
            for (int j = 0; j < map.getMapLength(); j++) {
                if (mapForPaint[i][j] == 1) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * cellSize, yOffset + i * cellSize, cellSize, cellSize);
                } else if (mapForPaint[i][j] == 2) {
                    g.setColor(Color.RED);
                    g.fillOval(j * cellSize, yOffset + i * cellSize, cellSize, cellSize);
                } else if (mapForPaint[i][j] == 3) {
                    g.setColor(Color.BLACK);
                    g.fillRect(j * cellSize, yOffset + i * cellSize, cellSize, cellSize);
                }
            }
        }


    }


    @Override
    public void keyPressed(KeyEvent e) {
        bird.jump(e, map);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}

