/**
 * Created by Biyanta on 11/12/17.
 * Swap two numbers without using arithmetic operators or temp variable.
 */
public class SwapTwoNumbers {

    public static void main (String[] args) {

        // w/o using a temp variable
        int a = 5;
        int b = 7;

        a = a+b;
        b = a-b;
        a = a-b;

        System.out.println(a + " " + b);

        // without using temp variable or arithmetic operators
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println(a +" " + b);
    }
}
