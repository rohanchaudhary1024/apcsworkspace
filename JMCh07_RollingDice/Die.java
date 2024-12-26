import java.util.Random;

/**
 *  Simulates a six-sided die.
 *
 *  @author  Rohan Chaudhary
 *  @version 9-20-2024  
 *  @author  Period: 2
 *  @author  Assignment: JMCh07_RollingDice
 *
 *  @author  Sources: N/A
 */
public class Die
{
    private int numDots;

    /**
     * Sets numDots to a random integer from 1 to 6
     */
    public void roll()
    {
        Random rand = new Random();
        numDots = rand.nextInt(6) + 1;
    }
    
    /**
     * Returns the value of the most recent roll.
     * @return numDots
     */
    public int getNumDots()
    {
        return numDots;
    }
}
