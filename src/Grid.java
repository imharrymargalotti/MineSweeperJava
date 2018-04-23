import java.awt.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by harrymargalotti on 4/24/17.
 */
public class Grid {
    private int numBombs;
    private int numFlags;
    private Square[][] squares;

    public Grid(String difficulty) {//constructor
        Random rand = new Random();
        Scanner s=new Scanner(System.in);

        //THIS IS THE STUFF FOR BEGINNER
        int bombPlace;

        if (difficulty.equals("beginner")) {
            StdDraw.setCanvasSize(500, 500);
            int height = 9;
            int width = 9;
            squares = new Square[width][height];
            numBombs = 10;
            StdDraw.setXscale(-.1, width);
            StdDraw.setYscale(-.1, height);
            for (int i = 0; i < width; i++) {//populate 2d array
                for (int j = 0; j < height; j++) {
                    Square temp = new Square(i, j);
                    squares[i][j] = temp;
                    temp.drawSqure(Color.cyan);
                }
            }
            //DRAW BOMBS
            for (int i = 0; i < numBombs; i++) {
                    bombPlace = rand.nextInt(width);
                    int bombPlace2 = rand.nextInt(height);
                    squares[bombPlace][bombPlace2].setHasBomb(true);
                    Square temp = new Square(bombPlace, bombPlace2);
                    temp.drawSqure(Color. cyan);
                    temp.setHasBomb(true);
                    //this.numBombs++;
            }
        }//END CONSTRUCTOR FOR BEGINNER

        else if (difficulty.equals("intermediate")) {
            StdDraw.setCanvasSize(800,600);
            System.out.println("INTERMEDIATE");
            int height = 16;
            int width = 16;
            squares = new Square[width][height];
            numBombs = 40;
            StdDraw.setXscale(-.1, width);
            StdDraw.setYscale(-.1, height);
            for (int i = 0; i < width; i++) {//populate 2d array
                for (int j = 0; j < height; j++) {
                    Square temp = new Square(i, j);
                    squares[i][j] = temp;
                    temp.drawSqure(Color.cyan);
                }
            }
            //DRAW BOMBS
            for (int i = 0; i < numBombs; i++) {
                bombPlace = rand.nextInt(width);
                int bombPlace2 = rand.nextInt(height);
                squares[bombPlace][bombPlace2].setHasBomb(true);
                Square temp = new Square(bombPlace, bombPlace2);
                temp.drawSqure(Color.cyan);


            }
        }//END CONSTRUCTOR FOR intermediate
        else if (difficulty.equals("expert")){
            System.out.println("EXPERT");
            int height = 16;
            int width = 30;
            StdDraw.setCanvasSize(width*30,height*30);
            squares = new Square[width][height];
            numBombs = 99;
            StdDraw.setXscale(-.1, width);
            StdDraw.setYscale(-.1, height);
            for (int i = 0; i < width; i++) {//populate 2d array
                for (int j = 0; j < height; j++) {
                    Square temp = new Square(i, j);
                    squares[i][j] = temp;
                    temp.drawSqure(Color.cyan);
                }
            }
            //DRAW BOMBS
            for (int i = 0; i < numBombs; i++) {
                bombPlace = rand.nextInt(width);
                int bombPlace2 = rand.nextInt(height);
                squares[bombPlace][bombPlace2].setHasBomb(true);
                Square temp = new Square(bombPlace, bombPlace2);
                temp.drawSqure(Color.cyan);

            }
        }//END CONSTRUCTOR FOR expert

        else if (difficulty.equals("custom")) {
            System.out.println("SUPER BADASS MODE! or..debugging mode :/");
            System.out.print("Enter a height: ");
            int height = s.nextInt();
            System.out.print("Enter a width");
            int width = s.nextInt();
            squares = new Square[width][height];
            System.out.print("How many bombs??????");
            numBombs = s.nextInt();
            if (numBombs < width * height) {
                StdDraw.setCanvasSize(width * 30, height * 30);
                StdDraw.setXscale(-.1, width);
                StdDraw.setYscale(-.1, height);
                for (int i = 0; i < width; i++) {//populate 2d array
                    for (int j = 0; j < height; j++) {
                        Square temp = new Square(i, j);
                        squares[i][j] = temp;
                        temp.drawSqure(Color.cyan);
                    }
                }
                //DRAW BOMBS
                for (int i = 0; i < numBombs; i++) {
                    bombPlace = rand.nextInt(width);
                    int bombPlace2 = rand.nextInt(height);
                    squares[bombPlace][bombPlace2].setHasBomb(true);
                    Square temp = new Square(bombPlace, bombPlace2);
                    temp.drawSqure(Color.cyan);

                }
            }
        }else{
            System.out.println("You entered bad input");
            System.out.println("Quitting minesweeper");
            System.exit(1);
        }

        //END CONSTRUCTOR FOR CUSTOM

    }

