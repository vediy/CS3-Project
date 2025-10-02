import mayflower.*;

public class ScrollBG extends Actor
{
    private Timer animationTimer;
    
    public ScrollBG()
    {
        MayflowerImage p = new MayflowerImage("img/BG/BG.png");
        p.scale(800,600);
        setImage(p);
        animationTimer = new Timer(50000000);
    }

    public void act() {
        if (animationTimer.isDone()) {
            animationTimer.reset();
            setLocation(getX()-1,getY());
            if (getX()+800 < 0) {
                setLocation(800, 0);
            }
        }

    }
}
