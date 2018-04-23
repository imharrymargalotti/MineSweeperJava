import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

/**
 * Created by harrymargalotti on 4/24/17.
 * The purpose of this class is to create objects needed for minesweeper, and run the game
 */
public class Minesweeper {
    private Grid grid;

    public Minesweeper(Grid grid) {
        this.grid = grid;
    }//constructor

    /**
     * the playAgain method exists to allow the user to play again after their first game ends if they choose so
     */
    public void playAgain(){
        Scanner s=new Scanner(System.in);
        System.out.println("Weclome to Minesweeper!\n" +
                "--------------------\n" +
                "Controls: \n" +
                "Click-Select square\n" +
                "F+Click-flag square\n" +
                "--------------------\n" +
                "1) Beginner\n" +
                "2) Intermediate\n" +
                "3) Expert\n");
        System.out.print("Enter a difficulty");
        String difficulty=s.next().toLowerCase();
        Grid griddy = new Grid(difficulty);
        Minesweeper game=new Minesweeper(griddy);
        game.Run();
    }

    /**
     * the Run method exists to run the game in an infinite loop until the user wins, loses. or alt+F4's my program.
     * it constantly checks for mouse clicks, and win/lose cases. Then it will ask the user if theyd like to play again
     * if 'Y' it calls the play again method to ask for a new difficulty etc. otherwise it quits the application
     */
    public void Run(){
        Scanner s=new Scanner(System.in);
        //System.out.println("function run called");
        while (true) {
            grid.checkClick();
            if(grid.checkFlags()){
                System.out.println("Game Over!");
                System.out.print("Wanna play again? (Y/N)");
                String input=s.next();
                if(input.equals("Y")){
                    playAgain();
                }
                else{
                    System.exit(1);
                }
            }
            if(grid.checkWin()){
                System.out.println("Game Over!");
                System.out.print("Wanna play again? (Y/N)");
                String input=s.next();
                if(input.equals("Y")){
                    playAgain();
                }
                else{
                    System.exit(1);
                }
            }



        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Weclome to Minesweeper!\n" +
                "--------------------\n" +
                "Controls: \n" +
                "Click-Select square\n" +
                "F+Click-flag square\n" +
                "--------------------\n" +
                "1) Beginner\n" +
                "2) Intermediate\n" +
                "3) Expert\n" +
                "4) Custom\n");
        try {
            System.out.print("Enter a difficulty");
            String difficulty = s.next().toLowerCase();
            Grid griddy = new Grid(difficulty);
            Minesweeper game = new Minesweeper(griddy);
            game.Run();
        }catch (Exception e){}

    }
}
