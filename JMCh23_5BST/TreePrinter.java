import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreePrinter<E> {

    Map<TreeNode<E>, Integer> width;
    Map<TreeNode<E>, TreeNode<E>> pMap;
    Map<TreeNode<E>, Integer> endPos;
    TreeNode<E> root;

    public TreePrinter(TreeNode<E> root) {
        this.root = root;

        // generate map of the printed width of each node's sub-tree
        width = new HashMap<TreeNode<E>, Integer>();
        genWidthMap(root);

        // generate map of the parent of each node in the tree
        pMap = new HashMap<TreeNode<E>, TreeNode<E>>();
        genParentMap(root, null);

        // map of the "end position" of each node - the position of the last character in the printout of that node
        endPos = new HashMap<TreeNode<E>, Integer>();

    }

    public void printHorizontal() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        TreeNode<E> node = root;

        Queue<TreeNode<E>> nodeQ = new LinkedList<TreeNode<E>>();
        Queue<Integer> nodeLevel = new LinkedList<Integer>();

        nodeQ.add(node);
        nodeLevel.add(0);

        int startPos, sp;
        int lastEndPos = 0;
        int level = 0;
        String graphLines = "";
        String line = "";

        // Iterate by level from left to right using the nodeQ
        while (!nodeQ.isEmpty()) {
            node = nodeQ.remove();
            if (level != nodeLevel.peek()) {
                level += 1;
                lastEndPos = 0;
                if (level != 1) System.out.println(graphLines);
                System.out.println(line);
                graphLines = "";
                line = "";
            }
            level = nodeLevel.remove();

            // calculate starting printout position for the node's value
            startPos = leftParentEndPos(node);
            if (node.getLeft() != null) startPos += width.get(node.getLeft());

            sp = startPos - lastEndPos;

            int len = node.getValue().toString().length();
            if (isRightChild(node)) {
                graphLines += spaces(sp) + "\\" + spaces(len-1);
            } else {
                graphLines += spaces(sp + len-1 ) + "/";
            }
            line += spaces(sp) + node.getValue().toString();

            lastEndPos = startPos + node.getValue().toString().length();
            endPos.put(node, lastEndPos);

            if (node.getLeft() != null) {
                nodeQ.add(node.getLeft());
                nodeLevel.add(level + 1);
            }
            if (node.getRight() != null) {
                nodeQ.add(node.getRight());
                nodeLevel.add(level + 1);
            }

        }
        if (level != 0) System.out.println(graphLines);
        System.out.println(line);
    }

    // Create a string of n spaces
    public String spaces(int n) {
        StringBuffer outputBuffer = new StringBuffer(n);
        for (int i = 0; i < n; i++){
            outputBuffer.append(" ");
        }
        return outputBuffer.toString();
    }

    public boolean isRightChild(TreeNode<E> node) {
        return node != null && pMap.get(node) != null && node == pMap.get(node).getRight();
    }

    // find "first left parent"'s endPos
    public int leftParentEndPos(TreeNode<E> node) {
        while (node != null && !isRightChild(node)) {
            node = pMap.get(node);
        }
        if (node == null) return 0;
        return endPos.get( pMap.get(node) );
    }

    public void genWidthMap(TreeNode<E> node) {
        if (node == null) return;

        if (node.getLeft() != null) genWidthMap(node.getLeft());
        if (node.getRight() != null) genWidthMap(node.getRight());

        int w = 0;
        if (node.getLeft() != null) w += width.get(node.getLeft());
        if (node.getRight() != null) w += width.get(node.getRight());
        w +=  node.getValue().toString().length();

        width.put(node, w);
    }

    public void genParentMap(TreeNode<E> node, TreeNode<E> parent) {
        if (node == null) return;

        pMap.put(node, parent);

        if (node.getLeft() != null) genParentMap(node.getLeft(), node);
        if (node.getRight() != null) genParentMap(node.getRight(), node);
    } 
}
