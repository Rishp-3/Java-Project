import java.util.*;

public class TreesDemo {

    static class Node {
        int value;
        Node left, right;
        Node(int value) { this.value = value; }
    }

    // Build a simple example binary tree manually
    static Node buildSampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        return root;
    }

    // Depth-first traversals
    static void inOrder(Node node, List<Integer> result) { // left, root, right
        if (node == null) return;
        inOrder(node.left, result);
        result.add(node.value);
        inOrder(node.right, result);
    }

    static void preOrder(Node node, List<Integer> result) { // root, left, right
        if (node == null) return;
        result.add(node.value);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    static void postOrder(Node node, List<Integer> result) { // left, right, root
        if (node == null) return;
        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(node.value);
    }

    // Breadth-first (level-order) traversal using a Queue
    static List<Integer> levelOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.value);
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        return result;
    }

    static int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        Node root = buildSampleTree();

        List<Integer> inOrderResult = new ArrayList<>();
        inOrder(root, inOrderResult);
        System.out.println("In-order: " + inOrderResult);

        List<Integer> preOrderResult = new ArrayList<>();
        preOrder(root, preOrderResult);
        System.out.println("Pre-order: " + preOrderResult);

        List<Integer> postOrderResult = new ArrayList<>();
        postOrder(root, postOrderResult);
        System.out.println("Post-order: " + postOrderResult);

        System.out.println("Level-order (BFS): " + levelOrder(root));
        System.out.println("Height of tree: " + height(root));
    }
}
