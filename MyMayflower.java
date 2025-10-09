import mayflower.*;

public class MyMayflower extends Mayflower
{
    private static Level myLevel;
    private static boolean passed;
    
    public MyMayflower()
    {
        //Create a window with 800x600 resolution
        super("Project 1", 800, 600);
        myLevel = Level.ONE;
        passed = false;
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
        Mayflower.stopMusic("sound/mountain-trials.mp3");
        Mayflower.playMusic("sound/dizzy-spells.mp3");
    }
    
    // Takes you to level 3
    public static void levelThree() {
        Mayflower.setFullScreen(false);
        World w =  new LevelThree();
        Mayflower.setWorld(w);
        Mayflower.stopMusic("sound/dizzy-spells.mp3");
        Mayflower.playMusic("sound/digestive-biscuit.mp3");
    }
    
    // Game over screen
    public static void gameOver() {
        Mayflower.setFullScreen(false);        
        World w = new GameOver();
        Mayflower.setWorld(w);
        if (myLevel == Level.ONE) {
            Mayflower.stopMusic("sound/mountain-trials.mp3");
        }
        else if (myLevel == Level.TWO) {
            Mayflower.stopMusic("sound/dizzy-spells.mp3");
        }
        else if (myLevel == Level.THREE) {
            Mayflower.stopMusic("sound/digestive-biscuit.mp3");
        }
        Mayflower.playMusic("sound/game-over.mp3");
    }
    
    // Win Screen
    public static void win() {
        Mayflower.setFullScreen(false);
        World w = new YouWin();
        Mayflower.setWorld(w);
        Mayflower.stopMusic("sound/digestive-biscuit.mp3");
        Mayflower.playMusic("sound/dreamscape.mp3");
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
    
    public static void changePass() {
        passed = !passed;
    }
    
    public static boolean isPassed() {
        return passed;
    }
    
    // Initializes the program with the title screen
    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        World w =  new TitleScreen();
        Mayflower.setWorld(w);
        Mayflower.playMusic("sound/mountain-trials.mp3");
    }
}