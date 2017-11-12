package fullTime;

import java.util.Scanner;

/**
 * Created by Biyanta on 14/09/17.
 */
public class DoublyLinkedList {
    int size;
    Node start, end;

    DoublyLinkedList () {
        size = 0;
        start = null;
        end = null;
    }

    static class Node {
        int data;
        Node next, prev;

        Node (int item) {
            data = item;
            next = null;
            prev = null;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList ll = new DoublyLinkedList();
        Boolean x = true;
        Scanner sc = new Scanner(System.in);
        outerLoop:
        while(true) {
            System.out.println("Choose an option for doubly Linked List:\n 1.InsertStart \n 2.InsertEnd \n 3.InsertMid \n 4.DeleteStart \n"+
                    " 5.DeleteEnd\n 6.DeleteMid\n 7.Size \n 8.Quit");
            int optn = sc.nextInt();

            switch (optn) {
                case 1: {
                    System.out.println("Inserting at Start");
                    insertAtStart(ll);
                    break;
                }
                case 2: {
                    System.out.println("Insert at End");
                    insertAtEnd(ll);
                    break;
                }
                case 3: {
                    System.out.println("Insert in the middle");
                    insertMid(ll);
                    break;
                }

                case 4: {
                    System.out.println("Deleting from start");
                    deleteStart(ll);
                    break;
                }

                case 5: {
                    System.out.println("Delete from end");
                    deleteEnd(ll);
                    break;
                }

                case 6: {
                    System.out.println("delete from mid");
                    deleteMid(ll);
                    break;
                }
                case 7: {
                    System.out.println("Printed List:");
                    printAndSize(ll);
                    break;
                }

                case 8: {
                    break outerLoop;
                }

            }
        }

    }

    private static void printAndSize(DoublyLinkedList ll) {
        System.out.println("Size of the linked list : "+ll.size);

        Node node = ll.start;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

    }
    private static void deleteMid(DoublyLinkedList ll) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index to delete at: ");
        int pos = sc.nextInt();

        if (pos == 0) {
            deleteStart(ll);
            return;
        }

        if (pos == ll.size-1) {
            deleteEnd(ll);
            return;
        }
        Node temp = ll.start;
        for (int i = 0; i < ll.size; i++) {

            if (i == pos-1) {
                Node ptr = temp.next;
                System.out.println("to be deleted "+ ptr.data);

                temp.next = ptr.next;
                ptr.next.prev = temp;
                ll.size --;
                break;
            }
            temp = temp.next;
        }
    }
    private static void deleteStart(DoublyLinkedList ll) {

        if (ll.size == 0) {
            System.out.println("List is empty");
            return;
        }

        ll.start = ll.start.next;
        ll.start.prev = null;
        ll.size--;


    }
    private static void deleteEnd(DoublyLinkedList ll) {

        if (ll.size == 0) {
            System.out.println("List is empty");
            return;
        }

        Node temp = ll.start;
        while (temp != ll.end) {
            temp = temp.next;
        }
        ll.end = temp.prev;
        ll.end.next = null;
        ll.size--;
    }
    private static void insertMid(DoublyLinkedList ll) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item to insert: ");
        int elem = sc.nextInt();

        Node node = new Node(elem);

        System.out.println("Enter index to insert at: ");
        int pos = sc.nextInt();
        Node temp = ll.start;

        if (pos == 0) {
            insertAtStart(ll);
            return;
        }

        for (int i = 0; i < ll.size; i++) {

            if (i == pos-1) {
                Node ptr = temp.next;
                ptr.prev = node;
                node.next = ptr;
                node.prev = temp;
                temp.next = node;
                ll.size ++;
                break;
            }
            temp = temp.next;
        }
    }

    private static void insertAtEnd(DoublyLinkedList ll) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item to insert: ");
        int elem = sc.nextInt();

        Node node = new Node(elem);

        if (ll.start == null) {

            ll.end = node;
            ll.start = ll.end;
            ll.size++;
        }
        else {
            Node temp = ll.start;
            while (temp != null) {
                temp = temp.next;
            }
            temp = node;
            ll.end.next = temp;
            temp.prev = ll.end;
            temp.next = null;
            ll.end = temp;

            ll.size++;
        }

    }
    private static void insertAtStart(DoublyLinkedList ll) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item to insert: ");
        int elem = sc.nextInt();

        Node node = new Node(elem);

        if (ll.start == null) {

            ll.start = node;
            ll.end = ll.start;
            ll.size++;
        }
        else {
            ll.start.prev = node;
            node.next = ll.start;
            ll.start = node;
            ll.size++;
        }
    }
}
