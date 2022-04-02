import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LazyBinarySearchTree
{
    private class TreeNode // Remember to RETURN this to PRIVATE
    {
        int key;
        TreeNode leftChild = null;
        TreeNode rightChild = null;
        boolean deleted = false;

        TreeNode(int in_key)
        {
            key = in_key;
        }
    }
    private TreeNode root = null; // RETURN this to PRIVATE
    public String ERROR_HOLDER = "";
    boolean insert(int key) throws IllegalArgumentException // Calls contains(key) to check if it EXISTS and NOT deleted
    {
        try
        {
            if (root == null)
            {
                root = new TreeNode(key);
                return true;
            } else if (contains(key))
            {
                return false;
            } else
            {
                return nodeInsert(key, root);
            }
        }
        catch(Exception IllegalArgumentException)
        {
            ERROR_HOLDER = "Error in insert: IllegalArgumentException raised";
        }
        return false;

    }
    private boolean nodeInsert(int key, TreeNode node)
    {
        if(key < 1 || key > 99)
        {
            throw new IllegalArgumentException();
        }
        // IF Node Children BOTH equals NULL -- place TreeNode with KEY into TREE.
        if(node.leftChild == null && node.rightChild == null)
        {
            if(node.key == key) // CASE where NODE may be children-less but ALREADY exists
            {
                if(node.deleted) // If ALREADY deleted, just FLIP.
                {
                    node.deleted = false;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            if(key < node.key)
            {
                node.leftChild = new TreeNode(key);
                return true;
            }
            if(key > node.key)
            {
                node.rightChild = new TreeNode(key);
                return true;
            }
            return true;
        }
        else if((key < node.key) && node.leftChild == null)
        {
            node.leftChild = new TreeNode(key);
            return true;
        }
        else if((key > node.key) && node.rightChild == null)
        {

            node.rightChild = new TreeNode(key);
            return true;
        }
        else if(node.key == key) // CASE where we FIND key EARLY
        {
            if(node.deleted) // If ALREADY deleted, just FLIP.
            {
                node.deleted = false;
                return true;
            }
            else
            {
                return false;
            }
        }

        // Otherwise, TRAVERSE BST
        if(key < node.key)
        {
            return nodeInsert(key, node.leftChild);
        }
        if(key > node.key)
        {
            return nodeInsert(key, node.rightChild);
        }
        return false;
    }

    public boolean delete(int key) throws IllegalArgumentException
    {
        try
        {
            if (root == null) // Saves A BIT of Memory
            {
                return false;
            }
            return nodeDeletion(key, root);
        }
        catch(Exception IllegalArgumentException)
        {
            ERROR_HOLDER = "Error in delete: IllegalArgumentException raised";
        }
        return false;
    }

    private boolean nodeDeletion(int key, TreeNode node) // TRUE if can be FLIPPED. False if
    {
        if(key < 1 || key > 99)
        {
            throw new IllegalArgumentException();
        }
        if(node == null)
        {
            return false;
        }
        if(key < node.key)
        {
            return nodeDeletion(key, node.leftChild);
        }
        if(key > node.key)
        {
            return nodeDeletion(key, node.rightChild);
        }
        if(key == node.key)
        {
            if(node.deleted)
            {
                return false;
            }
            else
            {
                node.deleted = true;
                return true;
            }
        }
        return false;
    }

    public int findMin()
    {
        if(root == null) // If BST is EMPTY
        {
            return -1;
        }

        TreeNode parsed = root;
        Stack<TreeNode> minStack = new Stack<TreeNode>(); // Stack to STORE Non-Deleted Items

        while(parsed.leftChild != null)
        {
            if(!parsed.deleted)
            {
                minStack.push(parsed);
            }
            parsed = parsed.leftChild;
        }

        if(!parsed.deleted) // Last Element
        {
            minStack.push(parsed);
        }
        return minStack.pop().key;
    }

    public int findMax() // Same as findMin() EXCEPT we are traversing the RIGHT subtree
    {
        if(root == null) // If BST is EMPTY
        {
            return -1;
        }

        TreeNode parsed = root;
        Stack<TreeNode> minStack = new Stack<TreeNode>(); // Stack to STORE Non-Deleted Items

        while(parsed.rightChild != null)
        {
            if(!parsed.deleted)
            {
                minStack.push(parsed);
            }
            parsed = parsed.rightChild;
        }

        if(!parsed.deleted) // Last Element
        {
            minStack.push(parsed);
        }
        return minStack.pop().key;

    }

    public boolean contains(int key) throws IllegalArgumentException
    {
        try
        {
            if (root == null)
            {
                return false;
            }
            return containsNode(key, root);
        }
        catch(Exception IllegalArgumentException)
        {
            ERROR_HOLDER = "Error in contains: IllegalArgumentException raised";
        }
        return false;
    }

    private boolean containsNode(int key, TreeNode node) // Returns BOTH that the element exists and is not deleted.
    {
        if(key < 1 || key > 99)
        {
           throw new IllegalArgumentException();
        }
        if(node == null)
        {
            return false;
        }
        if(key < node.key)
        {
            return containsNode(key, node.leftChild);
        }
        if(key > node.key)
        {
            return containsNode(key, node.rightChild);
        }
        if(node.deleted) // Reaches here if found EQUAL.
        {
            return false;
        }
        return true; // NOT Deleted && key exists
    }

    @Override
    public String toString()
    {
        String Tree = "";
        List<String> temp = preorderTraversal(root);
        for(String holder: temp)
        {
            Tree = Tree + " " + holder;
        }
        Tree = Tree.substring(1); // Gets rid of the extra initial space
        return Tree;
    }
    private List<String> preorderTraversal (TreeNode root)
    {
        List<String> temp = new ArrayList<String>();
        if(root == null)
        {
            return temp;
        }
        if(root.deleted)
        {
            temp.add("*" + root.key);
        }
        else
        {
            temp.add(Integer.toString(root.key));
        }

        temp.addAll(preorderTraversal(root.leftChild));
        temp.addAll(preorderTraversal(root.rightChild));
        return temp;
    }

    public int height()
    {
        return findHeight(root)-1;
    }

    private int findHeight(TreeNode node)
    {
       if(node == null)
       {
           return 0;
       }

       int leftNodeHeight = findHeight(node.leftChild) + 1;
       int rightNodeHeight = findHeight(node.rightChild) + 1;
       if(leftNodeHeight > rightNodeHeight)
       {
           return leftNodeHeight;
       }
       return rightNodeHeight;
    }

    public int size()
    {
        return findSize(root);
    }

    private int findSize(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        return findSize(node.leftChild) + findSize(node.rightChild) + 1;
    }

}
