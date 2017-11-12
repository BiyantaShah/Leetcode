package fullTime;

/**
 * Created by Biyanta on 13/10/17.
 */
public class AVLtree {

    Node root;

    static class Node {
        Node left, right;
        int data, height;

        Node(int key) {
            data = key;
            height = 1;
        }
    }

    public static void main (String[] args) {

        AVLtree tree =  new AVLtree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        tree.inorder(tree.root);
    }

    private void inorder(Node root) {

        if (root != null) {
            inorder(root.left);
            System.out.print( root.data + " ");
            inorder(root.right);
        }
    }

    private Node insert(Node root, int data) {

        if (root == null)
            root =  new Node(data);

        if (root.data > data)
            root.left = insert(root.left, data);

        else if (root.data < data)
            root.right = insert(root.right, data);

        else
            return root;

        root.height = 1 + Math.max (height(root.left), height(root.right));
        int balance = height(root.left) - height(root.right);

        if (balance > 1 && data < root.left.data)
            return rightRotate(root);

        if (balance < -1 && data > root.right.data)
            return leftRotate(root);

        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node leftRotate(Node root) {

        Node newNode  = root.right;
        root.right = newNode.left;

        newNode.left = root;
        root.height = 1 + Math.max(height(root.left), height(root.right));
        newNode.height = 1 + Math.max(height(newNode.left), height (newNode.right));

        return newNode;

    }

    private Node rightRotate(Node root) {

        Node newNode = root.left;
        root.left = newNode.right;

        newNode.right = root;

        root.height = 1 + Math.max(height(root.left), height(root.right));
        newNode.height = 1 + Math.max(height(newNode.left), height (newNode.right));

        return newNode;
    }

    private int height(Node node) {
        if (node == null)
            return 0;

        else return node.height;
    }
}
