import java.awt.Image;
import java.awt.Rectangle;
public class Player extends Sprite {
    private double velx = 0;
    private double vely = 0;
    private boolean WhetherX = true;
    public String tendDir = "x";
    public double tendValue =0; 
    /**
     * Constructor.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     */
    public Player(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
        
    }
    /**
     * X axis movement control 
     */
    public void moveX() {
        if ((velx < 0 && x > 0) || (velx > 0 && x + width <= 780)) {
            x += velx;
        }
    }
     /**
     * Y axis movement control 
     */
    public void moveY()
    {
        if ((vely < 0 && y > 0) || (vely > 0 && y + height <= 740)) {
            y += vely;
        }
    }
	public void setVely(double vely) {
        this.vely = vely;
        tendValue = vely;
        tendDir = "y";
        WhetherX = false;
	}

	public void setVelx(double velx) {
        this.velx = velx;
        tendValue = velx;
        tendDir ="x";
        WhetherX = true;
    }
    
    public double getVelx() {
        return velx;
    }

    public double getVely() {
        return vely;
    }
    /**
     * Keep moving in one direction
     */

    public void move()
    {
        if(WhetherX == true)
        {
            moveX();
        }else
        {
            moveY();
        }
    }
/**
     * Determine if the player reaches the upper right corner of the map
     */
    public boolean win()
    {
        Rectangle rect = new Rectangle(x , y, width, height);
        Rectangle otherRect = new Rectangle(770, 0, 40, 40); 
        return rect.intersects(otherRect);
    }
 /**
     *Judging whether it is about to intersect or not
     * @param other
     */

    @Override
    public boolean collides(Sprite other) {
        if(tendDir.equals("x"))
        {
            Rectangle rect = new Rectangle(x + (int)velx , y, width, height);
            Rectangle otherRect = new Rectangle(other.x, other.y, other.width, other.height);        
            return rect.intersects(otherRect);
        }else
        {
            Rectangle rect = new Rectangle(x , y+ (int) vely, width, height);
            Rectangle otherRect = new Rectangle(other.x, other.y, other.width, other.height);        
            return rect.intersects(otherRect);
        }
        
    }
}
