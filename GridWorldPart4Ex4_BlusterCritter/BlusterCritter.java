import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

import java.awt.Color;

/**
 * Extension of critter class that darkens when more than a set amount of actors
 * are near it. Can be initialized with the set threshold for darkening, has a
 * method that gets all actors in a 2 move area, and method that compiles it
 * into an array, using two helper methods to lighten or darken it based on the
 * result.
 * 
 * @author Rohan Chaudhary
 * @version 11/23/2024
 * @author Period: N/A
 * @author Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 * @author Sources: N/A
 */
public class BlusterCritter
    extends Critter
{
    private int courage;

    /**
     * Constructs a new BlusterCritter object with the parameter c denoting the
     * level of courage that it has
     * 
     * @param c
     *            parameter denoting courage level
     */
    public BlusterCritter(int c)
    {
        courage = c;
    }


    /**
     * Returns an array with the actors in a 2 move radius Postcondition: The
     * state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = this.getLocation();
        for (int i = -2; i < 3; i++)
        {
            for (int j = -2; j < 3; j++)
            {
                Location nextLoc =
                    new Location(loc.getRow() + i, loc.getCol() + j);
                if (gr.isValid(nextLoc) && !(i == 0 && j == 0))
                {
                    if (gr.get(nextLoc) instanceof Actor)
                    {
                        actors.add(gr.get(nextLoc));
                    }
                }
            }
        }

        return actors;
        // Go through each grid square two moves away
        // If it is valid & an actor, place the
        // resultant actor into the actors AL
    }


    /**
     * Calls getActors, using the result to determine whether to darken or
     * lighten the critter. Postcondition: (1) The state of all actors in the
     * grid other than this critter and the elements of <code>actors</code> is
     * unchanged. (2) The location of this critter is unchanged.
     * 
     * @param actors
     *            the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        if (getActors().size() >= courage)
        {
            darken();
        }
        else
        {
            lighten();
        }
    }


    /**
     * Darkens the color of the BlusterCritter
     */
    private void darken()
    {
        Color c = getColor();
        int red = (int)(c.getRed() * (1 - .05));
        int blue = (int)(c.getBlue() * (1 - .05));
        int green = (int)(c.getGreen() * (1 - .05));

        setColor(new Color(red, green, blue));
        // see act method of flower for example
    }


    /**
     * Lightens the color of the BlusterCritter
     */
    private void lighten()
    {
        Color c = getColor();
        int red = (int)(c.getRed() * (1 + .05));
        int blue = (int)(c.getBlue() * (1 + .05));
        int green = (int)(c.getGreen() * (1 + .05));
        if (red > 255)
        {
            red = 255;
        }
        if (blue > 255)
        {
            blue = 255;
        }
        if (green > 255)
        {
            green = 255;
        }

        setColor(new Color(red, green, blue));
    }
}
