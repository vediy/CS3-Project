

import mayflower.*;

public class Ninja extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    
    private int score;
    private int lives;
    private int level;
    
    public Ninja()
    {
        score = 0;
        lives = 3;
        level = 1;
        
        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "img/ninjagirl/Run__00" + (i) + ".png";
        }
        
        walkRight = new Animation(50, fileNames);
        walkRight.scale(75, 100);
        
        super.setWalkRightAnimation(walkRight);
        
        
        walkLeft = new Animation(50, fileNames);
        walkLeft.scale(75, 100);
        walkLeft.mirrorHorizontally();
        
        super.setWalkLeftAnimation(walkLeft);
        
        
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
        
        
        String[] files2 = new String[10];
        for (int i = 0; i < files2.length; i++) {
            files2[i] = "img/ninjagirl/Glide_00" + (i) + ".png";
        }
        
        fallRight = new Animation(50, files2);
        fallRight.scale(87, 100);
        
        super.setFallRightAnimation(fallRight);
        
        fallLeft = new Animation(50, files2);
        fallLeft.scale(87, 100);
        fallLeft.mirrorHorizontally();
        
        super.setFallLeftAnimation(fallLeft);
        
        
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
    }
    
    public void act()
    {
        super.act();
        World w = getWorld();
        if(isTouching(Coin.class))
        {
            Object a = getOneIntersectingObject(Coin.class);
            Coin c = (Coin) a;
            increaseScore(1);
            w.removeObject(c);
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
    
    public int getLevel() {
        return level;
    }
    
    public void increaseScore(int amount)
    {
        score += amount;
        updateText();
        
        World w = getWorld();
        if (score >= 5) {
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    w.addObject(new SpecialLadder(), 7, i*100);
                }
                else {
                    w.addObject(new Ladder(), 7, i*100);
                }
            }
        }
    }
    
    public void decreaseLives(int amount)
    {
        lives -= amount;
        updateText();
    }
    
    public void nextLevel() {
        level++;
    }
    
    private void updateText()
    {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
}
