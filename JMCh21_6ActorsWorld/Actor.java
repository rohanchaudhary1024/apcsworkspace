import java.util.*;

/**
 * Implements an actor that can receive and send messages about its possessions
 * and give extra items that it doesn't need to others. The actor's objective
 * is to collect at least one of each item.
 * 
 * @author Rohan Chaudhary
 * @version 1/14/2025
 * 
 * @author Period - 2
 * @author Assignment - JMCh21_6ActorsWorld
 * 
 * @author Sources - N/A
 */
public class Actor implements Comparable<Actor>
{
    private static String[] items = {"left glove", "right glove", "hat"};

    private String name;
    private Collection<String> myPossessions;
    private Queue<Message> mailbox;
    private MailServer email;
    private boolean allSetFlag; // = false;

    public Actor(String nm)
    {
        name = nm;
        mailbox = new LinkedList<Message>();
    }

    public Actor(String nm, Collection<String> possessions)
    {
        name = nm;
        myPossessions = new ArrayList<String>();
        myPossessions.addAll(possessions);
        mailbox = new LinkedList<Message>();
    }

    // Adds server as this actor's email server.
    public void addMailServer(MailServer server)
    {
        email = server;
        email.signUp(this);
    }

    // returns the name of this actor.
    public String getName()
    {
        return name;
    }

    // Compares this actor to other in alphabetical
    // order of their names.
    public int compareTo(Actor other)
    {
        return name.compareTo(other.getName());
    }

    // Check whether this actor's name is the same as other's.
    public boolean equals(Object other)
    {
        return other != null && name.equals(((Actor)other).getName());
    }

    // Returns the hashCode for this actor equal to the hashcode of its name.
    public int hashCode()
    {
        return name.hashCode();
    }

    // Adds msg to this Actor's mailbox.
    public void receive(Message msg)
    {
        mailbox.add(msg);
    }

    // Called by someone else to give an item to this actor.
    // Checks whether this actor still needs the item.  If so,
    // sends a thank-you message to giver and returns true;
    // otherwise returns false.
    public boolean receiveItem(Actor giver, String item)
    {
        if (!myPossessions.contains(item))
        {
            myPossessions.add(item);
            email.add(new Message(this, giver, "thanks for the " + item));
            return true;
        }
        else 
            return false;
    }

    // 1. Checks possessions for this actor and sends a "need <item>"
    //    message to the list for each missing item.
    //
    // 2. Removes and processes messages from the mailbox,
    //    one by one.
    //    Processing messages:
    //    i)   Takes action only for messages with the text
    //         "need <item>", "have <item>", or "ship <item>".
    //         where <item> is the name of the item, such as "hat",
    //         "left glove", or "right glove".
    //         Skips all other messages.
    //    ii)  If this is a "need" message and this actor has an extra item
    //         requested, it replies with a "have <item>" message.
    //    iii) If this is a "have" message and this actor is missing the offered item,
    //         it replies with a "ship <item>" message.
    //    iv)  If this is a "ship" message and this actor still has an extra item,
    //         then it calls sender's receiveItem method.  If receiveItem
    //         returns true, removes item from this actor's possessions.
    //
    // 3. If allSetFlag is not set and this actor is all set, that is has
    //    one of each item, sends "thanks, i'm all set" to the list.
    public void readMail()
    {
        for (String item : items)
        {
            if (countPossessions(item) < 1)
                announce("need " + item);
        }
        // Handle input
        Message temp;
        while (mailbox.peek() != null) {
            temp = mailbox.remove();
            String tempText = temp.getText();
            // Break up tempText (Working)
            String action = "";
            String item = "";
            boolean fWord = true;
            for (int i = 0; i < tempText.length(); i++) {
                if (fWord) {
                    if (tempText.charAt(i) == ' ') {
                        fWord = false;
                    }
                    else {
                        action += tempText.charAt(i);
                    }
                }
                else {
                    item += tempText.charAt(i);
                }
            }

            // Print debug 
            // System.out.println(action);
            // System.out.println(item);

            // Check if temptext is valid
            fWord = false;
            for (String i : items) {
                if (item.equals(i)) {
                    fWord = true;
                }
            }
            if (fWord) {
                // Print Debug
                // System.out.println("Above is valid");
                fWord = false;
                boolean boolTwo = false;
                if (action.equals("need") || action.equals("ship")) {
                    for (String i : myPossessions) {
                        if (item.equals(i) && fWord == false) {
                            fWord = true;
                        }
                        else if (fWord && item.equals(i)) {
                            boolTwo = true;
                        }
                    }
                    if (boolTwo) {
                        // System.out.println("Dupe Exists");
                        if (action.equals("need")) {
                            reply(temp.getSender(),"have " + item);
                        }
                        else {
                            if (temp.getSender().receiveItem(this, item)) {
                                myPossessions.remove(item);
                            }
                        }   
                    }
                }
                else if (action.equals("have")) {
                    for (String i : myPossessions) {
                        if (item.equals(i)) {
                            fWord = true;
                        }
                    }
                    if (fWord == false)  {
                        reply(temp.getSender(),"ship " + item);
                    }
                }
            }
        }

        if (!allSetFlag && allSet())
            announce("thanks, i'm all set");
    }

    public String toString()
    {
        return name + " " + myPossessions;
    }

    //*************************************************************

    // Sends text to recipient
    private void send(Actor recipient, String text)
    {
        email.add(new Message(this, recipient, text));
    }

    // Announces subject to the list
    private void announce(String text)
    {
        send(null, text);
    }

    // Sends a reply to sender with the specified new subject
    private void reply(Actor actor, String text)
    {
        send(actor, text);
    }

    // Returns the number of times item occurs in myPossessions
    private int countPossessions(String item)
    {
        int count = 0;

        for (String str : myPossessions)
            if (item.equals(str))
                count++;

        return count;
    }

    // Checks whether this actor has one of each items
    private boolean allSet()
    {
        for (String item : items)
        {
            if (countPossessions(item) != 1)
                return false;
        }
        allSetFlag = true;
        return true;
    }
    
    
    //*************************************************************
    // Accessors for testing purposes only
    
    protected Collection<String> getMyPossessions()
    {
        return myPossessions;
    }
    
    protected Queue<Message> getMailbox()
    {
        return mailbox;
    }
    
    protected MailServer getEmail()
    {
        return email;
    }
    
    protected boolean getAllSetFlag()
    {
        return allSetFlag;
    }
}

