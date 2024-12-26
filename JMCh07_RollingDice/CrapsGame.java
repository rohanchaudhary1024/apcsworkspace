/**
 * Implements the game of Craps logic.
 *
 * @author Rohan Chaudhary
 * @version 9-20-2024
 * @author Period: 2
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: N/A
 */
public class CrapsGame {
    private int point = 0;

    /**
     * Calculates the result of the next dice roll in the Craps game.
     * The parameter total is the sum of dots on two dice.
     * point is set to the saved total, if the game continues,
     * or 0, if the game has ended.
     * Returns 1 if player won, -1 if player lost,
     * 0 if player continues rolling.
     * 
     * @return 1 if win, 0 if nothing, -1 if lost
     * @param total - total value of two rolled dice
     */
    public int processRoll(int total) 
    {
        int result = 0;
        if (point == 0) 
        {
            if (total == 7 || total == 11) 
            {
                result = 1;
            } 
            else if (total == 2 || total == 3 || total == 12) 
            {
                result = -1;
            } 
            else 
            {
                point = total;
            }
        } 
        else 
        {
            if (total == point) 
            {
                result = 1;
                point = 0;
            } 
            else if (total == 7) 
            {
                result = -1;
                point = 0;
            }
        }
        return result;
    }

    /**
     * Returns the saved point
     * @return - saved point
     */
    public int getPoint() 
    {
        return point;
    }
}