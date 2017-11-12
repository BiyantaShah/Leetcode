package fullTime;

import java.util.Scanner;

/**
 * Created by Biyanta on 14/09/17.
 */
public class Queues {
    int front,rear, len, size;
    int[] myQueue;

    Queues(int n) {
        size  = n;
        myQueue = new int[n];
        front = -1;
        rear = -1;
        len = 0;
    }


    public static void main (String[] args) {

        System.out.println("Enter size of queue ");
        Scanner sc = new Scanner(System.in);
        Queues queue = new Queues(sc.nextInt());

        outerLoop:
        while(true) {
            System.out.println("Choose an option: 1.Enqueue \n 2.Dequeue \n 3.Peek \n 4.Size \n 5.Quit");
            int option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("addding an element");
                    queue.enqueue(queue.myQueue);
                    break;
                }
                case 2: {
                    System.out.println("Removing the first element added");
                    queue.dequeue(queue.myQueue);
                    break;
                }
                case 3: {
                    System.out.println("Showing you the top most element of the queue:");
                    queue.peek(queue.myQueue);
                    break;
                }

                case 4: {
                    System.out.println("Size of the queue is :");
                    queue.queuePrint(queue.myQueue);
                    break;
                }
                case 5 : {
                    break outerLoop;
                }


            }
        }

    }

    private void peek(int[] myQueue) {
        if (front == -1) {
            System.out.println("Underflow");
            return;
        }
        System.out.println("Element at the front of the queue "+myQueue[front]);
    }

    private void dequeue(int[] myQueue) {

        if (front == -1) {
            System.out.println("Underflow");
            return;
        }
        len --;
        int elem = myQueue[front];
        System.out.println("Element dequed "+elem);
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else
            front++;
    }

    private void queuePrint(int[] myQueue) {

        System.out.println("Size is "+ len);

        for (int i = front ; i <= rear; i++) {
            System.out.print(myQueue[i] + " ");
        }
    }

    private void enqueue(int[] myQueue) {
        System.out.println("Enter item to enqueue: ");
        Scanner sc = new Scanner(System.in);
        int elem = sc.nextInt();

        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            myQueue[rear] = elem;
        }
        else if (rear+1 >= size) {
            System.out.println("Overflow");
            return;
        }
        else
            myQueue[++rear] = elem;

        len++;
    }

}
