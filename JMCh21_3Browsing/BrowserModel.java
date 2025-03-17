//import java.util.List;
import java.util.Stack;

/**
 * This class browses through an HTML file, capable of going back and forward,
 * and clicking on hyperlinks. This class has two stacks determining the lines
 * that have been visited and the lines that have been backed out of, calling
 * upon them and updating the view to create a cohesive browsing experience.
 * Back sends the user to the previous line visited, home sends the user to line
 * 0, forward sends the user to the previous line where back was used, and
 * hasback and hasforward are used within the back and forward methods.
 * 
 * @author Rohan Chaudhary
 * @version 1-8-2024
 */
public class BrowserModel
{
    private BrowserView    view;
    private Stack<Integer> backStk;
    private Stack<Integer> forwardStk;
    private int            topLine;

    /**
     * Initializes view, sets the topline and view to 0, initializes backstar
     * and forward stack
     * 
     * @param view
     *            BrowserView used to update the GUI
     */
    public BrowserModel(BrowserView view)
    {
        this.view = view;
        topLine = 0;
        this.view.update(0);
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
    }


    /**
     * Sends the view to the previous website visited, updating the stacks and
     * the GUI
     */
    public void back()
    {
        if (backStk.isEmpty())
        {
            return;
        }
        forwardStk.push(topLine);
        topLine = backStk.pop();
        view.update(topLine);

    }


    /**
     * Sends the view to the previous website backed out of, updating the stacks
     * and the GUI
     */
    public void forward()
    {
        if (forwardStk.isEmpty())
        {
            return;
        }
        backStk.push(topLine);
        topLine = forwardStk.pop();
        view.update(topLine);
    }


    /**
     * Sends the view to line 0, updating the stacks and the GUI
     */
    public void home()
    {
        backStk.push(topLine);
        topLine = 0;
        view.update(0);
    };

    /**
     * Sends the view to line n (input), updates stacks and GUI
     * @param n line to view
     */
    public void followLink(int n)
    {
        backStk.push(topLine);
        topLine = n;
        view.update(topLine);

    }

    /**
     * Checks if the back stack is empty
     * @return boolean representing status of the stack
     */
    public boolean hasBack()
    {
        return !backStk.isEmpty();
    }

    /**
     * Checks if the forward stack is empty
     * @return boolean representing status of the stack
     */
    public boolean hasForward()
    {
        return !forwardStk.isEmpty();
    }


    // The following are for test purposes only
    /**
     * Returns back stack
     * @return back stack
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }

    /**
     * Returns forward stack
     * @return forward stack
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }

    /**
     * Returns top line
     * @return top line
     */
    public int getTopLine()
    {
        return topLine;
    }
}
