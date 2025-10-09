import mayflower.*;

public class Coin extends Actor
{
    
    public Coin()
    {
        //Creates a coin that is 50*50
        MayflowerImage p = new MayflowerImage("img/goldCoin.png");
        p.scale(50,50);
        setImage(p);
    }

    
    public void act()
    {
        
    }
}