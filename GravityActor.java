import mayflower.*;

public class GravityActor extends Actor
{
    
    
    public GravityActor()
    {
        
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
    
    public void act() {
        setLocation(getX(), getY()+2);
        if (isBlocked()) {
            setLocation(getX(), getY()-2);
        }
    }
}