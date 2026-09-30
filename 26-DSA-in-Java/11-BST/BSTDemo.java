import java.util.ArrayList;
import java.util.List;

public class BSTDemo {

    // Binary Search Tree: left subtree < node < right subtree, for every node
    static class Node {
        int value;
        Node left, right;
        Node(int value) { this.value = value; }
    }

    static class BST {
        Node root;

        void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node node, int value) {
            if (node == null) return new Node(value);
            if (value < node.value) {
                node.left = insertRec(node.left, value);
            } else if (value > node.value) {
                node.right = insertRec(node.right, value);
            }
            return node;
        }

        boolean search(int value) {
            return searchRec(root, value);
        }

        private boolean searchRec(Node node, int value) {
            if (node == null) return false;
            if (node.value == value) return true;
            return value < node.value ? searchRec(node.left, value) : searchRec(node.right, value);
        }

        // In-order traversal of a BST always visits nodes in SORTED order
        List<Integer> inOrderSorted() {
            List<Integer> result = new ArrayList<>();
            inOrderRec(root, result);
            return result;
        }

        private void inOrderRec(Node node, List<Integer> result) {
            if (node == null) return;
            inOrderRec(node.left, result);
            result.add(node.value);
            inOrderRec(node.right, result);
        }

        int findMin() {
            Node current = root;
            while (current.left != null) current = current.left;
            return current.value;
        }

        int findMax() {
            Node current = root;
            while (current.right != null) current = current.right;
            return current.value;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) tree.insert(v);

        System.out.println("In-order (sorted): " + tree.inOrderSorted());
        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Search 100: " + tree.search(100));
        System.out.println("Min value: " + tree.findMin());
        System.out.println("Max value: " + tree.findMax());
    }
}
