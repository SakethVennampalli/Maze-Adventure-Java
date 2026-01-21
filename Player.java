import java.awt.*;
import java.util.Random;

public class Player {
    int x, y;
    Random rand = new Random();

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void move(int dx, int dy, Maze maze){
        int nx = x + dx;
        int ny = y + dy;

        if(maze.grid[ny][nx] == Maze.WALL) return;

        if(maze.grid[ny][nx] == Maze.TRAP){
            x = 1;
            y = 1;
            return;
        }

        if(maze.grid[ny][nx] == Maze.TELEPORT){
            x = rand.nextInt(maze.cols-2)+1;
            y = rand.nextInt(maze.rows-2)+1;
            return;
        }

        x = nx;
        y = ny;
    }

    void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x*32, y*32, 32, 32);
    }
}
