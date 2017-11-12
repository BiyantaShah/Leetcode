package fullTime;

import java.util.Stack;

/**
 * Created by Biyanta on 12/09/17.
 */
public class StringRev {

    public static void main (String[] args) {

        String input = "abbac";
//        reverseString(input);
        reverseStringStack(input);
    }

    private static void reverseStringStack(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String result ="";


        while (!stack.empty()) {
            char prev = stack.peek();
            if (result.length() == 0){
                result += stack.pop();
            }
            else if (prev != result.charAt(result.length()-1)) {
                result += stack.pop();
            }
            else {
                stack.pop();
            }


        }
        System.out.println(result);
    }

    private static void reverseString(String input) {

        String result = "";
        int j = input.length()-1;

        while ( j >= 0 ) {

                result += input.charAt(j);
                j --;

        }
        System.out.println(result);
        String finalRes = "";

        for (int i = 0; i < result.length(); i++) {
            if (i == 0)
                finalRes += result.charAt(i);
            else {
                int k =finalRes.length();
                if (finalRes.charAt(k-1) != result.charAt(i))
                    finalRes += result.charAt(i);
            }

        }


        System.out.println(finalRes);
    }
}
