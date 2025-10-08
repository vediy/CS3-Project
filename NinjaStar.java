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
        // NinjaStars are constantly moving from right to left on the screen
        setLocation(getX()-1,getY());
        
        // Resets Ninja to rightmost side of the screen at a random y-value if it goes off screen
        if (getX() < (0-getWidth())) {
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
                MyMayflower.gameOver(); 
            }
            // Resets Ninja to rightmost side of the screen at a random y-value if it kills a player 
            setLocation(800, ((int) (Math.random() * 500)));
        }
        
        if(isTouching(SpaceNinja.class))
        {
            Object a = getOneIntersectingObject(SpaceNinja.class);
            SpaceNinja c = (SpaceNinja) a;
            World w = getWorld();
            c.decreaseLives(1);
            if(c.getLives() > 0)
            {
                c.setLocation(400, 200);
            }
            else
            {
                MyMayflower.gameOver();
            }
            // Resets Ninja to rightmost side of the screen at a random y-value if it kills a player       
            setLocation(800, ((int) (Math.random() * 500)));
        }
        
        if(isTouching(SkyNinja.class))
        {
            Object a = getOneIntersectingObject(SkyNinja.class);
            SkyNinja c = (SkyNinja) a;
            World w = getWorld();
            c.decreaseLives(1);
            if(c.getLives() > 0)
            {
                c.setLocation(400, 200);
            }
            else
            {
                MyMayflower.gameOver();
            }
            // Resets Ninja to rightmost side of the screen at a random y-value if it kills a player 
            setLocation(800, ((int) (Math.random() * 500)));
        }
        
        if(isTouching(NinjaStar.class))
        {
            Object a = getOneIntersectingObject(NinjaStar.class);
            NinjaStar c = (NinjaStar) a;
            
            // Resets Ninja to rightmost side of the screen at a random y-value if it touches another NinjaStar 
            setLocation(800, ((int) (Math.random() * 500)));
        }
    }
}