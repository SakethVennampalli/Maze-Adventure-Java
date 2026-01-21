import java.awt.*;
import java.util.Random;

public class Maze {
    int[][] grid;
    int rows, cols;
    Random rand = new Random();

    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int TRAP = 2;
    public static final int TELEPORT = 3;
    public static final int EXIT = 4;

    public Maze(int r, int c) {
        rows = r;
        cols = c;
        grid = new int[rows][cols];
        generate();
    }

    void generate() {
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || j==0 || i==rows-1 || j==cols-1)
                    grid[i][j] = WALL;
                else {
                    int x = rand.nextInt(100);
                    if(x < 20) grid[i][j] = WALL;
                    else if(x < 25) grid[i][j] = TRAP;
                    else if(x < 28) grid[i][j] = TELEPORT;
                }
            }
        }
        grid[rows-2][cols-2] = EXIT;
    }

    void draw(Graphics g){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                switch(grid[i][j]){
                    case WALL: g.setColor(Color.BLACK); break;
                    case TRAP: g.setColor(Color.RED); break;
                    case TELEPORT: g.setColor(Color.MAGENTA); break;
                    case EXIT: g.setColor(Color.GREEN); break;
                    default: g.setColor(Color.WHITE);
                }
                g.fillRect(j*32, i*32, 32, 32);
            }
        }
    }
}
