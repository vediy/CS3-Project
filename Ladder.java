import mayflower.*;

public class Ladder extends Actor
{
    private Timer animationTimer;
    
    public Ladder()
    {
        MayflowerImage p = new MayflowerImage("img/ladder.png");
        p.scale(70,100);
        setImage(p);
        animationTimer = new Timer(50000000);
    }

    public void act() {
        if(isTouching(Block.class))
        {
            Object a = getOneIntersectingObject(Block.class);
            Block c = (Block) a;
            World w = getWorld();
            w.removeObject(c);
        }
        
        if (animationTimer.isDone()) {
            animationTimer.reset();
            setLocation(getX()-1,getY());
            if (getX()+800 < 0) {
                setLocation(800, 0);
            }
        }
    }
}