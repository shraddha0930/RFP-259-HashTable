package bst;

public class BinaryMain {
    public static void main(String[] args) {

        MyBinaryTree binary = new MyBinaryTree<>();

//        binary.add(56);
//        binary.add(30);
//        binary.add(70);
//Adding values to BST
        for (int i = 0; i < binary.Value.length; i++) {
            binary.add(binary.Value[i]);
        }
        binary.traversal();
        //Calculating the size of BST
        binary.calculateSize();

        //Calculating the height of BST
        System.out.println("The height of the BST is : " + binary.calculateHeight(binary.root));

        //Checking if all values are present in BST
        boolean[] flag = new boolean[binary.Value.length];
        for (int i = 0; i < binary.Value.length; i++) {
            flag[i] = binary.ifNodeExists(binary.root, binary.Value[i]);
            System.out.println(binary.Value[i] + " is present |  " + flag[i]);
        }
    }
}
