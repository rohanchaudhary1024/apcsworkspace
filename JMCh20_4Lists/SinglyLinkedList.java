import java.util.Iterator;

/**
    Implements a singly-linked list.
    
    @author  Rohan Chaudhary
    @version 12-14-2024
    
    @author  Period - 2
    @author  Assignment - Singly Linked List
    
    @author  Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;
    private int nodeCount;

    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }

    /**
        Constructor: creates a list that contains all elements from the
        array values, in the same order
        @param values  array containing all elements for this list
     */
    public SinglyLinkedList(E[] values)
    {
        ListNode<E> tail = null;
        for (E value : values) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>(value, null);
            if (head == null)
                head = node;
            else
                tail.setNext(node);
            tail = node;    // update tail
        }

        nodeCount = values.length;
    }

    /**
        Return true if this list is empty; otherwise returns false.
        @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
        Returns the number of elements in this list.
        @return  number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }

    /**
        Returns true if this list contains an Object equal to obj; otherwise returns false.
        @return true if this list contains an Object equal to obj
     */
    public boolean contains(Object obj)
    {

        ListNode<E> tail = head;
        if (tail != null) {
            if (tail.getValue() == obj) {
                return true;    
            }
            while (tail.getNext() != null) {
                tail = tail.getNext();
                if (tail.getValue() == obj) {
                    return true;
                }
            }
        }
        return false;  
    }

    /**
        Returns the index of the first Object equal to obj; if not found,
        returns -1.

        @param obj  Object to find
        @return  the index of the first Object in equal to obj; if not found,
                  returns -1.
     */
    public int indexOf(Object obj)
    {
        ListNode<E> tail = head;
        int count = 0;
        if (tail != null) {
            if (tail.getValue() == obj) {
                return count;    
            }
            while (tail.getNext() != null) {
                //System.out.println(tail.getValue());
                //System.out.println(count);
                tail = tail.getNext();
                count++;
                if (tail.getValue().equals(obj)) {
                    System.out.println(tail.getValue());
                    return count;
                }
            }
        }

        return -1;
    }

    /**
        Adds obj to this collection.  Returns true if successful;
        otherwise returns false.
        
        @param obj  element to add to this collection
        @return  true if successful; otherwise returns false.
     */
    public boolean add(E obj)
    {
        if (head != null) {
            ListNode<E> tail = head;
            while(tail.getNext() != null) {
                tail = tail.getNext();
            }
            tail.setNext(new ListNode<E>(obj, null));
            nodeCount++;
            return true;
        }
        else {
            head = new ListNode<E>(obj, null);
            nodeCount++;
            return true;
        }
    }

    /**
        Removes the first element that is equal to obj, if any.
        Returns true if successful; otherwise returns false.

        @param obj  element to remove
        @return  true if successful; otherwise returns false.
     */
    public boolean remove(E obj)
    {
        ListNode<E> tail = head;
        if (tail != null) {
            if (tail.getValue() == obj) {
                head = tail.getNext();
                return true;
            }
            while (tail.getNext() != null) {
                if (tail.getNext().getValue().equals(obj)) {
                    if (tail.getNext().getNext() == null) {
                        tail.setNext(null);
                        nodeCount--;
                        return true;
                    }
                    else {
                        tail.setNext(tail.getNext().getNext());
                        nodeCount--;
                        return true;
                    }
                }
                tail = tail.getNext();
            }
        }
        return false;  
    }

    /**
        Returns the i-th element.

        @param i  element to get from the list
        @return element at index i
        @throws IndexOutOfBoundsException 
     */
    public E get(int i)
    {
        if (i < 0 || i >= nodeCount) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        ListNode<E> tail = head;
        while (count < i) {
            //System.out.println(tail.getValue());
            tail = tail.getNext();
            count++;
        }
        return tail.getValue();
    }

    /**
        Replaces the i-th element with obj and returns the old value.
        
        @param i index of element to replace
        @param obj replacement element of element at index i
        @return old value previously located at index i
        @throws IndexOutOfBoundsException 
     */
    public E set(int i, E obj)
    {
        if (i < 0 || i >= nodeCount) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        ListNode<E> tail = head;
        ListNode<E> chaser = head;
        ListNode<E> newN = new ListNode<E>(obj, null);
        while (count < i) {
            if (count == i-1) {
                chaser = tail;
            }
            tail = tail.getNext();
            count++; 
        }
        chaser.setNext(newN);
        newN.setNext(tail.getNext());
        return tail.getValue();
    }

    /**
        Inserts obj to become the i-th element. Increments the size
        of the list by one.
        
        @param i  insertion point in list for obj
        @param obj element to insert into list
        @throws IndexOutOfBoundsException 
     */
    public void add(int i, E obj)
    {
        if (i < 0 || i > nodeCount) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            ListNode<E> newN = new ListNode<E>(obj, head);
            nodeCount++;
            head = newN;
        }
        else {
            int count = 0;
        ListNode<E> tail = head;
        ListNode<E> chaser = head;
        ListNode<E> newN = new ListNode<E>(obj, null);
        while (count < i) {
            if (count == i-1) {
                chaser = tail;
            }
            tail = tail.getNext();
            count++; 
        }
        nodeCount++;
        chaser.setNext(newN);
        newN.setNext(tail);
        }

    }

    /**
        Removes the i-th element and returns its value.
        Decrements the size of the list by one.

        @param i index of element to remove
        @return element removed from this list
     */
    public E remove(int i)
    {
        if (i < 0 || i >= nodeCount) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        ListNode<E> tail = head;
        ListNode<E> chaser = head;
        while (count < i) {
            if (count == i-1) {
                chaser = tail;
            }
            tail = tail.getNext();
            count++; 
        }
        chaser.setNext(tail.getNext());
        nodeCount--;
        return tail.getValue();
    }

    /**
        Returns a string representation of this list.
        @return  a string representation of this list.
     */
    public String toString()
    {
        String outputString = "[";
        ListNode<E> tail = head;
        outputString += head.getValue();
        while (tail.getNext() != null) {
            outputString += ", ";
            tail = tail.getNext();
            outputString += tail.getValue();
        }
        outputString += "]";
        return outputString;  // fix this
    }

    /**
        Returns an iterator for this collection.
        @return  an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>(head);
    }
}

