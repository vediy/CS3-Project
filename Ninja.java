

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
    
    public Ninja()
    {
        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "img/ninjagirl/Run__00" + (i) + ".png";
        }
        
        walkRight = new Animation(50, fileNames);
        walkRight.scale(75, 100);
        //walkRight.setBounds(14, 5, 51, 92);
        
        super.setWalkRightAnimation(walkRight);
        
        
        walkLeft = new Animation(50, fileNames);
        walkLeft.scale(75, 100);
        walkLeft.mirrorHorizontally();
        //walkLeft.setBounds(21, 5, 51, 92);        
        
        super.setWalkLeftAnimation(walkLeft);
        
        
        String[] files = new String[10];
        for (int i = 0; i < files.length; i++) {
            files[i] = "img/ninjagirl/Idle__00" + (i) + ".png";
        }
        
        idle = new Animation(50, files);
        idle.scale(60, 100);
        //idle.setBounds(14, 5, 25, 50);        
        
        super.setIdleAnimation(idle);
        
        idleLeft = new Animation(50, files);
        idleLeft.scale(60, 100);
        idleLeft.mirrorHorizontally();
        //idleLeft.setBounds(21, 5, 25, 50);        
        
        super.setIdleLeftAnimation(idleLeft);
        
        
        String[] files2 = new String[10];
        for (int i = 0; i < files2.length; i++) {
            files2[i] = "img/ninjagirl/Glide_00" + (i) + ".png";
        }
        
        fallRight = new Animation(50, files2);
        fallRight.scale(87, 100);
        //fallRight.setBounds(14, 5, 25, 50);
        
        super.setFallRightAnimation(fallRight);
        
        fallLeft = new Animation(50, files2);
        fallLeft.scale(87, 100);
        fallLeft.mirrorHorizontally();
        //fallLeft.setBounds(21, 5, 25, 50);
        
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
    }
}
