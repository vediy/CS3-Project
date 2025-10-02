import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;    
    private Animation idle;
    private Animation idleLeft;
    private Animation fallRight;
    private Animation fallLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private String currentAction;
    private String direction;
    
    public MovableAnimatedActor()
    {
        walkRight = null;
        idle = null;
        currentAction = null;
        direction = "right";
    }
    
    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }
    
    public void setWalkRightAnimation(Animation ani) {
        walkRight = ani;
    }
    
    public void setWalkLeftAnimation(Animation ani) {
        walkLeft = ani;
    }
    
    public void setFallRightAnimation(Animation ani) {
        fallRight = ani;
    }
    
    public void setFallLeftAnimation(Animation ani) {
        fallLeft = ani;
    }
    
    public void setJumpRightAnimation(Animation ani) {
        jumpRight = ani;
    }
    
    public void setJumpLeftAnimation(Animation ani) {
        jumpLeft = ani;
    }
    
    public void setIdleAnimation(Animation ani) {
        idle = ani;
    }
    
    public void setIdleLeftAnimation(Animation ani) {
        idleLeft = ani;
    }
    
    public void act() {
        super.act();
        
        String newAction = null;
        if (currentAction == null) {
            newAction = "idle";
        }
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && (x+w < 800)) {
            setLocation(x+1, y);
            newAction = "walkRight";
            direction = "right";
            if (isBlocked()) {
                setLocation(x-1, y);
            }
            if (isFalling()) {
                newAction = "fallRight";
            }
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && (x > 0)) {
            setLocation(x-1, y);
            newAction = "walkLeft";
            direction = "left";
            if (isBlocked()) {
                setLocation(x+1, y);
            }
            if (isFalling()) {
                newAction = "fallLeft";
            }
        }
        else {
            newAction = "idle";
            if (direction != null && direction.equals("left")) {
                newAction = "idleLeft";
            }
            if (isFalling()) {
                if (direction.equals("right")) {
                    newAction = "fallRight";
                }
                if (direction.equals("left")) {
                    newAction = "fallLeft";
                }
            }
        }
        if (Mayflower.isKeyDown(Keyboard.KEY_UP) && (y>0)) {
            if (direction.equals("right")) {
                newAction = "jumpRight";
            }
            if (direction.equals("left")) {
                newAction = "jumpLeft";
            }
            jump();
        }
        
        if ((newAction != null) && !(newAction.equals(currentAction))) {
            if (newAction.equals("idle")) {
                setAnimation(idle);
            }
            if (newAction.equals("idleLeft")) {
                setAnimation(idleLeft);
            }
            if (newAction.equals("walkRight")) {
                setAnimation(walkRight);
            }
            if (newAction.equals("walkLeft")) {
                setAnimation(walkLeft);
            }
            if (newAction.equals("fallRight")) {
                setAnimation(fallRight);
            }
            if (newAction.equals("fallLeft")) {
                setAnimation(fallLeft);
            }
            if (newAction.equals("jumpRight")) {
                setAnimation(jumpRight);
            }
            if (newAction.equals("jumpLeft")) {
                setAnimation(jumpLeft);
            }
            currentAction = newAction;
        }
    }
}