    /**
     * The bombsTouching method exists to get the number of bobms touching a given square and return that as a string
     * so it can be written on the square.
     * @param square
     * @return string of the number of bombs touching a given square
     */
    public String bombsTouching(Square square){
            int numBombsTouching = 0;
            String numBombs = "";

            try {//square to the right of clicked square
                int rightX = (int) square.getXcoord() + 1;
                int rightY = (int) square.getYcoord();
                Square rightOf = squares[rightX][rightY];
                if (rightOf.isHasBomb() == true)
                    numBombsTouching++;
            }catch (Exception e){}

            try{//square to the right and up 1 of the clicked square
                int rightUpX = (int) square.getXcoord() + 1;
                int rightUpY = (int) square.getYcoord() + 1;
                Square rightUp = squares[rightUpX][rightUpY];
                if (rightUp.isHasBomb() == true)
                    numBombsTouching++;
            }catch (Exception e){}

            try{//square to the right and down 1 of the cliked square
                int rightDX = (int) square.getXcoord() + 1;
                int rightDY = (int) square.getYcoord() - 1;
                Square rightD = squares[rightDX][rightDY];
                if (rightD.isHasBomb() == true)
                    numBombsTouching++;
            }catch (Exception e){}

            try{//square to the left of the clicked square
                int leftX = (int) square.getXcoord() - 1;
                int leftY = (int) square.getYcoord();
                Square leftOf = squares[leftX][leftY];
                if (leftOf.isHasBomb() == true)
                    numBombsTouching++;
            }catch (Exception e){}

            try{//square to the left and up 1 of the clicked square
                int leftUpX = (int) square.getXcoord() - 1;
                int leftUpY = (int) square.getYcoord() + 1;
                Square leftUp = squares[leftUpX][leftUpY];
                if (leftUp.isHasBomb() == true)
                    numBombsTouching++;
            }catch (Exception e){}

            try {//square to the left and down 1 of the clicked square
                int leftDX = (int) square.getXcoord() - 1;
                int leftDY = (int) square.getYcoord() - 1;
                Square leftD = squares[leftDX][leftDY];
                if (leftD.isHasBomb() == true)
                    numBombsTouching++;
            }catch (Exception e){}

            try{//square directly above the licked square
                int AboveX = (int) square.getXcoord();
                int AboveY = (int) square.getYcoord() + 1;
                Square Above = squares[AboveX][AboveY];
                if (Above.isHasBomb() == true)
                    numBombsTouching++;
            }catch (Exception e){}

            try{//square directly below the clicked square
                int belowX = (int) square.getXcoord();
                int belowY = (int) square.getYcoord() - 1;
                Square below = squares[belowX][belowY];
                if (below.isHasBomb() == true)
                    numBombsTouching++;
            }catch (Exception e){}

        numBombs += numBombsTouching;
        return numBombs;
    }

    /**
     * the revealSquares method exists to reveal all 8 of the surrounding squares from a clicked square
     * IF that square is touching 0 bombs.
     * if the revealed square is not a bomb, recursion will occur (if necessary) by calling the revealSquares method again on that
     * neighboring square.
     * @param square
     * @returns none
     */
    public void revealSquares(Square square){
        String bombs= bombsTouching(square);

        if(bombs.equals("0")) {

            try {//square to the right
                int rightX = (int) square.getXcoord() + 1;
                int rightY = (int) square.getYcoord();
                Square rightOf = squares[rightX][rightY];

                if (rightOf.isRevealed() == false && rightOf.isHasBomb() == false) {
                    rightOf.drawSqure(Color.gray);
                    rightOf.setRevealed(true);
                    revealSquares(rightOf);
                }
            } catch (Exception e) {}

            try {//square to the right 1 up 1
                int rightUpX = (int) square.getXcoord() + 1;
                int rightUpY = (int) square.getYcoord() + 1;
                Square rightUp = squares[rightUpX][rightUpY];

               if (!rightUp.isRevealed() && !rightUp.isHasBomb()) {
                   rightUp.drawSqure(Color.gray);
                   rightUp.setRevealed(true);
                   revealSquares(rightUp);
               }
            } catch (Exception e) {}

            try {//square to the right 1 down 1
                int rightDX = (int) square.getXcoord() + 1;
                int rightDY = (int) square.getYcoord() - 1;
                Square rightD = squares[rightDX][rightDY];

                if (!rightD.isRevealed() && !rightD.isHasBomb() ) {
                    rightD.drawSqure(Color.gray);
                    rightD.setRevealed(true);
                    revealSquares(rightD);
                }
            } catch (Exception e) {}

            try {//square to the left 1
                int leftX = (int) square.getXcoord() - 1;
                int leftY = (int) square.getYcoord();
                Square leftOf = squares[leftX][leftY];

                if (!leftOf.isRevealed() && !leftOf.isHasBomb()) {
                    leftOf.drawSqure(Color.gray);
                    leftOf.setRevealed(true);
                    revealSquares(leftOf);
                }
            } catch (Exception e) {}

            try {//left 1 up 1
                int leftUpX = (int) square.getXcoord() - 1;
                int leftUpY = (int) square.getYcoord() + 1;
                Square leftUp = squares[leftUpX][leftUpY];

                if (leftUp.isRevealed() == false && !leftUp.isHasBomb()) {
                    leftUp.drawSqure(Color.gray);
                    leftUp.setRevealed(true);
                    revealSquares(leftUp);
                }
            } catch (Exception e) {}

            try {//left 1 down 1
                int leftDX = (int) square.getXcoord() - 1;
                int leftDY = (int) square.getYcoord() - 1;
                Square leftD = squares[leftDX][leftDY];

                if (leftD.isRevealed() == false && !leftD.isHasBomb()) {
                        leftD.drawSqure(Color.gray);
                        leftD.setRevealed(true);
                        revealSquares(leftD);
                    }
            } catch (Exception e) {}

            try {//directly above
                int AboveX = (int) square.getXcoord();
                int AboveY = (int) square.getYcoord() + 1;
                Square Above = squares[AboveX][AboveY];
                if (Above.isRevealed() == false && !Above.isHasBomb()) {
                    Above.drawSqure(Color.gray);
                    Above.setRevealed(true);
                    revealSquares(Above);
                }
            } catch (Exception e) {}

            try {//directly below
                int belowX = (int) square.getXcoord();
                int belowY = (int) square.getYcoord() - 1;
                Square below = squares[belowX][belowY];
                if (below.isRevealed() == false&&!below.isHasBomb()) {
                    below.drawSqure(Color.gray);
                    below.setRevealed(true);
                    revealSquares(below);
                }
            } catch (Exception e) {}

            }else{
            StdDraw.setPenColor(Color.black);
            StdDraw.text(square.getXcoord()+0.45,square.getYcoord()+0.45,bombs);
        }
        }

