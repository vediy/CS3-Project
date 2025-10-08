import mayflower.*;

public class MyMayflower extends Mayflower
{
    private static Level myLevel;
    
    public MyMayflower()
    {
        //Create a window with 800x600 resolution
        super("Project 1", 800, 600);
        myLevel = Level.ONE;
    }
    
    // Goes from title screen to Level 1
    public static void startGame() {
        Mayflower.setFullScreen(false);
        World w =  new LevelOne();
        Mayflower.setWorld(w);
    }
    
    // Shifts to level 2
    public static void levelTwo() {
        Mayflower.setFullScreen(false);
        World w =  new LevelTwo();
        Mayflower.setWorld(w);
    }
    
    // Takes you to level 3
    public static void levelThree() {
        Mayflower.setFullScreen(false);
        World w =  new LevelThree();
        Mayflower.setWorld(w);
    }
    
    // Game over screen
    public static void gameOver() {
        Mayflower.setFullScreen(false);        
        World w = new GameOver();
        Mayflower.setWorld(w);
    }
    
    // Win Screen
    public static void win() {
        Mayflower.setFullScreen(false);
        World w = new YouWin();
        Mayflower.setWorld(w);
    }
    
    // Returns the enum value of the Level the player is on
    public static Level getLevel() {
        return myLevel;
    }
    
    // Whatever the current level is, it adds one to it
    public static void nextLevel() {
        if (myLevel == Level.ONE) {
            myLevel = Level.TWO;
        }
        else if (myLevel == Level.TWO) {
            myLevel = Level.THREE;
        }
        else if (myLevel == Level.THREE) {
            myLevel = Level.WIN;
        }
    }
    
    // Initializes the program with the title screen
    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        World w =  new TitleScreen();
        Mayflower.setWorld(w);
    }
}