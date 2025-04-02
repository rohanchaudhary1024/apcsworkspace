import java.util.*;

/**
 * Holds mail for each Actor, handling its sending and reception.
 * to use it.
 * 
 * @author Rohan Chaudhary
 * @version 1-14-2025
 * 
 * @author Period - N/A
 * @author Assignment - JMCh21_6ActorsWorld
 * 
 * @author Sources - N/A
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;
    
    public MailServer() {
        actors = new TreeSet<Actor>();
    }
    
    public void signUp(Actor actor) {
        actors.add(actor);
    }

    public void dispatch(Message msg) {
        if (msg.getRecipient() == null) {
            for (Actor i : actors) {
                if (i != msg.getSender()) {
                    i.receive(msg);
                }
            }
        }
        else {
            msg.getRecipient().receive(msg);
        }
    }
    // for testing purposes only
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
