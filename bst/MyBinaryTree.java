package bst;

public class MyBinaryTree<K extends Comparable<K>> {
    // Declaring a node
    private MyBinaryNode<K> root;

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
}