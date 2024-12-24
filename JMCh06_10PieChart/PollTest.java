/**
 *  Debug class for PollDisplay. 
 *
 *  @author  Rohan Chaudhary
 *  @version 9/6/2024
 *  @author  Period: 2
 *  @author  Assignment: JMCh06_10PieChart
 *
 *  @author  Sources: N/A
 */
public class PollTest
{
    /**
     * Class meant for debugging / identifying correctness of program.
     * Specifically debuggs PollDisplayPanel, and its methods.
     * 
     * @param args command line arguments [ N/A ]
     */
    public static void main( String[] args )
    { 
        PollDisplayPanel votingMachine =
        new PollDisplayPanel("Tami", "Brian", "Liz");
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println(votingMachine);
    }
}
