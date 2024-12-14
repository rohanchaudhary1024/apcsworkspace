import java.util.*;
import java.io.*;

/**
   Implements a recursive mergesort on a LinkedList data type

   @author  Rohan Chaudhary
   @version 12-9-2024

   @author Period - 2
   @author Assignment - AB27.1 MergeList

   @author Sources - N/A
 */
public class MergeList
{
    private Scanner inFile;
    private String myFile;

    /**
     * Open a file containing id/inventory pairs of data
     * 
     * @param fileName  File to be opened
     */
    public MergeList( String fileName )
    {
        myFile = fileName;
    }

    /**
     * Reads a file containing id/inv data pairs. The first line of the file
     * contains the number of id/inventory integer pairs listed on subsequent
     * lines.
     * 
     * @param list  Reference to LinkedList<Item> to which data will be added
     */
    public void readData( LinkedList<Item> list )
    {
        int id;
        int inv;

        try
        {
            inFile = new Scanner( new File( myFile ) );
            while ( inFile.hasNext() )
            {
                id = inFile.nextInt();
                inv = inFile.nextInt();
                list.addFirst( new Item( id, inv ) );
            }
        }
        catch ( IOException i )
        {
            System.out.println( "Error: " + i.getMessage() );
        }
    }

    /**
     * Prints contents of list
     * 
     * @param list  LinkedList<Item> to be printed
     */
    public void printList( LinkedList<Item> list )
    {
        Iterator<Item> iter = list.iterator();

        System.out.printf( "%5s%16s", "Id", "Inventory\n" );
        while ( iter.hasNext() )
        {
            Item temp = iter.next();
            System.out.printf( "%7d%10d\n", temp.getId(), temp.getInv() );
        }
        System.out.println();
    }

    /**
     * Splits listA into two parts. listA retains the first half of the list,
     * listB contains the last half of the original list.
     * 
     * @param listA  Original list. reduced by half after split.
     * @param listB  Contains last half of the original list
     */
    public void split( LinkedList<Item> listA, LinkedList<Item> listB )
    {
        ListIterator<Item> a = listA.listIterator(listA.size()/2);
        while (a.hasNext()) {
            listB.add((a.next()));
            a.remove();
        }
        /* 
        for (int i = 0; i < listA.size(); i++) {
            if (i > (listA.size()-1)/2) {
                listB.add(listA.get(i));
            }
        }

        int aS = listA.size();
        for (int i = 0; i < listB.size(); i++) {
            listA.remove(aS-1-i);
        }

        System.out.print("List Split: [ ");
        for (int i = 0; i < listA.size(); i++) {
            System.out.print(listA.get(i).getId() + ", ");
        }
        System.out.print(" ] , [ ");
        for (int i = 0; i < listB.size(); i++) {
            System.out.print(listB.get(i).getId() + ", ");
        }
        System.out.println("]");
        */


        
    }

    /**
     * Two linked lists listA and listB are merged into a single linked list
     * mergedList. They are placed in mergedList starting with the smallest item
     * on either list and continue working up to to largest item.
     * 
     * @param listA  LinkedList<Item> in nondecreasing order
     * @param listB  LinkedList<Item> in nondecreasing order
     * @return LinkedList<Item> containing all the values from lists listA
     *         and listB, in nondecreasing order
     */
    public LinkedList<Item> merge(
        LinkedList<Item> listA,
        LinkedList<Item> listB )
    {

        // make sure the target list is empty
        LinkedList<Item> mergedList = new LinkedList<Item>();
        ListIterator<Item> a = listA.listIterator();
        ListIterator<Item> b = listB.listIterator();
        Item aI;
        Item bI;
        while(a.hasNext() || b.hasNext()) {
            if (!a.hasNext()) {
                mergedList.add(b.next());
            }
            else if (!b.hasNext()) {
                mergedList.add(a.next());
            }
            else {
                aI = a.next();
                bI = b.next();
                if (aI.compareTo(bI) <= 0) {
                    mergedList.add(aI);
                    b.previous();
                }
                else {
                    mergedList.add(bI);
                    a.previous();
                }
            }
        }
        
        /* 
        int countA = 0;
        int countB = 0;
        int totalSize = listA.size() + listB.size();
        for (int i = 0; i < totalSize; i++) {
            if (countA == listA.size()) {
                mergedList.add(listB.get(countB));
                countB++;
            }
            else if (countB == listB.size()) {
                mergedList.add(listA.get(countA));
                countA++;
            }
            else {
                if (listA.get(countA).compareTo(listB.get(countB)) <= 0) {
                    mergedList.add(listA.get(countA));
                    countA++;
                }
                else {
                    mergedList.add(listB.get(countB));
                    countB++;
                }
            }
        }
        */
        return mergedList;
    }

    /**
     * The linked list is returned in sorted order. Sorted order has the smallest
     * item first and the largest item last. The ordering is determined by the
     * order defined in the Comparable class. The method uses the mergesort
     * technique and must be recursive.
     * 
     * @param listA  LinkedList<Item> to be sorted
     * @return LinkedList<Item> in sorted (nondecreasing) order
     */
    public LinkedList<Item> mergeSort( LinkedList<Item> listA )
    {
        LinkedList<Item> listB = new LinkedList<Item>();

        if ( listA == null )
        {
            return null;
        }

        // Don't sort an empty list or a list with one node
        if ( listA.size() <= 1 )
        {
            return listA;
        }

        // Split the list in half. If uneven then make left one larger.
        split( listA, listB );

        return merge( mergeSort( listA ), mergeSort( listB ) );
    }

    /**
     * Reverses the order of a list
     * 
     * @param list  LinkedList<Item> to be reversed
     * @return LinkedList<Item> in reverse order
     */
    public LinkedList<Item> reverseList( LinkedList<Item> list )
    {
        // Debug message for stub routine - remove when method is complete
        System.out.println( "reverseList" );

        LinkedList<Item> reversedList = new LinkedList<Item>();
        ListIterator<Item> a = list.listIterator(list.size());
        while (a.hasPrevious()) {
            reversedList.add(a.previous());
        }
        

        return reversedList;
    }
}
