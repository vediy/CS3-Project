import mayflower.*;

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
    
    public boolean isBlocked() {
        if (isTouching(Block.class)) {
            return true;
        }
        return false;
    }
    
    public boolean isFalling() {
        boolean ret;
        setLocation(getX(), getY() + 2);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 2);
        return !ret;
    }
    
    public boolean isJumping() {
        return isJumping;
    }
    
    public void jump() {
        isJumping = true;
        //setLocation(getX(), getY()+20);
        speed = 3;
        while (speed>=0) {
            setLocation(getX(), getY()-speed);
            speed-=1;
        }
    }
    
    public void act() {
        setLocation(getX(), getY()+2);
        if (isBlocked()) {
            setLocation(getX(), getY()-2);
            isJumping = false;
        }
    }
}