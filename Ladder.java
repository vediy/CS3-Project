import mayflower.*;

public class Ladder extends Actor
{
    private Timer animationTimer;
    private boolean needsMove;
    
    public Ladder()
    {
        MayflowerImage p = new MayflowerImage("img/ladder.png");
        p.scale(70,100);
        setImage(p);
        animationTimer = new Timer(50000000);
    }
    
    public void makeMove() {
        needsMove = true;
    }

    public void act() {
        if (needsMove) {
            if (animationTimer.isDone()) {
                animationTimer.reset();
                setLocation(getX()-1,getY());
                if (getX()+800 < 0) {
                    setLocation(800, 0);
                }
            }
        }
    }
}