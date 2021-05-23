package com.company;

class BinarySearchTree< T extends Comparable<T>> {
    Node root;
    class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T value) {
        if(isEmpty())
            root = new Node(value);
        else
            insert(root, value);
    }

    private void insert(Node node, T value) {

        if(value.compareTo(node.data) < 0) {
            if(node.left == null)
                node.left = new Node(value);
            else
                insert(node.left, value);
        }
        else {
            if(node.right == null)
                node.right = new Node(value);
            else
                insert(node.right, value);
        }
    }

}

class Main{
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        System.out.println(bst.isEmpty());
        bst.insert(5);
        bst.insert(9);
        bst.insert(4);
        bst.insert(7);
        bst.insert(11);
        System.out.println(bst.isEmpty());
    }
}
