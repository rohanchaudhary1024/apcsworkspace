/**
 * Represents a board for the game of Hex. Matrice representation of a Hexagonal
 * board, where each grid member has a maximum of six neighbors. Capable of
 * setting and getting the values in each hex, and determining the winner for
 * the game of hex depending on if there is a contingous chain of black hex
 * values that stretch from one side of the board to the other.
 * 
 * @author Rohan Chaudhary
 * @version 1-25-2024
 * @author Period - 2
 * @author Assignment - JM Ch22.6 - Hex
 * @author Sources - N/A
 */
public class HexBoard
    extends CharMatrix
{
    public HexBoard(int rows, int cols)
    {
        super(rows, cols);
    }


    public boolean isBlack(int r, int c)
    {
        return (super.charAt(r, c) == 'b');
    }


    public boolean isWhite(int r, int c)
    {
        return (super.charAt(r, c) == 'w');
    }


    public boolean isGray(int r, int c)
    {
        return (super.charAt(r, c) == 'x');
    }


    public void setBlack(int r, int c)
    {
        setCharAt(r, c, 'b');
    }


    public void setWhite(int r, int c)
    {
        setCharAt(r, c, 'w');
    }


    public void setGray(int r, int c)
    {
        setCharAt(r, c, 'x');
    }


    /**
     * Returns true if there is a contiguous chain of black stones that starts
     * in col 0 and ends in the last column of the board; otherwise returns
     * false.
     */
    public boolean blackHasWon()
    {
        for (int i = 0; i < numRows(); i++)
        {
            areaFill(i, 0);
        }
        boolean temp = false;
        for (int i = 0; i < numRows(); i++)
        {
            if (isGray(i, numCols()-1))
            {
                temp = true;
            }
        }

        for (int i = 0; i < numRows(); i++)
        {
            areaFillBlack(i, 0);
        }
        return temp;
    }


    /**
     * Fills the contiguous area that contains r,c with gray color. Does nothing
     * if r, c is out of bounds or is not black.
     */
    public void areaFill(int r, int c)
    {
        if (r < 0 || r >= numRows() || c < 0 || c >= numCols() || !isBlack(r, c))
        {
            return;
        }
        setGray(r, c);
        areaFill(r - 1, c - 1);
        areaFill(r - 1, c);
        areaFill(r, c - 1);
        areaFill(r, c + 1);
        areaFill(r + 1, c);
        areaFill(r + 1, c + 1);
    }


    /**
     * Areafill but Black
     */
    public void areaFillBlack(int r, int c)
    {
        if (r < 0 || r >= super.numRows() || c < 0 || c >= super.numCols() || !isGray(r, c))
        {
            return;
        }
        setBlack(r, c);
        areaFillBlack(r - 1, c - 1);
        areaFillBlack(r - 1, c);
        areaFillBlack(r, c - 1);
        areaFillBlack(r, c + 1);
        areaFillBlack(r + 1, c);
        areaFillBlack(r + 1, c + 1);
    }


    public String toString()
    {
        String s = "";

        for (int r = 0; r < numRows(); r++)
        {
            for (int c = 0; c < numCols(); c++)
            {
                if (isBlack(r, c))
                    s += 'B';
                else if (isWhite(r, c))
                    s += 'W';
                else if (isGray(r, c))
                    s += 'X';
                else
                    s += '.';
            }
            s += '\n';
        }
        return s;
    }

    // ****************************************************************


    private boolean isInBounds(int row, int col)
    {
        // TODO complete method
        return false; // fix this
    }
}
