package fullTime;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

/**
 * Created by Biyanta on 14/09/17.
 */
public class Stacks {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of your stack: ");
        int size = sc.nextInt();

        int[] myStack = new int[size];

        boolean x = true;

        while(x = true) {
            System.out.println("Choose an option: 1.Push \n 2.Pop \n 3.Peek \n 4.Size");
            int option = sc.nextInt();

            switch(option) {
                case 1: {
                    System.out.println("Pushing an element");
                    push(myStack);
                    break;
                }
                case 2: {
                    System.out.println("Popping");
                    pop(myStack);
                    break;
                }
                case 3: {
                    System.out.println("Showing you the top most element of the stack:");
                    peek(myStack);
                    break;
                }

                case 4: {
                    System.out.println("Size of the stack is :");
                    stackSize(myStack);
                    break;
                }
                default: {
                    x = false;
                    break;

                }

            }

        }
    }

    private static void stackSize(int[] myStack) {
        int size = 0;

        for (int i = 0; i <myStack.length; i++) {
            if (myStack[i] != 0)
                size ++;
        }
        System.out.println(size);
    }

    private static void peek(int[] myStack) {
        if (myStack[0] == 0){
            System.out.println("Stack is empty");
            return;
        }
        int index = 0;
        for (int i = 0; i <myStack.length; i++) {
            if (myStack[i] != 0)
                index ++;
        }
        System.out.println(myStack[--index]);
    }

    private static void pop(int[] myStack) {
        if (myStack[0] == 0){
            System.out.println("Stack is empty");
            return;
        }
        int index = 0;
        for (int i = 0; i <myStack.length; i++) {
            if (myStack[i] != 0)
                index ++;
        }
        System.out.println(myStack[--index]);
        myStack[index] = 0;

    }

    private static void push(int[] myStack) {
        if (myStack[myStack.length-1] != 0){
            System.out.println("Stack is full");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element you want to push except 0 :");
        int element = sc.nextInt();
        if (element == 0) {
            System.out.println("Please select an option since you entered a false value ");
            return;
        }
        int index = 0;
        for (int i = 0; i <myStack.length; i++) {
            if (myStack[i] != 0)
                index ++;
        }
        myStack[index] = element;
        System.out.println("Element added in stack");
        printStack(myStack);

    }

    private static void printStack(int[] myStack) {

        for (int i = myStack.length - 1; i >=0 ; i--) {
            if (myStack[i] != 0)
                System.out.println(myStack[i]);
        }
    }
}
