import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements KeyListener {
    static final int TILE_SIZE = 32;
    static final int ROWS = 15;
    static final int COLS = 15;

    Maze maze;
    Player player;

    public GamePanel() {
        maze = new Maze(ROWS, COLS);
        player = new Player(1, 1);
        setPreferredSize(new Dimension(COLS * TILE_SIZE, ROWS * TILE_SIZE));
        setFocusable(true);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        maze.draw(g);
        player.draw(g);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP) player.move(0, -1, maze);
        if(key == KeyEvent.VK_DOWN) player.move(0, 1, maze);
        if(key == KeyEvent.VK_LEFT) player.move(-1, 0, maze);
        if(key == KeyEvent.VK_RIGHT) player.move(1, 0, maze);
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
