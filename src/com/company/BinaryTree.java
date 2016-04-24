package com.company;

import sun.rmi.server.InactiveGroupException;

import java.util.Stack;

/**
 * Created by siddharthmolleti on 1/8/16.
 */
public class BinaryTree<T extends Comparable<T>> {

    Node<T> root;

    BinaryTree() {
        root = null;
    }

    public boolean addNode(Node<T> nodeToAdd) {
        if (nodeToAdd == null) {
            throw new NullPointerException("Can't be null");
        }
        return addNode(root, nodeToAdd);
    }

    private boolean addNode(Node<T> node, Node<T> nodeToAdd) {
         if (node.compareTo(nodeToAdd) > 0) {
             if (node.right == null) {
                 node.right = nodeToAdd;
                 return true;
             } else {
                 return addNode(node.right, nodeToAdd);
             }
         } else {
             if (node.left == null) {
                 node.left = nodeToAdd;
                 return true;
             } else {
                 return addNode(node.left, nodeToAdd);
             }
         }
    }

    public void inOrderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.data);

    }

    public void visitNode(Node<T> node) {
        System.out.println(node.data);
    }

    public void inOrderTraversalIterative(Node<T> node) {
        Stack<Node<T>>  stack = new Stack<>();
        Node<T> current = node;
        while (!stack.empty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.println(current.data);
                current = current.right;
            }
        }
    }



    public boolean isBST(Node<T> node) {
       if (node == null) {
           throw new NullPointerException("Can't be null");
       }

       return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private boolean isBST(Node<T> node, int min, int max) {
        if (node == null) {
            return true;
        }
        if ((Integer)node.data > min
                && (Integer)node.data < max
                && isBST(node.left, min, (Integer)node.data)
                && isBST(node.right, (Integer)node.data, max)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBSTIterative(Node<T> node) {
        return false;
    }


    private class  Node<T extends Comparable<T>> implements Comparable<Node<T>> {

        Node<T> left;
        Node<T> right;
        T data;

        Node(T data) {
            left = right = null;
            this.data = data;
        }

        @Override
        public int compareTo(Node<T> otherNode) {
            return data.compareTo(otherNode.data);
        }
    }
}
