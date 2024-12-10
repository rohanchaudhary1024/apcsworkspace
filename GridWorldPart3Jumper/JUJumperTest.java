import info.gridworld.actor.*;
import info.gridworld.grid.*;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Jumper tests:. test01 - jumper next to edge of grid - should turn test02 -
 * jumper 2 from edge of grid - should turn test03 - jumper next to an empty
 * space - should jump test04 - jumper adjacent to rock - should jump over
 * test05 - jumper endloc blocked by rock - should turn test06 - jumper adjacent
 * to edible - should jump over test07 - jumper endloc blocked by rock - should
 * eat
 *
 * @author Rohan Chaudhary, Diya Shah
 * @version 10-29-2024
 * @author Period: 2
 * @author Assignment - GridWorld Part 3 Jumper
 * @author Sources: N/A
 */
public class JUJumperTest
{
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;
    private ActorWorld  world;
    private Jumper      jumper1;
    private Rock        rock1;
    private Jumper      jumper2;

    /**
     * Invoked before each test to instantiate the objects used for every test.
     */
    @Before
    public void initialize()
    {
        grid = new BoundedGrid<Actor>(8, 8);
        world = new ActorWorld(grid);
        jumper1 = new Jumper();
        rock1 = new Rock();
        jumper2 = new Jumper();
    }


    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn()
    {
        Location loc = new Location(0, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }


    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn()
    {
        Location loc = new Location(1, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }


    /**
     * test03 - jumper next to empty space, should move.
     */
    @Test
    public void test03()
    {
        Location loc = new Location(2, 3);
        world.add(loc, jumper1);
        jumper1.act();
        Location testLoc = new Location(0, 3);
        assertTrue(testOccupied(testLoc, jumper1, Location.NORTH));
    }


    /**
     * test04 - jumper jumping over Rock, should jump
     */
    @Test
    public void test04()
    {
        Location loc = new Location(2, 3);
        world.add(loc, jumper1);
        Location rockLoc = new Location(1, 3);
        world.add(rockLoc, rock1);
        jumper1.act();
        Location testLoc = new Location(0, 3);
        assertTrue(testOccupied(testLoc, jumper1, Location.NORTH));
    }


    /**
     * test05 - jumper jump path blocked by rock, should turn
     */
    @Test
    public void test05()
    {
        Location loc = new Location(2, 3);
        world.add(loc, jumper1);
        Location rockLoc = new Location(0, 3);
        world.add(rockLoc, rock1);
        jumper1.act();
        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }


    /**
     * test06 - jumper jumps over an edible object, should jump
     */
    @Test
    public void test06()
    {
        Location loc = new Location(2, 3);
        world.add(loc, jumper1);
        Location jumpLoc = new Location(1, 3);
        world.add(jumpLoc, jumper2);
        jumper1.act();
        Location testLoc = new Location(0, 3);
        assertTrue(testOccupied(testLoc, jumper1, Location.NORTH));
    }


    /**
     * test07 - jumper eats edible object, should eat
     */
    @Test
    public void test07()
    {
        Location loc = new Location(2, 3);
        world.add(loc, jumper1);
        Location jumpLoc = new Location(0, 3);
        world.add(jumpLoc, jumper2);
        jumper1.act();
        assertTrue(testOccupied(jumpLoc, jumper1, Location.NORTH));
    }


    /**
     * Test helper method to test for empty location.
     *
     * @param loc
     *            null location if empty
     * @return true if all assertions pass
     */
    private boolean testEmpty(Location loc)
    {
        Actor empty = grid.get(loc);
        assertNull("<<<<< " + loc + " should be empty. >>>>>", empty);

        return true;
    }


    /**
     * Test helper method to test that object is in a location, and has a
     * consistent loc, and direction dir.
     *
     * @param loc
     *            location that should be occupied
     * @param a
     *            actor that should be in location loc
     * @param dir
     *            direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied(Location loc, Actor a, int dir)
    {
        Actor found = grid.get(loc);
        assertSame("<<<<< " + loc + " should contain the actor. >>>>>", a, found);
        assertEquals("<<<<< Loc should be " + loc + " >>>>>", loc, found.getLocation());
        assertEquals("<<<<< Dir should be " + dir + " >>>>>", dir, found.getDirection());

        return true;
    }
}
