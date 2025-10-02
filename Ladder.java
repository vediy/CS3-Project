import mayflower.*;

public class Ladder extends Actor
{
    
    
    public Ladder()
    {
        MayflowerImage p = new MayflowerImage("img/ladder.png");
        p.scale(70,100);
        setImage(p);
    }

    public void act() {
        if(isTouching(Block.class))
        {
            Object a = getOneIntersectingObject(Block.class);
            Block c = (Block) a;
            World w = getWorld();
            w.removeObject(c);
        }
    }
}