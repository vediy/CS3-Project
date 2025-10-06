

import mayflower.*;

public class Cat extends AnimatedActor
{
    private Animation walk;
    
    public Cat()
    {
        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "img/cat/Walk (" + (i+1) + ").png";
        }
        
        walk = new Animation(50, fileNames);
        walk.scale(100, 100);
        
        setAnimation(walk);
    }
    
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        if((x+w < 800) && Mayflower.isKeyDown(Keyboard.KEY_RIGHT))
        {
            setLocation(x+2, y);
        }
        if((x > 0) && Mayflower.isKeyDown(Keyboard.KEY_LEFT))
        {
            setLocation(x-2, y);
        }
        if((y > 0) && Mayflower.isKeyDown(Keyboard.KEY_UP))
        {
            setLocation(x, y-2);
        }
        if((y+h < 600) && Mayflower.isKeyDown(Keyboard.KEY_DOWN))
        {
            setLocation(x, y+2);
        }
        super.act();
    }
}
 