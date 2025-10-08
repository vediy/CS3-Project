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
    private boolean needsMove;
    
    public SpecialLadder()
    {
        super();
    }
    
    public void act()
    {
        super.act();
        
        // If it touches a player on level one or two, it ups the level and changes the screen
        if(isTouching(Ninja.class) || isTouching(SkyNinja.class))
        {
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
        
        // If it touches a player on the last level, the player wins
        if(isTouching(SpaceNinja.class)) {
            MyMayflower.win();
        }
    }
}
