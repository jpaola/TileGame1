import java.util.ArrayList;
import java.util.Scanner;
/**
 * Plays a number tile game. A number tile in the player's hand can be inserted
 * but once on the board its position is fixed. If a move cannot be made then
 * one tile is added to the player's hand and the other player gets to move. A
 * turn is when player1 makes a move and then player2 makes a move ( to make  the
 * game fair). The game ends when all the tiles are removed from one (or both)
 * player's hand(s). If one player's hand is empty and the other player's hand
 * still contains tiles then the player with the empty hand is the winner. If both
 * players hands are empty then the game ends in a tie.
 */
/**
 *
 * @author Paola Jiron
 */
public class TileGamePlayer
{
    public static void main (String [] args)
    {
        // scans the user's response after each game
        Scanner in = new Scanner(System.in);    
        String input;

        do {
            // instance of a tile game

            TileGame game = new TileGame();
            game.getBoard().add(new NumberTile());  // initialize the game board

            // get 2 hands

            ArrayList<NumberTile> player1 = game.getHand();
            ArrayList<NumberTile> player2 = game.getHand();

            // save initial players hands
            String p1InitialHand = "Player 1's Initial Hand:\n" 
                    + player1.toString();
            String p2InitialHand = "Player 2's Initial Hand:\n" 
                    + player2.toString();

            // make moves until one or both players hand is empty

            while (!player1.isEmpty() && !player2.isEmpty())
            {
                game.makeMove(player1);
                game.makeMove(player2);

            }

            //if player 1's hand is empty, player 1 wins and player 2 loses
            if ((player1.isEmpty()) && !(player2.isEmpty()))
            {
                System.out.println("Player 1 WINS!");


                // display initial hands of both players
                System.out.println(p1InitialHand + "\n" + p2InitialHand);

                System.out.println("Player 1's Final Hand:\n" + player1.toString()
                        + "\nPlayer 2's Final Hand:\n" + player2.toString()
                        + "\nFinal Board:\n" + game.toString());
              }   
                // if player 2's hand is empty,
            else if ((player2.isEmpty()) && !(player1.isEmpty()))    
                // player 2 wins and player 1 loses
            {
                System.out.println("Player 2 WINS!");


                // display initial hands of both players
                System.out.println(p1InitialHand + "\n" + p2InitialHand);

                // display final hands and final board

                System.out.println("Player 1's Final Hand:\n" + player1.toString()
                        + "\nPlayer 2's Final Hand:\n" + player2.toString()
                        + "\nFinal Board:\n" + game.toString());
               }    
                // players are tied 
             else if (player1.isEmpty() && player2.isEmpty())        
            {
                System.out.println("There is a TIE!");


                // display initial hands of both players
                System.out.println(p1InitialHand + "\n" + p2InitialHand);

                // display final hands and final board

                System.out.println("Player 1's Final Hand:\n" + player1.toString()
                        + "\nPlayer 2's Final Hand:\n" + player2.toString()
                        + "\nFinal Board:\n" + game.toString());

            }
            // ask user if he/she would like to play again
            System.out.println("Want to play again? (Type YES to play,"
                    + " NO to cancel)\n");
            input = in.next();

                // a new game will start while user types "yes" 
        } while (input.equalsIgnoreCase("yes"));    
    }
}   // end of TileGamePlayer class
