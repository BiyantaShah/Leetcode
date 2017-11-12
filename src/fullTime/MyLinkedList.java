package fullTime;

import java.util.Scanner;

/**
 * Created by Biyanta on 14/09/17.
 */
public class MyLinkedList {
    int size;
    Node start, end;

    MyLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    static class Node {

        int data;
        Node next;

        Node (int item) {
            data = item;
            next = null;
        }

    }

    public static void main(String[] args) {

        MyLinkedList ll = new MyLinkedList();
        Boolean x = true;
        Scanner sc = new Scanner(System.in);
        outerLoop:
        while(true) {
            System.out.println("Choose an option:\n 1.InsertStart \n 2.InsertEnd \n 3.InsertMid \n 4.DeleteStart \n"+
                    " 5.DeleteEnd\n 6. DeleteMid\n 7.Size \n 8.Quit");
            int option = sc.nextInt();

            switch (option) {
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
                    System.out.println("Size and the linkedlist:");
                    printAndSize(ll);
                    break;
                }

                case 8: {

                    break outerLoop;
                }

            }
        }

        }

    private static void deleteMid(MyLinkedList ll) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter index to delete at: ");
        int pos = sc.nextInt();
        if(pos == ll.size-1) {
            deleteEnd(ll);
        }
        Node temp = ll.start;

        for (int i = 0; i < ll.size; i++) {

            if (i == pos-1) {
                System.out.println("Node to be deleted "+ temp.next.data);
                temp.next = temp.next.next;
                ll.size--;
                break;
            }

            temp = temp.next;
        }

    }

    private static void deleteEnd(MyLinkedList ll) {
        if (ll.size == 0) {
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = ll.start;
        Node prev= ll.start;
        Node ptr = ll.start;

        while (ptr != ll.end) {
            temp = ptr;
            prev = temp;
            temp = temp.next;
            ptr = ptr.next.next;
        }
        prev.next = temp;
        ll.end = temp;
        ll.end.next = null;

        ll.size --;

    }

    private static void deleteStart(MyLinkedList ll) {

        if (ll.size == 0) {
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = ll.start;
        ll.start = ll.start.next;
        temp.next = null;
        ll.size --;
    }

    private static void insertMid(MyLinkedList ll) {
        System.out.println("Enter element to insert: ");
        Scanner sc = new Scanner(System.in);
        int elem = sc.nextInt();

        Node node = new Node(elem);
        System.out.println("Enter index to insert at: ");
        int pos = sc.nextInt();

        Node temp = ll.start;
        for (int i = 0 ; i < ll.size; i++) {

            if (i == pos-1) {
                Node ptr = temp.next;
                temp.next = node;
                node.next = ptr;
                ll.size++;
                break;

            }
            temp = temp.next;

        }




    }

    private static void printAndSize(MyLinkedList ll) {

        System.out.println("Size is : " +ll.size);
        Node node = ll.start;

        while (node != null) {
            System.out.print(node.data + " ");
            node= node.next;
        }
        System.out.println();
    }

    private static void insertAtEnd(MyLinkedList ll) {
        System.out.println("Enter element to insert: ");
        Scanner sc = new Scanner(System.in);
        int elem = sc.nextInt();

        Node node = new Node(elem);

        if (ll.start == null) {
            ll.start = node;
            ll.end = ll.start;
            ll.size ++;
        }
        else {
            ll.end.next = node;
            ll.end = node;
            ll.size++;
        }


    }

    private static void insertAtStart(MyLinkedList ll) {
        System.out.println("Enter element to insert: ");
        Scanner sc = new Scanner(System.in);
        int elem = sc.nextInt();

        Node node = new Node(elem);

        if (ll.start == null) {
            ll.start = node;
            ll.end = ll.start;
            ll.size ++;
        }
        else {
            node.next = ll.start;
            ll.start = node;
            ll.size ++;
        }
    }

}
