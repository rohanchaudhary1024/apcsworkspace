import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;

/**
 * Spawns a jumper and a bug to test behavior. Creates a grid with two objects,
 * one of type Jumper and the other of type Bug, both in random locations. Meant
 * to test program behavior.
 *
 * @author Rohan Chaudhary, Diya Shah
 * @version 10-29-2024
 * @author Period: 2
 * @author Assignment: GridWorld_Part3_Jumper
 * @author Sources: N/A
 */
public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Jumper());
        world.add(new Bug());
        world.show();
    }
}
