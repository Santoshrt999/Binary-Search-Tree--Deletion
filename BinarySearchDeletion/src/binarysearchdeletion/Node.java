/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchdeletion;

/**
 *
 * @author S528130
 */
//Node class for Binary Search Tree Strcuture
class Node { //the circular position

    int key; //elements
    Node left, right; //positions

    //constructor
    public Node(int item) {
        key = item;
        left = right = null;
    }
}
