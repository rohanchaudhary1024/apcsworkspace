import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;

/**
 * On a grid with tiles white and black, erases adjacent strings of black tiles
 * when clicked on one. Fitted with a constructor that initializes a grid with
 * the Tile object, an a method to read the black tiles in from a file. The
 * erase method is called with the grid, and the starting coordinates, and uses
 * recursion in each direction to speedily erase all adjacent blacl objects.
 *
 * @author Rohan Chaudhary
 * @version 11/23/2024
 * @author Period: 2
 * @author Assignment: AB24_1EraseObject_GridWorld
 * @author Sources: N/A
 */
public class EraseObject
    extends World<Tile>
{
    private static final Color IMGOBJ_COLOR = Color.BLACK;
    private static final Color ERASE_COLOR  = Color.WHITE;

    /**
     * Constructs a default 20x20 grid containing black tiles at the locations
     * given in the file "digital.txt".
     */
    public EraseObject()
    {
        this(new BoundedGrid<Tile>(20, 20), "digital.txt");
    }


    /**
     * Constructs an EraseObject World with the provided grid. Populates the
     * world with black tile objects at the locations given in the specified
     * file (fName).
     * 
     * @param bg
     *            bounded grid used by this World
     * @param fName
     *            name of file containing location information for tile
     *            placement in this World
     */
    public EraseObject(BoundedGrid<Tile> bg, String fName)
    {
        setGrid(bg);
        getData(fName);

        setMessage("Click on the object to be erased");
    }


    /**
     * Overrides
     * <code>info.gridworld.world.World&lt;Tile&lt;.locationClicked</code> This
     * method is called when the user clicks on a location in the WorldFrame.
     * Invokes the recursive erase procedure on the clicked location.
     * 
     * @param loc
     *            the grid location that the user selected
     * @return true - the world consumes the click
     */
    public boolean locationClicked(Location loc)
    {
        Grid<Tile> gr = getGrid();

        setMessage("Tile clicked at " + loc);
        erase(gr, loc.getRow(), loc.getCol());

        return true;
    }


    /**
     * Loads the data from the specified file containing tile locations into the
     * this grid. The first entry in the provided text file is the number of
     * pairs that follow (i.e., 55). Each subsequent line contains a pair of
     * integers, separated by a blank space. Each pair is a row and column
     * coordinate that specifies the location of a black tile in the starting
     * grid.
     * 
     * @param fName
     *            name of file containing tile locations
     */
    private void getData(String fName)
    {
        File file = new File(fName);
        Scanner input = null;
        try
        {
            input = new Scanner(file);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Cannot open " + fName);
            System.exit(1);
        }

        int max = input.nextInt();
        Location loc;
        for (int i = 0; i < max; i++)
        {
            loc = new Location(input.nextInt(), input.nextInt());
            add(loc, new Tile(IMGOBJ_COLOR));
        }
    }


    /**
     * Recursively changes the color of a series of adjacent tiles (erases)
     * starting at the given coordinates if this coordinate is part of the
     * object. The method should erase the entire object (remove black).
     *
     * @param gr
     *            grid containing sequences of adjacent tiles
     * @param row
     *            row coordinate to begin erasure
     * @param col
     *            column coordinate to begin erasure
     */
    private void erase(Grid<Tile> gr, int row, int col)
    {
        Location loc = new Location(row, col);
        if (gr.isValid(loc) && (gr.get(loc) instanceof Tile)) {
            Tile tile = gr.get(loc);
            tile.setColor(ERASE_COLOR);
        }

        Location locOne = new Location(row + 1, col);
        if (gr.isValid(locOne) && (gr.get(locOne) instanceof Tile))
        {
            Tile tileOne = gr.get(locOne);
            if (tileOne.getColor() == IMGOBJ_COLOR)
            {
                erase(gr, row + 1, col);
            }
        }

        Location locTwo = new Location(row - 1, col);
        if (gr.isValid(locTwo) && (gr.get(locTwo) instanceof Tile))
        {
            Tile tileTwo = gr.get(locTwo);
            if (tileTwo.getColor() == IMGOBJ_COLOR)
            {
                erase(gr, row - 1, col);
            }
        }

        Location locThree = new Location(row, col + 1);
        if (gr.isValid(locThree) && (gr.get(locThree) instanceof Tile))
        {
            Tile tileThree = gr.get(locThree);
            if (tileThree.getColor() == IMGOBJ_COLOR)
            {
                erase(gr, row, col + 1);
            }
        }

        Location locFour = new Location(row, col - 1);
        if (gr.isValid(locFour) && (gr.get(locFour) instanceof Tile))
        {
            Tile tileFour = gr.get(locFour);
            if (tileFour.getColor() == IMGOBJ_COLOR)
            {
                erase(gr, row, col - 1);
            }
        }
    }


    public static void main(String[] args)
    {
        new EraseObject().show();
    }
}
