import mayflower.*;

// Gravity actor for the second level -- floats in the air more than has gravity

public class GravityActor extends Actor
{
    private int startY;
    private int currentY;
    private int speed;
    private boolean isJumping;
    
    public GravityActor()
    {
        startY = getY();
        speed = 1;
        isJumping = false;
    }
    
    // Checks if touching block
    public boolean isBlocked() {
        if (isTouching(Block.class)) {
            return true;
        }
        return false;
    }
    
    // Checks if touching ladder
    public boolean isLaddered() {
        if (isTouching(Ladder.class)) {
            return true;
        }
        return false;
    }
    
    // Checks if currently falling
    public boolean isFalling() {
        boolean ret;
        setLocation(getX(), getY() + 2);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 2);
        return !ret;
    }

    // Checks if currently falling    
    public boolean isJumping() {
        return isJumping;
    }
    
    // Makes the player jump! (Gravity)  
    public void jump() {
        isJumping = true;
        speed = 3;
        //int distance = 0;
        while (speed>=0) {
            setLocation(getX(), getY()-speed);
            speed-=1;
        }
        //setLocation(getX(), getY()-100);
    }
    
    // Constantly making the player fall -- unless it's touching a block or ladder
    public void act() {
        setLocation(getX(), getY()+2);
        if (isBlocked()) {
            setLocation(getX(), getY()-2);
        }
        if (isLaddered()) {
            setLocation(getX(), getY()-4);
        }
    }
}