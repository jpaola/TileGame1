import java.util.ArrayList;

/**
 * A class that models inserting a tile into the tile game board.
 *
 * @author Paola Jiron 
 */
public class TileGame
{
    // instance var's
    private final ArrayList<NumberTile> board;  // the number tile game board

    /**
     * Constructs an empty board.
     */
    public TileGame()
    {
        // creates a tile game board object
        board = new ArrayList<NumberTile>();
    }
    /**
     * Accessor for the board.
     * @return The game board.
     */
    public ArrayList<NumberTile> getBoard()
    {
        return board;
    }
    /**
     * Creates and returns a hand of 5 random number tiles.
     * @return A hand (five tiles).
     */
    public ArrayList<NumberTile> getHand()
    {
        // creates a number tile hand object
        ArrayList<NumberTile> hand = new ArrayList<NumberTile>();

        // add 5 tiles to the hand
        for ( int i = 0; i < 5 ; i++)
        {
            hand.add(new NumberTile());
        }
        return hand;
    }
    /**
     * If the current tile fits in the board without rotating it, then return 
     * index i of a tile in the board so that the current tile fits before ti 
     * for i = 0....k-1,or return k if the current tile fits after the last 
     * tile. If the tile does not fit, return -1.
     * @param currentTile The current tile.
     * @return The index value where the tile will be placed on the board.
     */
    public int getIndexForFit(NumberTile currentTile)
    {
        // for each tile on the board..
        for(int i = 0; i < board.size(); i++)
        {
            // compare the value on the right of the tile with the 
            // value at the left side of the tile on the board

            if (currentTile.getRight() == board.get(i).getLeft())
            {
                // if the matching tile is the first tile on the board
                // OR if the left side value of the tile matches the right 
                // side value of the next tile on the board

                if( i == 0 || currentTile.getLeft() == board.get(i -1).getRight())
                {
                    return i;   // place the tile at index i
                }
            }
            // otherwise, if left value on tile matches the right hand value 
            // of the last tile on board..

            else if (currentTile.getLeft() == board.get(board.size()-1).getRight())
            {
                return board.size();    // place tile at the end
            }
        }
        return -1;  // return -1, if tile does not fit
    }
    /**
     * Calls the method getIndexForFit to see whether a tile can be inserted 
     * into the board. In this method the tile can be rotated. If the tile can 
     * be inserted return true. If the tile does not fit after rotating 
     * ( at most 3 times ), return false.
     * @param currentTile The current tile.
     * @return True if the tile can be inserted, false if the tile cannot be 
     * inserted after 3 rotations.
     */
    public boolean canInsertTile(NumberTile currentTile)
    {
        // return true if the tile fits
        if (getIndexForFit(currentTile) != -1)      
        {
            return true;
        }
        // otherwise, if the tile does not fit
        else if (getIndexForFit(currentTile) == -1)  
        {
            for (int i = 0; i < 3; i++)
            {
                currentTile.rotate();   // rotate tile

                // after each possible rotation check if
                // the tile fits, if so return

                if (getIndexForFit(currentTile) != -1)
                {
                    return true;
                }
            }
            return false;   // tile does not fit
        }
        return false;
    }
    /**
     * If a tile in the hand fits on the board then remove it from the hand and
     * place it on the board, if no tile from the hand fits, then add another
     * tile to the hand.
     * @param hand A player's hand (5 tiles).
     */
    public void makeMove(ArrayList<NumberTile> hand)
    {
        // traverse the tiles on hand

        for( int i = 0 ; i < hand.size(); i++)
        {
            // if the tile can be inserted without rotating it

            if(canInsertTile(hand.get(i)))
            {
                // place tile on board
                board.add(getIndexForFit(hand.get(i)),hand.get(i));   
                
                // remove the tile from the hand
                hand.remove(hand.get(i));                               
                break;
            }
            else    // otherwise..
            {
                // rotate tile up to 3 times if necessary to find fit

                for (int j = 0; j < 3 ; j++)
                {
                    hand.get(i).rotate();

                    // check for fit after rotation
                    if(canInsertTile(hand.get(i)))
                    {
                        // place tile on board
                        board.add(getIndexForFit(hand.get(i)),hand.get(i));     
                        
                        // remove the tile from the hand
                        hand.remove(hand.get(i));                               
                        break;
                    }

                }
                // if after complete rotation there is no match, add 
                // another tile to the hand
                hand.add(new NumberTile());
                continue;

            }

        }
    }
    /**
     * Returns the board as a String.
     * @return The board as a String.
     */
    public String toString()
    {
        return board.toString();    // note: calls inherited toString method.
    }
}   // end of TileGame class
