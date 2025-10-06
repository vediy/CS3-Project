import mayflower.*;

public class Dog extends AnimatedActor
{
    private Animation walk;
    
    public Dog()
    {
        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "img/ninjaStar.png";
        }
        
        walk = new Animation(50, fileNames);
        walk.scale(100, 100);
        walk.setTransparency(25);
        
        setAnimation(walk);
    }
    
    public void act()
    {
        super.act();
        if(isTouching(Ninja.class))
        {
            Object a = getOneIntersectingObject(Ninja.class);
            Ninja c = (Ninja) a;
            World w = getWorld();
            c.decreaseLives(1);
            if(c.getLives() > 0)
            {
                c.setLocation(400, 300);
            }
            else
            {
                w.removeObject(c);
            }
        }
    
    }
}