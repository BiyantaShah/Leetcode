package fullTime;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BinaryTree {

    int result = 0;
    Node root;

    static class Node {
        Node left, right;
        int data;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main (String[] args) {

        BinaryTree bt = new BinaryTree();

        bt.root = new Node(5);
        bt.root.left  = new Node(4);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(2);
        bt.root.left.right = new Node(1);
        bt.root.right.left = new Node(6);
        bt.root.right.right = new Node (7);

        bt.leafNodes(bt.root);

//        int x = bt.findTilt(bt.root);
//        System.out.println(x);
//        bt.insert(1);
//        bt.insert(2);
//        bt.insert(3);
//        bt.insert(4);
//        bt.insert(5);
//        bt.insert(6);
//        bt.insert(7);

//        System.out.println("Inorder");
//        bt.inorder(bt.root);
//
//        System.out.println();
//        System.out.println("Preorder");
//        bt.preorder(bt.root);
//        System.out.println();
//        System.out.println("Postorder");
//        bt.postorder(bt.root);
//        System.out.println();
//
//        System.out.println("Nodes in the tree: "+ countNodes(bt.root));
//        System.out.println("Node 3 present in tree: " + bt.search(bt.root, 7));
    }

    private void leafNodes(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        while (!stack.isEmpty()) {

            Node node = stack.pop();
            if (node.left == null && node.right == null) {
                System.out.println(node.data + " ");
            }
            node = node.right;
            while (node != null){
                stack.push(node);
                node = node.left;
            }

        }
    }

    private int findTilt(Node root) {
        if (root == null)
            return 0;


        result =  Math.abs(findTilt(root.left) - findTilt(root.right));

        return  findTilt(root.left) + findTilt(root.right)+ root.data;
    }


    private void insert(int item) {
        
        root = insertItem(root, item);
    }

    private Node insertItem(Node node, int data) {

        if (node == null)
            node = new Node(data);
        else
        {
            if (node.left == null)
                node.left = insertItem(node.left, data);
            else
                node.right = insertItem(node.right, data);
        }
        return node;
    }

    private boolean search(Node node, int item) {

        if (node.data == item)
            return true;

        if (node.left != null) {
            if (search(node.left, item))
                return true;
        }
        if (node.right != null) {
            if (search(node.right, item))
            return true;
        }


        return false;
    }

    private static int countNodes(Node node) {
        int count  = 0;

        if (node == null)
            return count;

        else {
            count ++;
            count += countNodes(node.left);
            count += countNodes(node.right);

            return count;
        }

    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data +" ");
        }
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data +" ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    private void inorder(Node node) {

        if (node != null) {
            inorder(node.left);
            System.out.print(node.data +" ");
            inorder(node.right);
        }
    }

//    private void insert(int data) {
//
//        Node newNode = new Node(data);
//        if (root == null) {
//            root = newNode;
//            return;
//        }
//        Node current = root;
//        Node parent = null;
//
//        boolean x = false;
//
//        while (true) {
//
//            parent = current;
//
//            if (current.left == null) {
//                current.left = newNode;
//                return;
//            }
//            else if (current.right == null) {
//                current.right = newNode;
//                return;
//            }
//            else if (!x) {
//                current = current.left;
//                x = true;
//            }
//
//            else
//                current = current.right;
//        }
//
//
//
//    }

}