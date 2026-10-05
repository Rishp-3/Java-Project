# Binary Tree in DSA

## 📌 Topic
Binary Tree me har node ke maximum 2 children hote hain (left aur right). Trees hierarchical data (file system, org chart) ko represent karte hain.

## 🎯 What You Will Learn

- Node, root, leaf, height
- Inorder, Preorder, Postorder traversal (DFS)
- Level Order traversal (BFS)
- Height aur nodes count

## 💻 Code

```java
import java.util.*;

public class Trees {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        System.out.print(n.val + " ");
        inorder(n.right);
    }

    static void preorder(Node n) {
        if (n == null) return;
        System.out.print(n.val + " ");
        preorder(n.left);
        preorder(n.right);
    }

    static void postorder(Node n) {
        if (n == null) return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.val + " ");
    }

    static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.val + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        System.out.println();
    }

    static int height(Node n) {
        if (n == null) return 0;
        return 1 + Math.max(height(n.left), height(n.right));
    }

    static int count(Node n) {
        return n == null ? 0 : 1 + count(n.left) + count(n.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Inorder: ");   inorder(root);   System.out.println();
        System.out.print("Preorder: ");  preorder(root);  System.out.println();
        System.out.print("Postorder: "); postorder(root); System.out.println();
        System.out.print("Level order: "); levelOrder(root);
        System.out.println("Height: " + height(root));
        System.out.println("Nodes: " + count(root));
    }
}
```

## 🧠 Explanation

### `Inorder`
Left, Root, Right. BST me ye sorted order deta hai.

### `Preorder / Postorder`
Root, Left, Right / Left, Right, Root. Tree copy aur delete me kaam aate hain.

### `Level Order`
Queue se level-by-level (BFS) visit karta hai.

### `height()`
Null ke liye 0, warna `1 + max(left, right)`.

## ▶️ Output

```text
Inorder: 4 2 5 1 3 
Preorder: 1 2 4 5 3 
Postorder: 4 5 2 3 1 
Level order: 1 2 3 4 5 
Height: 3
Nodes: 5
```

## 🔑 Important Points

- Traversals ka time O(n), recursion stack space O(h) (h = height).
- Full, Complete, Perfect, Balanced trees ke alag matlab hote hain.
- Recursion trees me natural fit hai kyunki subtree bhi ek tree hai.

## 📝 Practice

1. Tree ke leaf nodes count karo.
2. Tree ka mirror (invert) banao.
3. Do trees same hain ya nahi check karo.
4. Tree ka diameter nikalo.

## 🚀 Challenge

Check karo ki binary tree symmetric hai ya nahi.
