import mayflower.*;

public class Block extends Actor
{
    
    
    public Block()
    {
        MayflowerImage p = new MayflowerImage("img/Tiles/2.png");
        p.scale(100,100);
        setImage(p);
    }
    
    public void act() {
        if (isTouching(NinjaStar.class)) {
            Object a = getOneIntersectingObject(NinjaStar.class);
            NinjaStar n = (NinjaStar) a;
            n.setLocation(800, n.getY());
            /**World w = getWorld();
            w.removeObject(n);*/
        }
    }
}
