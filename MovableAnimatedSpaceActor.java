import mayflower.*;

public class MovableAnimatedSpaceActor extends AnimatedSpaceActor
{   
    // Sets all of the animations and animation conditions for the player

    private Animation idle;
    private Animation idleLeft;
    private Animation jumpRight;
    private Animation jumpLeft;
    private Animation climbRight;
    private Animation climbLeft;
    private String currentAction;
    private String direction;
    
    public MovableAnimatedSpaceActor()
    {
        idle = null;
        currentAction = null;
        direction = "right";
    }
    
    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }
    
    public void setJumpRightAnimation(Animation ani) {
        jumpRight = ani;
    }
    
    public void setJumpLeftAnimation(Animation ani) {
        jumpLeft = ani;
    }
    
    public void setClimbRightAnimation(Animation ani) {
        climbRight = ani;
    }
    
    public void setClimbLeftAnimation(Animation ani) {
        climbLeft = ani;
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
            newAction = "jumpRight";
            direction = "right";
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && (x > 0)) {
            setLocation(x-1, y);
            newAction = "jumpLeft";
            direction = "left";
        }
        else {
            newAction = "idle";
            if (direction != null && direction.equals("left")) {
                newAction = "idleLeft";
            }
        }
        if (Mayflower.isKeyDown(Keyboard.KEY_UP) && (y>0)) {
            setLocation(x, y-1);
            if (direction.equals("right")) {
                newAction = "jumpRight";
            }
            if (direction.equals("left")) {
                newAction = "jumpLeft";
            }
        }
        if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) && (y>0)) {
            setLocation(x, y+1);
            if (direction.equals("right")) {
                newAction = "jumpRight";
            }
            if (direction.equals("left")) {
                newAction = "jumpLeft";
            }
        }
        if (isTouching(Ladder.class)) {
            if (direction.equals("right")) {
                newAction = "climbRight";
            }
            if (direction.equals("left")) {
                newAction = "climbLeft";
            }
            setLocation(getX(), getY()-3);
        }
        
        if ((newAction != null) && !(newAction.equals(currentAction))) {
            if (newAction.equals("idle")) {
                setAnimation(idle);
            }
            if (newAction.equals("idleLeft")) {
                setAnimation(idleLeft);
            }
            if (newAction.equals("jumpRight")) {
                setAnimation(jumpRight);
            }
            if (newAction.equals("jumpLeft")) {
                setAnimation(jumpLeft);
            }
            if (newAction.equals("climbRight")) {
                setAnimation(climbRight);
            }
            if (newAction.equals("climbLeft")) {
                setAnimation(climbLeft);
            }
            currentAction = newAction;
        }
    }
}