    /**
     * the method checkFlags exists to check if the user wins the game by flagging all of the bombs
     * @return boolean win which is either true or false (if they won or not)
     */
    public boolean checkFlags(){
        boolean Win=true;
        for (int i = 0; i <squares.length ; i++) {
            for (int j = 0; j <squares[i].length; j++) {
                if (squares[i][j].isFlagged()==false && squares[i][j].isHasBomb()==true){
                    Win=false;
                }
            }
        }
        return Win;
    }

    /**
     * the method checkWin exists to check if the user has won the game by revealing every square that is not a bomb
     * @return boolean win which is either true or false (if they won or not)
     */
    public boolean checkWin(){
        boolean win = true;
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (!squares[i][j].isRevealed() && !squares[i][j].isHasBomb()) {
                    win = false;
                }
            }
        }
        return win;
    }

    /**
     * the method revealBombs exists to reveal every bomb in the current game by drawing it in red if the user clicks
     * a bomb.
     */
    public void revealBombs(){
        StdDraw.setPenColor(Color.red);
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                squares[i][j].setRevealed(true);
                if (squares[i][j].isHasBomb()==true){
                    squares[i][j].drawSqure(Color.red);
                }

            }

        }
    }

    /**
     * the method checkClick exists to scan for a mouse click.
     * The method then grabs the x and y position of the mouse click and acts on that square in the grid by going to
     * those positions (x,y) in the 2 dimensional array
     * Checks 3 click cases:
     * if F is being pressed
     * if the clicked square is a bomb
     * if the clicked square is just a regular square
     */
    public void checkClick() {
        boolean Clique=false;

        if (StdDraw.mousePressed() && !Clique) {//LOOKS FOR MOUSE CLICK
            Clique=true;
            while (Clique) {
                double mouseX = Math.floor(StdDraw.mouseX());
                double mouseY = Math.floor(StdDraw.mouseY());
                int xloc = (int) mouseX;
                int yloc = (int) mouseY;
                try {
                    Square temp = squares[xloc][yloc];
                    if (StdDraw.isKeyPressed(70) && temp.isRevealed()==false) {//CHECKS IF F IS BEING PRESSED TO FLAG SOME SHIT OR SOME DUMB SHIT
                        temp.flagIt();
                    } else if (!temp.isHasBomb() && !temp.isFlagged() && !temp.isRevealed()) {//regular click
                        temp.drawSqure(Color.gray);
                        squares[xloc][yloc].setRevealed(true);
                        revealSquares(temp);
                    } else if (temp.isHasBomb()) {//ITS A BOMB
                        temp.drawSqure(Color.red);
                        revealBombs();
                    }
                } catch (Exception E) {
                }
                Clique=false;
            }
        }
    }

    //below are getters and setters to be used as needed
    public int getNumBombs() {
        return numBombs;
    }

    public void setNumBombs(int numBombs) {
        this.numBombs = numBombs;
    }

    public int getNumFlags() {
        return numFlags;
    }

    public void setNumFlags(int numFlags) {
        this.numFlags = numFlags;
    }

}
