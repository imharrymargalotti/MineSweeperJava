import java.awt.*;

/**
 * Created by harrymargalotti on 4/24/17.
 */
public class Square {
    private boolean isFlagged;
    private double Xcoord;
    private double Ycoord;
    private boolean hasBomb;
    private int bombsTouching;
    private boolean isRevealed;

    public Square( double xcoord, double ycoord) {//constructor
        Xcoord = xcoord;
        Ycoord = ycoord;
        this.hasBomb = hasBomb;
        this.bombsTouching = bombsTouching;
    }

    //Getters and setters to be used as needed
    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public double getXcoord() {
        return Xcoord;
    }


    public double getYcoord() {
        return Ycoord;
    }


    public boolean isHasBomb() {
        return hasBomb;
    }

    public void setHasBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    /**
     * this method takes a color and allows a square to re-draw itself as a different color if needed
     * @param color
     */
    public void drawSqure(Color color){
        StdDraw.setPenColor(color);
        double newX=this.Xcoord+0.45;
        double newY=this.Ycoord+0.45;
        StdDraw.filledSquare(newX,newY,0.45);
    }

    /**
     * this method allows a square to flag itself with an 'F'
     */
    public void flagIt(){
            StdDraw.setPenColor(Color.black);
            double newX = this.Xcoord + 0.45;
            double newY = this.Ycoord + 0.45;
            StdDraw.text(newX, newY, "F");
            this.setFlagged(true);
        //else{
         //   this.drawSqure(Color.cyan);
        //}
    }

}
