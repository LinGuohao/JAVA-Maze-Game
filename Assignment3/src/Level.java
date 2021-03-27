import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.ImageIcon;
public class Level {
    private final int WALL_WIDTH = 40;
    private final int WALL_HEIGHT = 40;
    public ArrayList<Wall> walls;
    /**
     * Constructor.
     * @param levelPath
     * @throws java.io.IOException
     */
    public Level(String levelPath) throws IOException {
        loadLevel(levelPath);
    }

    /**
     * Read the map file and generate the map.
     * @param levelPath
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void loadLevel(String levelPath) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(levelPath));
        walls = new ArrayList<>();
        int y = 0;
        String line;
        while ((line = br.readLine()) != null) {
            int x = 0;
            for (char blockType : line.toCharArray()) {
                if (Character.isDigit(blockType)) {
                    Image image = new ImageIcon("image/wall.png").getImage();
                    walls.add(new Wall(x * WALL_WIDTH, y * WALL_HEIGHT, WALL_WIDTH, WALL_HEIGHT, image));
                }
                x++;
            }
            y++;
        }
    }
/**
     * Draw walls.
     * @param g
     */
    public void draw(Graphics g) {
        for (Wall wall : walls) {
            wall.draw(g);
        }
    }
/**
     * Determine if the dragon intersects the walls.
     * @param dragon
     */
    public boolean collides(Dragon dragon) {
        Wall collidedWith = null;
        for (Wall wall : walls){
            if (dragon.collides(wall)) {
                collidedWith = wall;
                break;
            }
        }
        if (collidedWith != null) {
            
            return true;
        } else {
            return false;
        }
    }
/**
     * Determine if the player intersects the walls.
     * @param player
     */
	public boolean collides(Player player) {
        Wall collidedWith = null;
        for (Wall wall : walls)
        {
            if(player.collides(wall))
            {
                collidedWith = wall;
                break;
            }
        }
        if (collidedWith != null) {
            
            return true;
        } else {
            return false;
        }
        
	}
}
