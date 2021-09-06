package tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private Node root;

    public void insert(int value) {
        final Node node = new Node(value);
        if (this.root == null) {
            this.root = node;
            return;
        }

        //find where to insert the new value
        Node current = this.root; //7
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = this.root;
        //if root is null, skip loop
        while (current != null) {
            if (value < current.value) { //visit left subtree
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild; //visit right subtree
            } else {
                return true; // current is the correct node
            } //if not, current will be null
        }
        //current is null
        return false;
    }

    public int height() {
        return height(root);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    //find min in BST, find left most leaf O(logn)
    public int findLeftMostLeaf(Node root) {
        if (root == null) {
            throw new IllegalStateException();
        }

        Node current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current.value;
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    private int min(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public List<Integer> getNodesAtDistance(int distance) {
        List<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int k, List<Integer> list) {
        if (root == null) return;

        if (k == 0) {
            list.add(root.value);
            System.out.println(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, k - 1, list);
        getNodesAtDistance(root.rightChild, k - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            System.out.println(getNodesAtDistance(i));
        }
    }

}
