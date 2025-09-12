import mayflower.*;

public class AnimatedActor extends GravityActor
{
    private Animation animation;
    private Timer animationTimer;
    
    public AnimatedActor()
    {
        animationTimer = new Timer(1000);
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