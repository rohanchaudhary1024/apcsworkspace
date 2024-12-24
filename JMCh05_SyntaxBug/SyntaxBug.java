import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import java.awt.Color;

/**
 * A subclass of Bug containing various iterations of the act method along with a few sytax and style errors.
 * This class is intended to be utilized alongside Chapter 5 - Syntax and Style.
 * This class also serves as a good introduction for Gridworld.
 * 
 * @author  Rohan Chaudhary
 * @version 9-5-2024
 *
 * @author  Period - 2
 * @author  Assignment - SyntaxBug
 *
 * @author  Sources - None
 */
public class SyntaxBug extends Bug
{
    private int sideLength;
    private int steps;
    /**
     * Constructs a yellow SyntaxBug
     */
    public SyntaxBug()
    {
        setColor( Color.YELLOW );
        sideLength = 3;
        steps = 0;
    }

    /**
     * The turn method used by one act method which turns SyntaxBug by a random angle.
     * @param angle the random number of degrees for the bug to turn (increments of 45)
     */
    public void turn(int angle)
    {
        setDirection(getDirection() +  angle);
    }

    /**
     *  The bug moves forward according to its current orientation and movement is possible, then turns either 0, 45, 90, 120, 180, 240, 300, or 360 degrees.
     */
    /* public void act()
    {
        if ( canMove() )
        {
            move();
        }
        int angle = 45 * (int)(Math.random() * 8);
        turn(angle);
    } */


    
    
    /**
     * The bug moves forward and increases steps by one if steps is less than sideLength and movement is possible, if steps is equal to or greater, it turns 90 degrees,
     * sets steps to 0, and increases sideLength by 1
     */
    /* public void act() 
    {
        if (steps < sideLength && canMove()) 
        {
            move();
            steps++;
        } 
        else 
        {
            turn();
            turn();
            steps = 0;
            // Each time a SpiralBug turns, increase the sideLength by one
            sideLength++;
        }
    } */
    

    
    /** 
     * The bug moves forward and increases steps by one if steps is less than sideLength and movement is possible, if steps is equal to or greater, it turns 45 degrees and sets steps to zero
     */ 
    /* public void act()
    {
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        } 
        else
        {
            turn();
            steps = 0;
        }
        
    } */
       
    /**
     *  The bug moves forward and increases steps by one if steps is less than sideLength and movement is possible, if steps is equal to or greater, it turns 45 degrees and sets steps to zero
     */
    public void act()
    { 
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
        }
    }


    //Typically, we would only include this in this class if we were testing funcitonality. 
    public static void main(String[] args) {

        UnboundedGrid<Actor> grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld(grid);
        SyntaxBug sp = new SyntaxBug();
        world.add(new Location(10, 10), sp);
        world.show();
    }
}
