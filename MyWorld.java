import mayflower.*;


public class MyWorld extends World {
        private Ninja ninja;
        private String[][] tiles;
        
        public MyWorld() 
        {
            setBackground("img/BG/BG.png");
            
            tiles = new String[6][8];
            //cat = new Cat();
            //addObject(cat, 400, 100);

            
            createTiles();
            addMainCharacter();
            buildWorld();
            
            Mayflower.showBounds(true);
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
                    if (tiles[row][col].equals("ground")) {
                        addObject(new Block(), col*100, row*100);
                    }
                    /**if (tiles[row][col].equals("yarn")) {
                        addObject(new Yarn(), col*100, row*100);
                    }*/
                    if (tiles[row][col].equals("ninja")) {
                        addObject(ninja, col*100, row*100);
                    }
                    /**if (tiles[row][col].equals("dog")) {
                        addObject(dog, col*100, row*100);
                    }*/
                }
            }
        }
        
        /**public void addRandomObjects() {
            for (int r = 0; r < tiles.length; r++) {
                for (int c = 0; c < tiles[r].length; c++) {
                    int rand = (int) (Math.random() * tiles[r].length);
                    if (rand < 3 && tiles[r][c] == "") {
                        tiles[r][c] = "yarn";
                    }
                }
            }
        }*/
        
        public void addMainCharacter() {
            ninja = new Ninja();
            tiles[1][2] = "ninja";
            /**boolean added = false;
            
            while (!added) {
                int row = (int) (Math.random() * tiles.length);
                int col = (int) (Math.random() * tiles[0].length);
                if (tiles[row][col] == "") {
                    tiles[row][col] = "cat";
                    added = true;
                }
            }*/
        }
        
        /**public void addSideCharacter() {
            jack = new Jack();
            boolean added = false;
            
            while (!added) {
                int row = (int) (Math.random()*tiles.length);
                int col = (int) (Math.random()*tiles[0].length);
                if (tiles[row][col] == "") {
                    tiles[row][col] = "jack";
                    added = true;
                }
            }
        }*/
        
        public void act() {
            
        }
}