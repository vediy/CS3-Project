import mayflower.*;

public class SpecialLadder extends Ladder
{
    
    public SpecialLadder()
    {
        super();
    }

    
    public void act()
    {
        super.act();
        if(isTouching(Ninja.class))
        {
            Object a = getOneIntersectingObject(Ninja.class);
            Ninja n = (Ninja) a;
            n.nextLevel();
            World w = getWorld();
            MyWorld world = (MyWorld) w;
            if (n.getLevel() == 1) {
                w.setBackground("img/BG/BG.png");
            }
        }
    }
}
