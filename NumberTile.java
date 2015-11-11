import java.util.ArrayList;
import java.util.Random;

/**
 * A class that models a number tile with 4 randomly generated 
 * integer values on each side ranging from 1 to 9.
 *
 *@author Paola Jiron 
 */
public class NumberTile
{
    //instance var's
    private final ArrayList<Integer> tile;    // a number tile

    /**
     * Constructor for the number tile.
     */
     public NumberTile()
     {
        tile = new ArrayList<Integer>(); // creates a number tile object
        Random generator = new Random(); // creates a random generator object
        
        // generates 4 random int's from 1 to 9 for the tile
        for (int i = 0; i < 4; i++) {
            tile.add(generator.nextInt(9) + 1);   
        }
     }
    /**
     * Rotates the tile 90 degrees clockwise.
     */
     public void rotate()
     {
            // move each value one index location clockwise
            int temp = tile.get(0);
            tile.set(0, tile.get(3));
            tile.set(3, tile.get(2));
            tile.set(2, tile.get(1));
            tile.set(1, temp);
     }
    /**
     * Returns the left end of the tile.
     * @return The left end value on the tile.
     */
    public int getLeft()
    {
        return tile.get(0);
    }
    /**
     * Returns the right end of the tile.
     * @return The right end value on the tile.
     */
    public int getRight()
    {
        return tile.get(2);
    }
    /**
     * Returns the tile as a String in the form
     *          4
     *      5       7
     *          1
     * @return The tile as a String.
     */
    public String toString()
    {
        return "\n     " + tile.get(1) + "\n"
                + tile.get(0) + "         " + tile.get(2) + "\n"
                + "     " + tile.get(3) + "\n";

    }

}   // end of NumberTile class
