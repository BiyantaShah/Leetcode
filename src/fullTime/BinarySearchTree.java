package fullTime;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Biyanta on 15/09/17.
 */
public class BinarySearchTree {

    Node root;

    class Node {
        Node left, right;
        int data;

        Node(int item) {
            data = item;
            right = left = null;

        }
    }

    public static void main (String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.root = bst.insert(bst.root, 10);
        bst.insert(bst.root, 5);
        bst.insert(bst.root, 4);
        bst.insert(bst.root, 6);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 15);



        findSecondLargest(bst.root, 2);


//        bst.inorder(bst.root);
//        System.out.println();
//        bst.inorderIterative(bst.root);
//        System.out.println();
//
//        System.out.println("preorder");
//        bst.preorder(bst.root);
//        System.out.println();
//        bst.preorderIterative(bst.root);
//        System.out.println();
//
//        System.out.println("Postorder");
//        bst.postorder(bst.root);
//        System.out.println();
//        bst.postorderIterative(bst.root);
//        System.out.println();

//        System.out.println(bst.countNodes(bst.root) +" nodes");
//        System.out.println();
//        System.out.println(bst.search(null, 9));
//        bst.root = bst.delete(bst.root, 4);
//        bst.inorder(bst.root);
//        System.out.println();
//        System.out.println(bst.countNodes(bst.root) +" nodes");

    }

    private static void findSecondLargest(Node root, int k) {

        Stack<Node> stack = new Stack<>();

        Node current = root;

        while(current != null) {
            stack.push(current);
            current = current.right;
        }
        int count = 0;

        while (!stack.isEmpty()){

            current = stack.pop();
            count ++;
            if (count == k) {
                System.out.println(current.data);
                return;
            }

            current = current.left;
            while (current != null) {
                stack.push(current);
                current = current.right;
            }
        }


    }

    private void postorder(Node root) {

        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

//    private static void postOrder(Node root) {
//        Set<Node> visited = new HashSet<>();
//        Stack <Node> stack = new Stack <Node>();
//
//        Node cur = root;
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.left;
//        }
//
//        while (!stack.isEmpty()) {
//            cur = stack.peek();
//            if ((cur.right == null && cur.left ==  null) ||
//                    (visited.contains(cur.right) && visited.contains(cur.left))) {
//                cur = stack.pop();
//                System.out.print(cur.data +" ");
//                visited.add(cur);
//            }
//            else if (cur.right  == null && visited.contains(cur.left)) {
//                cur = stack.pop();
//                System.out.print(cur.data +" ");
//                visited.add(cur);
//            }
//            else if (cur.left == null && visited.contains(cur.right)) {
//                cur = stack.pop();
//                System.out.print(cur.data +" ");
//                visited.add(cur);
//            }
//            else {
//                if (cur.right != null && !visited.contains(cur.right)) stack.push(cur.right);
//                if (cur.left != null && !visited.contains(cur.left)) stack.push(cur.left);
//
//            }
//        }
//    }

    private void postorderIterative(Node root) {

        Stack<Node> stack = new Stack<>();

        Node prev = null;
        Node current = root;
        stack.push(current);

        while (!stack.isEmpty()) {

            current = stack.peek();

            if (prev == null || prev.left == current || prev.right == current) {

                if (current.left != null)
                    stack.push(current.left);
                else if (current.right != null)
                    stack.push(current.right);
                else {
                    stack.pop();
                    System.out.print(current.data + " ");
                }

            }

            else if (current.left == prev) {
                if (current.right != null)
                    stack.push(current.right);
                else {
                    stack.pop();
                    System.out.println(current.data + " ");
                }

            }
            else if (current.right  == prev) {
                stack.pop();
                System.out.println(current.data + " ");
            }

            prev = current;
        }
    }

    private void preorder(Node root) {

        if (root != null) {
            System.out.print(root.data +" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void preorderIterative(Node root) {

        Stack<Node> stack = new Stack<>();

        Node current = root;


        stack.push(current);

        while (!stack.isEmpty()) {

            current = stack.pop();
            System.out.print(current.data + " ");
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

        }
    }

    private void inorderIterative(Node root) {

        Stack<Node> stack = new Stack<Node>();

        Node current  = root;

        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        while (!stack.empty()) {
            current = stack.pop();
            System.out.print(current.data +" ");
            current = current.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

    }

    private Node delete(Node node, int item) {

        if (node == null)
            return node;

        if (node.data > item)
            node.left = delete(node.left, item);
        else if (node.data < item)
            node.right = delete(node.right, item);

        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            else {
                int inorderSuccessor = minValue(node.right);
                node.right = delete(node.right, inorderSuccessor);
            }
        }
        return node;
    }

    private int minValue(Node node) {

        int min = node.data;

        if (node.left != null) {
            min = node.left.data;

            minValue(node.left);
        }

            return min;
    }

    private int countNodes(Node root) {
        int l = 0;
        if (root == null) {
            return 0;
        }
        else {
            l++;
            l += countNodes(root.left);
            l += countNodes(root.right);
        }
        return l;

    }

    private boolean search(Node root, int key) {

        if (root.data == key)
            return true;

        if (root.data > key && root.left != null) {
            if (search(root.left, key))
                return true;
        }

        if (root.data < key && root.right != null) {
            if (search(root.right, key))
                return true;
        }

        return false;
    }

    private void inorder(Node root) {

        if (root != null) {
            inorder(root.left);
            System.out.print(root.data +" ");
            inorder(root.right);
        }
    }

    private Node insert(Node root, int item) {

        Node newNode = new Node(item);

        if (root == null) {
            root = newNode;
            return root;
        }

        if (item < root.data)
            root.left = insert(root.left, item);
        else if (item > root.data)
            root.right = insert(root.right, item);


        return root;
    }
}
