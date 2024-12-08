package mainPackage;

import junit.framework.TestCase;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_UP;

public class BirdTest extends TestCase {
    @Test
    public void testMoveRight() {
        Map map = new Map();
        map.formatMap();
        Bird bird = new Bird();
        bird.spawn(map.getMapWidth() / 2, 1);

        int initialLength = bird.getLength();
        bird.moveRight();

        assertEquals(initialLength + 1, bird.getLength());
    }

    @Test
    public void testJump() {
        Map map = new Map();
        map.formatMap();
        Bird bird = new Bird();
        bird.spawn(map.getMapWidth() / 2, 1);

        GameFrame gameFrame = new GameFrame(map, bird);
        KeyEvent keyEvent = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, 'U');
        int initialHeight = bird.getHeight();

        bird.jump(keyEvent, map);
        assertEquals(initialHeight - 2, bird.getHeight());
    }

    @Test
    public void testCrashDown() {
        Map map = new Map();
        int[][] mapFrame = map.getMapFrame();
        map.formatMap();
        Bird bird = new Bird();
        bird.spawn(map.getMapWidth() / 2, 1);
        GameFrame gameFrame = new GameFrame(map, bird);


        bird.crashDown(map, gameFrame);
        assertEquals(3, mapFrame[bird.getHeight() - 1][bird.getLength()]);
    }

    @Test
    public void testCrashDownOnPipes() {
        Map map = new Map();
        int[][] mapFrame = map.getMapFrame();
        map.formatMap();
        map.createPipe();

        Bird bird = new Bird();
        GameFrame gameFrame = new GameFrame(map, bird);

        bird.crashDown(map, gameFrame);
        assertEquals(3, mapFrame[bird.getHeight() - 1][bird.getLength()]);
    }


}