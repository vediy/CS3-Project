import mayflower.*;

// Normal ladder that the player climbs to the next level (SpecialLadder)
public class Ladder extends Actor
{
    private Timer animationTimer;
    private boolean needsMove;
    
    public Ladder()
    {
        // Creates a 70*100 ladder
        MayflowerImage p = new MayflowerImage("img/ladder.png");
        p.scale(70,100);
        setImage(p);
        animationTimer = new Timer(50000000);
    }
    
    public void makeMove() {
        needsMove = true;
    }
    
    public boolean isMoving() {
        return needsMove;
    }

    public void act() {
        // Moves the ladder if the pass condition is reached
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