/**
 *  This is a class that tests the Book class.
 *
 *  @author  Rohan Chaudhary
 *  @version 9/13/2024
 *  @author  Period: 2
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: N/A
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for
     * consistency.
     * @param args is not used.
     */
    public static void main( String[] args )
    {
        Book testBook = new Book(3);
        System.out.println(testBook.getNumPages());
        System.out.println(testBook.getCurrentPage());
        for (int i = 0; i < 3; i++) {
            testBook.nextPage();
            System.out.println(testBook.getCurrentPage());
        }
    }
}
