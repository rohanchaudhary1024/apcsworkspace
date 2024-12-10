import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

/**
 * A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn. A jumper can remove another jumper by jumping on them.
 * 
 * @author Rohan Chaudhary, Diya Shah
 * @version 10-29-2024
 * @author Period: 2
 * @author Assignment: GridWorld_Part3_Jumper
 * @author Sources: N/A
 */
public class Jumper
    extends Bug
    implements Edible
{
    /**
     * Moves two in the current direction if it is a valid grid.
     */
    public void move()
    {
        Grid<Actor> gr = this.getGrid();
        if (gr != null)
        {
            Location loc = this.getLocation();
            Location next = (loc.getAdjacentLocation(this.getDirection()))
                .getAdjacentLocation(this.getDirection());
            if (gr.isValid(next))
            {
                this.moveTo(next);
            }
        }
    }


    /**
     * checks if the Jumper can jump two spaces ahead of it, returns true if the
     * spot is valid, empty, or has an edible Actor in it.
     * 
     * @return boolean denoting ability to move
     */
    public boolean canMove()
    {
        Grid<Actor> gr = this.getGrid();
        if (gr == null)
        {
            return false;
        }
        else
        {
            Location loc = this.getLocation();
            Location next = (loc.getAdjacentLocation(this.getDirection()))
                .getAdjacentLocation(this.getDirection());
            if (!gr.isValid(next))
            {
                return false;
            }
            else
            {
                Actor neighbor = (Actor)gr.get(next);
                return neighbor instanceof Edible || neighbor == null;
            }
        }
    }
}
