public class LazyBinarySearchTree
{
    private class TreeNode
    {
        int key;
        TreeNode leftChild = null;
        TreeNode rightChild = null;
        boolean deleted = false;

        TreeNode(int in_key)
        {
            key = in_key;
        }
        TreeNode(int in_key, TreeNode leftNode, TreeNode rightNode)
        {
            leftChild = leftNode;
            rightChild = rightNode;
        }
        boolean isDeleted()
        {
            return deleted;
        }
        int getKey()
        {
            return key;
        }
        TreeNode getLeftChild()
        {
            return leftChild;
        }
        TreeNode getRightChild()
        {
            return rightChild;
        }
    }

    private TreeNode root = null;
    boolean insert(int key) throws IllegalArgumentException
    {
        return false;
    }

    public boolean delete(int key) throws IllegalArgumentException
    {
        return false;
    }

    public int findMin()
    {
        return 0;
    }

    public int findMax()
    {
        return 0;
    }

    public boolean contains(int key)
    {
        return false;
    }

    @Override
    public String toString()
    {
        return "";
    }

    public int height()
    {
        return 0;
    }

    public int size()
    {
        return 0;
    }

}
