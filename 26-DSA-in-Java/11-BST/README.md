# Binary Search Tree (BST) in DSA

## 📌 Topic
BST me har node ke left subtree ke saare values chhote aur right subtree ke saare values bade hote hain. Isse search, insert, delete average O(log n) me hote hain.

## 🎯 What You Will Learn

- BST property
- Insert aur Search
- Min/Max aur Inorder (sorted output)
- Delete (3 cases)

## 💻 Code

```java
public class Bst {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        return root;
    }

    static boolean search(Node root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        return val < root.val ? search(root.left, val) : search(root.right, val);
    }

    static int min(Node root) {
        while (root.left != null) root = root.left;
        return root.val;
    }

    static Node delete(Node root, int val) {
        if (root == null) return null;
        if (val < root.val) root.left = delete(root.left, val);
        else if (val > root.val) root.right = delete(root.right, val);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = min(root.right);
            root.right = delete(root.right, root.val);
        }
        return root;
    }

    static void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        System.out.print(n.val + " ");
        inorder(n.right);
    }

    public static void main(String[] args) {
        Node root = null;
        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80}) root = insert(root, v);

        System.out.print("Inorder: "); inorder(root); System.out.println();
        System.out.println("Search 60: " + search(root, 60));
        System.out.println("Search 65: " + search(root, 65));
        System.out.println("Min: " + min(root));

        root = delete(root, 30);
        System.out.print("After deleting 30: "); inorder(root); System.out.println();
        root = delete(root, 50);
        System.out.print("After deleting 50: "); inorder(root); System.out.println();
    }
}
```

## 🧠 Explanation

### `insert`
Chhota ho to left, bada ho to right me jata hai. Duplicate ignore kiya gaya hai.

### `search`
Har step par aadha tree chhod deta hai, isliye balanced BST me O(log n).

### `delete: 3 cases`
1) Leaf: seedha hata do. 2) Ek child: child ko upar le aao. 3) Do children: right subtree ka minimum (inorder successor) se replace karo.

### `inorder`
BST ka inorder hamesha sorted aata hai.

## ▶️ Output

```text
Inorder: 20 30 40 50 60 70 80 
Search 60: true
Search 65: false
Min: 20
After deleting 30: 20 40 50 60 70 80 
After deleting 50: 20 40 60 70 80 
```

## 🔑 Important Points

- Sorted input (1, 2, 3, ...) dene par BST ek linked list ban jata hai: O(n). Balanced trees (AVL, Red-Black) isse bachate hain.
- Java ka `TreeMap`/`TreeSet` Red-Black Tree hi hai.
- BST validate karne ke liye min/max range pass karo.

## 📝 Practice

1. BST ka maximum nikalo.
2. BST me k-th smallest element nikalo.
3. Do nodes ka Lowest Common Ancestor nikalo.
4. Check karo ki diya hua tree valid BST hai ya nahi.

## 🚀 Challenge

Sorted array se height-balanced BST banao.
