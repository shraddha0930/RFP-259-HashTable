package bst;

public class MyBinaryTree<K extends Comparable<K>> {
    // Declaring a node
    public MyBinaryNode<K> root;
    Integer[] Value = {56,30,70,22,40,11,3,16,60,95,65,63,67};


    // Declaring  Add Method
    public void add(K key) {
        this.root = this.addRecusively(root, key);
    }

    // checking a node end
    private MyBinaryNode<K> addRecusively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }
        int compareResult = key.compareTo(current.key);

        if (compareResult == 0) return current;

        if (compareResult < 0) {
            current.left = addRecusively(current.left, key);
        } else {
            current.right = addRecusively(current.right, key);
        }

        return current;
    }
    //Printing the Binary Search Tree.
    public void traversal() {
        inorder(this.root);
    }

    // Utility function for inorder traversal of tree.
    public void inorder(MyBinaryNode<K> current) {
        if (current == null) {
            return;
        }

        inorder(current.left);
        System.out.print(current.key + " ");
        inorder(current.right);
    }
    //Calculating Height of BST
    public int calculateHeight(MyBinaryNode<K> current)
    {
        if (current == null)
        {
            return 0;
        }
        else
        {
            //Computing depth of each subtree
            int leftDepth = calculateHeight(current.left);
            int rightDepth = calculateHeight(current.right);

            if (leftDepth > rightDepth)
            {
                return (leftDepth + 1);
            }
            else
            {
                return (rightDepth + 1);
            }
        }
    }

    //Calculating the size of BST
    public void calculateSize()
    {
        System.out.println("The size of the Binary Search Tree is : "+size(root));
    }
    //Compute the size recursively
    public int size(MyBinaryNode<K> current)
    {
        if (current == null)
            return 0;
        else
            return (size(current.left) + 1 + size(current.right));
    }

    //Check all the elements from BST
    public boolean ifNodeExists( MyBinaryNode<K> current, K key)
    {
        if (current == null)
            return false;

        if (current.key == key)
            return true;

        // then search on left subtree
        boolean node1 = ifNodeExists(current.left, key);

        // node found, no need to look further
        if(node1)
            return true;

        // node is not found in left,
        // so search on right subtree
        boolean node2 = ifNodeExists(current.right, key);

        return node2;
    }
}