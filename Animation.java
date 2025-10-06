

import mayflower.*;

public class Animation
{
    private int frameRate;
    private int currentFrame;
    private MayflowerImage[] frames;
    
    public Animation(int theFrameRate, String[] theFrames)
    {
        frameRate = theFrameRate;
        frames = new MayflowerImage[theFrames.length];
        for (int i = 0; i < theFrames.length; i++) {
            frames[i] = new MayflowerImage(theFrames[i]);
        }
        currentFrame = 0;
    }
    
    public int getFrameRate() {
        return frameRate;
    }
    
    public MayflowerImage getNextFrame() {
        MayflowerImage p = frames[currentFrame];
        currentFrame++;
        currentFrame %= frames.length;
        return p;
    }
    
    public void scale(int w, int h) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].scale(w, h);
        }
    }
    
    public void setTransparency(int percent) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setTransparency(percent);
        }
    }
    
    public void mirrorHorizontally() {
        for (int i = 0; i < frames.length; i++) {
            frames[i].mirrorHorizontally();
        }
    }
    
    public void setBounds(int x, int y, int w, int h) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].crop(x, y, w, h);
        }
    }
}