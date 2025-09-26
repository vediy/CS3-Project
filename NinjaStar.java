import mayflower.*;

public class NinjaStar extends Actor
{
    
    
    public NinjaStar()
    {
        MayflowerImage p = new MayflowerImage("img/ninjaStar.png");
        p.scale(50,50);
        setImage(p);
    }

    public void act() {
        setLocation(getX()-1,getY());
        
        if (getX() < 0) {
            setLocation(800, ((int) (Math.random() * 500)));
        }
        
        if(isTouching(Ninja.class))
        {
            Object a = getOneIntersectingObject(Ninja.class);
            Ninja c = (Ninja) a;
            World w = getWorld();
            c.decreaseLives(1);
            if(c.getLives() > 0)
            {
                c.setLocation(400, 200);
            }
            else
            {
                w.removeObject(c);
            }
            setLocation(800, ((int) (Math.random() * 500)));
        }
    }
}
