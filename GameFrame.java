import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Maze Adventure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new GamePanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
