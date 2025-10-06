import mayflower.*;


public class TitleScreen extends World {
        
        public TitleScreen() 
        {
            setBackground("img/BG/TitleScreen.png");

        }
        
        
        public void act() {
            if (Mayflower.isKeyPressed(Keyboard.KEY_SPACE)) {
                MyMayflower.startGame();
            }
        }
}