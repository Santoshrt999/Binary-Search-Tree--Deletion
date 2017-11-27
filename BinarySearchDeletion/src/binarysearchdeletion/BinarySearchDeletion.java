/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchdeletion;

/**
 *
 * @author Santosh Goteti
 */
class BinarySearchDeletion {

    Node root;

    public BinarySearchDeletion() {
        root = null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        BinarySearchDeletion bsd = new BinarySearchDeletion();

        System.out.println("In-order Traversal");
        bsd.insert(50);
        bsd.insert(30);
        bsd.insert(20);
        bsd.insert(45);
        bsd.insert(60);
        bsd.insert(50);
        bsd.insert(90);
        bsd.inorder();

        System.out.println("\n" + "Deleting 20, which is the leaf node from the Tree");
        bsd.delete(20);
        System.out.println("Inorder-Traversal after deleting node 20 is");
        bsd.inorder();
        System.out.println("\n" +"Deleting the node 60, which contains two children");
        bsd.delete(60);
        System.out.println("In-order traversal after deleting the node 60 is");
        bsd.inorder();
        System.out.println("");
        System.out.println("Go, on add the keys and play with it!");
        

    }

    //delete method,, to delete keys
    void delete(int key) {
        root = deleteRec(root, key);
    }
    //delete recursion method

    Node deleteRec(Node root, int key) {
        //if tree is empty return the root
        if (root == null) {
            return root;
        }

        //deleteing the leaf node based on the input
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } //deleting node when the parent has only one child.
        else {
            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //deleting node when the parent has two children(inorder traversal-> the samllest in the right sub-tree)   
            root.key = minValue(root.right);
            //delete the successor when it is placed and copied to the position of the deleted parent

            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    //method for calling the samllest element greater than the input node to be deleted
    int minValue(Node root) {
        int minval = root.key;
        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    //calls the insert recursion method
    void insert(int key) {
        // System.out.println(key);
        root = insertRec(root, key); //the problem is here
        // System.out.println("insert method "+root.key);
    }
//inserting recursion method inserting the elements based on the control structure conditions

    Node insertRec(Node root, int key) {

        //if tree empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
//inserting based on the BST properties and recur down
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    //calls inorder recursion method
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void inorder() {
        //  System.out.println(key);
        inorderRec(root);
    }

}
