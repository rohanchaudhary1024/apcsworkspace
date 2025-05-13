    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Scanner;


    /**
     *  TODO Write a one-sentence summary of your class here.
     *  TODO Follow it with additional details about its purpose, what abstraction
     *  it represents, and how to use it.
     *
     *  @author  Rohan Chaudhary
     *  @version 4-8-25
     *  @author  Period: 2
     *  @author  Assignment: AB Free Response Quilt
     *
     *  @author  Sources: N/A
     */
    public class Quilt
    {
        char[][] myBlock;       // stores pattern for one block
        int myRowsOfBlocks;     // number of rows of blocks in the quilt 
        int myColsOfBlocks;     // number of columns of blocks in the quilt
        
        // precondition:   quiltBlock refers to an initialized quilt block,
        //                 rowsOfBlocks > 0, colsOfBlocks > 0
        // postcondition:  myRowsOfBlocks and myColsOfBlocks are initialized to
        //                 the number of rows and columns of blocks that make up
        //                 the quilt; myBlock has been initialized to the block
        //                 pattern of quiltBlock.
        public Quilt(char[][] quiltBlock, int rowsOfBlocks, int colsOfBlocks)
        {
            myRowsOfBlocks = rowsOfBlocks;
            myColsOfBlocks = colsOfBlocks;
            myBlock = quiltBlock;
        }
        
        // precondition:  startRow >= 0; startCol >= 0;
        //                startRow + myBlock.numrows() <= qmat.numrows();
        //                startCol + myBlock.numcols() <= qmat.numcols();
        // postcondition: myBlock has been copied into the matrix
        //                qmat with its upper-left corner at the position
        //                startRow, startCol
        public void placeBlock(int startRow, int startCol, char[][] qmat)
        {
            for ( int r = 0; r < myBlock.length; r++ )
            {
                for ( int c = 0; c < myBlock[r].length; c++ )
                {
                    qmat[startRow + r][startCol + c] = myBlock[r][c];
                }
            }
        }
        
        // precondition:  startRow >= 0; startCol >= 0;
        //  startRow + myBlock.length <= qmat.length;
        //  startCol + myBlock[0].length <= qmat[0].length;
        //postcondition: a flipped version of myBlock has been copied into the
        //  matrix qmat with its upper-left corner at the position
        //  startRow, startCol
        public void placeFlipped( int startRow, int startCol, char[][] qmat )
        {
            
            //System.out.println(startRow + myBlock.length + " " + qmat.length);
            for ( int r = 0; r < myBlock.length; r++ )
            {
               
                for ( int c = 0; c < myBlock[r].length; c++ )
                {   
                    char tempVal =  myBlock[myBlock.length-1-r][myBlock[r].length-1-c];
                    qmat[r+startRow][c+startCol] = tempVal;
                }
            }
        }
        
        public char[][] quiltToMat() // checkerboard alternation
        {
            char[][] output = new char[myRowsOfBlocks*myBlock.length][myColsOfBlocks*myBlock[0].length];
            System.out.println(output.length + " " + output[0].length);


            for (int i = 0; i < myRowsOfBlocks; i++) {
                for (int j = 0 ; j < myColsOfBlocks; j++) {
                    if ((j % 2 == 0 && i % 2 == 0) || (j%2 == 1 && i%2 == 1)) {
                        System.out.println(i*myBlock.length + " " + j*myBlock[0].length);
                        placeBlock(i*myBlock.length, j*myBlock[0].length, output);
                    }
                    else {
                        System.out.println(i*myBlock.length + " " + j*myBlock[0].length);
                        placeFlipped(i*myBlock.length, j*myBlock[0].length, output);
                    }
                }
            }
            return output;
            
        }
        
        /*
        * Intended only for testing.
        */
        public char[][] getMyBlock()
        {
            return myBlock;
        }
        
        public int getMyRowsOfBlocks()
        {
            return myRowsOfBlocks;
        }

        public int getMyColsOfBlocks()
        {
            return myColsOfBlocks;
        }
        
        /**
         * Test Quilt class.
         * @param args command-line parameters (not used)
         */
        public static void main( String[] args )
        {
            char[][] qBlock = { {'x', '.', '.', '.', 'x'},
                                {'.', 'x', '.', 'x', '.'},
                                {'.', '.', 'x', '.', '.'},
                                {'.', '.', 'x', '.', '.'} };

            Quilt q = new Quilt(qBlock, 3, 3);
            
            char[][] quilt = q.quiltToMat();
            
            for (char r[] : quilt)
            {
                for (char ch : r)
                {
                    System.out.print(ch);
                }
                System.out.println();
            }
            
        }
    }
