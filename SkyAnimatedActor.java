import mayflower.*;

public class SkyAnimatedActor extends GravityActor
{
    private Animation animation;
    private Timer animationTimer;
    
    public SkyAnimatedActor()
    {
        animationTimer = new Timer(50000000);
    }
    
    public void setAnimation (Animation a) {
        animation = a;
    }

    public void act() {
        if (!(animation == null)) {
            if (animationTimer.isDone()) {
                animationTimer.reset();
                
                MayflowerImage p = animation.getNextFrame();
                setImage(p);
            }
        }
        
        super.act();
    }
}