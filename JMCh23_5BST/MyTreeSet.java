import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements a BST with TreeNode nodes.
 * 
 * @author Rohan Chaudhary
 * @version 2-4-2025
 * @author Period - 2
 * @author Assignment - N/A
 * @author Sources - N/A
 */
public class MyTreeSet<E>
    implements Iterable<E>
{
    private TreeNode<E> root; // holds the root of this BST

    // Constructor: creates an empty BST.
    public MyTreeSet()
    {
        root = null;
    }


    // Returns true if this BST contains value; otherwise returns false.
    public boolean contains(E value)
    {
        return contains(root, value);
    }


    // Adds value to this BST, unless this tree already holds value.
    // Returns true if value has been added; otherwise returns false.
    public boolean add(E value)
    {
        if (contains(value))
            return false;
        root = add(root, value);
        return true;
    }


    // Removes value from this BST. Returns true if value has been
    // found and removed; otherwise returns false.
    public boolean remove(E value)
    {
        if (!contains(value))
            return false;
        root = remove(root, value);
        return true;
    }


    // Returns a string representation of this BST.
    public String toString()
    {
        String str = toString(root);
        if (str.endsWith(", "))
            str = str.substring(0, str.length() - 2);
        return "[" + str + "]";
    }


    // Returns an iterator for this BST.
    public Iterator<E> iterator()
    {
        MyTreeSetIterator iter = new MyTreeSetIterator(root);
        return iter;
    }

    // *************** Private helper methods: *********************


    // Returns true if the BST rooted at node contains value;
    // otherwise returns false (recursive version).
    private boolean contains(TreeNode<E> node, E value)
    {
        if (node == null)
            return false;
        else
        {
            int diff = ((Comparable<E>)value).compareTo(node.getValue());
            if (diff == 0)
                return true;
            else if (diff < 0)
                return contains(node.getLeft(), value);
            else // if (diff > 0)
                return contains(node.getRight(), value);
        }
    }

    /*
     * // Iterative version: private boolean contains(TreeNode<E> node, E value)
     * { while (node != null) { int diff = ( (Comparable<E>)value).compareTo(
     * node.getValue() ); if (diff == 0) return true; else if (diff < 0) node =
     * node.getLeft(); else // if (diff > 0) node = node.getRight(); } return
     * false; }
     */


    // Adds value to the BST rooted at node. Returns the
    // root of the new tree.
    // Precondition: the tree rooted at node does not contain value.
    private TreeNode<E> add(TreeNode<E> node, E value)
    {
        if (node == null)
            node = new TreeNode(value);
        else
        {
            int diff = ((Comparable<E>)value).compareTo(node.getValue());
            if (diff < 0)
                node.setLeft(add(node.getLeft(), value));
            else // if (diff > 0)
                node.setRight(add(node.getRight(), value));
        }
        return node;
    }


    // Removes value from the BST rooted at node.
    // Returns the root of the new tree.
    // Precondition: the tree rooted at node contains value.
    private TreeNode<E> remove(TreeNode<E> node, E value)
    {
        int diff = ((Comparable<E>)value).compareTo(node.getValue());
        if (diff == 0) // base case
            node = removeRoot(node);
        else if (diff < 0)
            node.setLeft(remove(node.getLeft(), value));
        else // if (diff > 0)
            node.setRight(remove(node.getRight(), value));
        return node;
    }


    // Removes the root of the BST rooted at root
    // replacing it with the smallest node from the right subtree.
    // Returns the root of the new tree.
    private TreeNode<E> removeRoot(TreeNode<E> root)
    {
        if (root.getRight() == null)
        {
            root = root.getLeft();
            return root;
        }
        TreeNode<E> node = root.getRight();
        Stack<TreeNode<E>> stk = new Stack<TreeNode<E>>();
        while (node.getLeft() != null)
        {
            stk.push(node);
            node = node.getLeft();
        }
        if (stk.isEmpty())
        {
            node.setLeft(root.getLeft());
            root = node;
            return root;
        }
        stk.pop().setLeft(node.getRight());
        node.setLeft(root.getLeft());
        node.setRight(root.getRight());
        root = node;
        return root;

    }


    // Utility routine to print the structure of the BST horizontally
    public void printHorizontal()
    {
        (new TreePrinter<E>(root)).printHorizontal();
    }


    // Utility routine to print the structure of the BST
    public void printSideways()
    {
        if (root == null)
            return;
        printSideways(root, 0);
    }


    // Precondition: original argument != null
    private void printSideways(TreeNode<E> t, int depth)
    {
        if (t.getRight() != null)
            printSideways(t.getRight(), depth + 1);

        process(t.getValue(), depth);

        if (t.getLeft() != null)
            printSideways(t.getLeft(), depth + 1);
    }


    // Simply display the toString version of my_data
    private void process(E obj, int depth)
    {
        for (int j = 1; j <= depth; j++)
            System.out.print("    ");
        System.out.println(obj.toString());
    }


    // Returns a string representation of the tree rooted at node.
    private String toString(TreeNode<E> node)
    {
        if (node == null)
            return "";
        else
            return toString(node.getLeft()) + node.getValue() + ", " + toString(node.getRight());
    }

    // Implements an Iterator for this tree.
    private class MyTreeSetIterator
        implements Iterator<E>
    {
        Stack<TreeNode<E>> stk;
        TreeNode<E>        tNode;

        public MyTreeSetIterator(TreeNode<E> root)
        {
            stk = new Stack<TreeNode<E>>();
            tNode = root;
            while (tNode != null)
            {
                stk.push(tNode);
                tNode = tNode.getLeft();
            }
        }


        public boolean hasNext()
        {
            return !stk.isEmpty();
        }


        public E next()
        {
            if (stk.isEmpty())
            {
                throw new NoSuchElementException();
            }
            tNode = stk.pop();
            E obj = tNode.getValue();
            tNode = tNode.getRight();
            while (tNode != null)
            {
                stk.push(tNode);
                tNode = tNode.getLeft();
            }
            return obj;
        }


        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    // ************************** main: **************************

    public static void main(String[] args)
    {
        String[] words =
            { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };
        MyTreeSet bst = new MyTreeSet();

        for (String word : words)
        {
            System.out.println("Added: " + word + " " + bst.add(word));
            System.out.println("Contains: " + word + " " + bst.contains(word));
            if (bst.add(word))
                System.out.println("*** Added a duplicate value ***");
            System.out.println(bst);
        }
        bst.printHorizontal();

        System.out.println("Traversal with an iterator:");
        for (Object obj : bst)
            System.out.print(obj + " ");
        System.out.println();

        for (String word : words)
        {
            System.out.println("Removed: " + word + " " + bst.remove(word));
            if (bst.remove(word))
                System.out.println("*** Removed a non-existent value ***");
            System.out.println(bst);
            bst.printHorizontal();
        }
    }
}
