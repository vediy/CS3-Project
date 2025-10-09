import mayflower.*;

// Gravity actor for the first level - implements actual acceleration

public class GravityActor2 extends Actor {
    private double velocityY;
    private double gravity;
    private double normalGravity;
    private double glideGravity;
    private boolean isJumping;
    private boolean isGliding;

    public GravityActor2() {
        velocityY = 0;
        normalGravity = 0.5;  // normal gravity strength
        glideGravity = 0.1;   // reduced gravity while gliding
        gravity = normalGravity;
        isJumping = false;
        isGliding = false;
    }

    public boolean isBlocked() {
        return isTouching(Block.class);
    }

    public boolean isLaddered() {
        return isTouching(Ladder.class);
    }

    public boolean isFalling() {
        setLocation(getX(), getY() + 1);
        boolean ret = !isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return ret;
    }
    

    public boolean isJumping() {
        return isJumping;
    }

    public boolean isGliding() {
        return isGliding;
    }

    public void jump() {
        if (!isJumping && !isFalling()) {
            velocityY = -10;
            isJumping = true;
        }
    }

    // Enable gliding (reduces gravity)
    public void glide() {
        if (isFalling()) {
            isGliding = true;
            gravity = glideGravity;
        }
    }

    // Stop gliding (restore normal gravity)
    public void stopGlide() {
        isGliding = false;
        gravity = normalGravity;
    }

    public void act() {
        // Apply gravity acceleration
        velocityY += gravity;

        //Cap fall speed so you don’t go infinitely fast
        if (velocityY > 10)
            velocityY = 10;

        // Move actor
        setLocation(getX(), getY() + (int) velocityY);

        // Handle collision with the ground
        if (isBlocked()) {
            while (isTouching(Block.class)) {
                setLocation(getX(), getY() - 1);
            }
            velocityY = 0;
            isJumping = false;
            stopGlide(); // reset gliding on landing
        }

        // Ladder behavior (optional)
        if (isLaddered()) {
            velocityY = 0;
            setLocation(getX(), getY() - 2);
        }


    }
}