import mayflower.*;

public class ScrollBG extends Actor
{
    private Timer animationTimer;
    
    public ScrollBG(MayflowerImage m)
    {
        MayflowerImage p = m;
        p.scale(800,600);
        setImage(p);
        animationTimer = new Timer(50000000);
    }

    public void act() {
        // The background is moving right to left constantly, and it loops around when it reaches the end of the screen
        
        if (animationTimer.isDone()) {
            animationTimer.reset();
            setLocation(getX()-1,getY());
            if (getX()+800 < 0) {
                setLocation(800, 0);
            }
        }

    }
}