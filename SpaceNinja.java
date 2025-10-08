/** This specific ninja class is used only in the last level, and it has
 * no gravity to simulate space. Otherwise, it is largely the same.
 */

import mayflower.*;

public class SpaceNinja extends MovableAnimatedSpaceActor
{
    private Animation idle;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private Animation climbRight;
    private Animation climbLeft;
    
    private int score;
    private int lives;
    
    public SpaceNinja()
    {
        score = 0;
        lives = 3;
        
        String[] files = new String[10];
        for (int i = 0; i < files.length; i++) {
            files[i] = "img/ninjagirl/Idle__00" + (i) + ".png";
        }
        
        idle = new Animation(50, files);
        idle.scale(60, 100);
        
        super.setIdleAnimation(idle);
        
        idleLeft = new Animation(50, files);
        idleLeft.scale(60, 100);
        idleLeft.mirrorHorizontally();
        
        super.setIdleLeftAnimation(idleLeft);
        
        
        String[] files3 = new String[10];
        for (int i = 0; i < files3.length; i++) {
            files3[i] = "img/ninjagirl/Jump__00" + (i) + ".png";
        }
        
        jumpRight = new Animation(50, files3);
        jumpRight.scale(87, 100);
        
        super.setJumpRightAnimation(jumpRight);
        
        jumpLeft = new Animation(50, files3);
        jumpLeft.scale(87, 100);
        jumpLeft.mirrorHorizontally();
        
        super.setJumpLeftAnimation(jumpLeft);
        
        
        String[] files4 = new String[10];
        for (int i = 0; i < files4.length; i++) {
            files4[i] = "img/ninjagirl/Climb_00" + (i) + ".png";
        }
        
        climbRight = new Animation(50, files4);
        climbRight.scale(87, 100);
        
        super.setClimbRightAnimation(climbRight);
        
        climbLeft = new Animation(50, files4);
        climbLeft.scale(87, 100);
        climbLeft.mirrorHorizontally();
        
        super.setClimbLeftAnimation(climbLeft);
    }
    
    public void act()
    {
        super.act();
        World w = getWorld();
        if (isTouching(Coin.class))
        {
            Object a = getOneIntersectingObject(Coin.class);
            Coin c = (Coin) a;
            increaseScore(1);
            w.removeObject(c);
        }
        
        if (getY() > 600) {
            decreaseLives(1);
            if (lives > 0)
            {
                setLocation(400, 200);
            }
            else
            {
                MyMayflower.gameOver();
            }
        }
    }
    
    public int getScore()
    {
        return score;
    }
    
    public int getLives()
    {
        return lives;
    }
    
    public void increaseScore(int amount)
    {
        score += amount;
        updateText();
        
        World w = getWorld();
        if (score >= 5) {
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    w.addObject(new SpecialLadder(), 820, i*100);
                }
                else {
                    w.addObject(new Ladder(), 820, i*100);
                }
            }
        }
    }
    
    public void decreaseLives(int amount)
    {
        lives -= amount;
        updateText();
    }
    
    private void updateText()
    {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.WHITE);
    }
}