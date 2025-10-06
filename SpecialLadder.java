/**
 * This class is a ladder type that transports the Ninja player to the next level
 * When the Ninja gets the score needed to progress to the next level,
 * the ladder will appear to climb to the next level.
 * The topmost ladder is a "SpecialLadder" type. When it is touched,
 * it changes the level of the game and respawns the player there.
 */

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
            if (MyMayflower.getLevel() == Level.ONE) {
                MyMayflower.levelTwo();
                MyMayflower.nextLevel();
                System.out.println("Level two");
            }
            else if (MyMayflower.getLevel() == Level.TWO) {
                MyMayflower.levelThree();
                MyMayflower.nextLevel();
                System.out.println("Level three");
            }
        }
        
        if(isTouching(SpaceNinja.class)) {
            Object a = getOneIntersectingObject(SpaceNinja.class);
            SpaceNinja n = (SpaceNinja) a;
            System.out.println("You win!");
        }
    }
}