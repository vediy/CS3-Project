import mayflower.*;


public class LevelOne extends World {
        private Ninja ninja;
        private String[][] tiles;
        
        public LevelOne() 
        {
            MayflowerImage m = new MayflowerImage("img/BG/BG.png");
            addObject(new ScrollBG(m),0,0);
            addObject(new ScrollBG(m),800,0);
            
            tiles = new String[6][8];

            createTiles();
            addMainCharacter();
            addRandomObjects();
            buildWorld();
            
            //Mayflower.showBounds(true);
            
            showText("Score: " + ninja.getScore() + " Lives : " + ninja.getLives(), 10, 30, Color.BLACK);
        }
        
        public void createTiles() {
            for (int r = 0; r < tiles.length; r++) {
                for (int c = 0; c < tiles[r].length; c++) {
                    tiles[r][c] = "";
                }
            }
            
            for (int i = 0; i < tiles[0].length; i++) {
                tiles[5][i] = "ground";
            }
        }
        
        public void buildWorld() {
            for (int row = 0; row < tiles.length; row++) {
                for (int col = 0; col < tiles[row].length; col++) {
                    if (tiles[row][col].equals("ninja")) {
                        addObject(ninja, col*100, row*100);
                    }
                    if (tiles[row][col].equals("coin")) {
                        addObject(new Coin(), col*100, row*100);
                    }
                    if (tiles[row][col].equals("ground")) {
                        addObject(new Block(), col*100, row*100);
                    }
                    if (tiles[row][col].equals("star")) {
                        addObject(new NinjaStar(), col*100, row*100);
                    }
                }
            }
        }
        
        public void addRandomObjects() {
            for (int i = 0; i < 4; i++) {
                int r = (int) (Math.random() * tiles.length);
                int c = (int) (Math.random() * tiles[r].length);
                if (tiles [r][c] == "") {
                    tiles[r][c] = "star";
                }
                else {
                    i--;
                }
            }
            
            for (int i = 0; i < 5; i++) {
                int r = (int) (Math.random() * tiles.length);
                int c = (int) (Math.random() * tiles[r].length);
                if (tiles [r][c] == "") {
                    tiles[r][c] = "coin";
                }
                else {
                    i--;
                }
            }
        }

        public void addMainCharacter() {
            ninja = new Ninja();
            tiles[2][4] = "ninja";            
        }
        
        public void clearWorld() {
            for (int i = 0; i < tiles.length; i++) {
                for (int j = 0; j < tiles[i].length; j++) {
                    tiles[i][j] = "";
                }
            }
            
            buildWorld();
        }
        
        public void act() {
            
        }
}