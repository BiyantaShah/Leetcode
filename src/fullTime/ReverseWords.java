package fullTime;

import java.util.Stack;

/**
 * Created by Biyanta on 05/12/17.
 */
public class ReverseWords {

    public static void main (String[] args) {

        String s = "The skys is blue";

        StringBuilder builder = new StringBuilder();

        String[] arr = s.trim().split("\\s+");

        for (int i = arr.length-1 ; i > 0; i--) {
            builder.append(arr[i] + " ");
        }

        System.out.println(builder.append(arr[0]).toString());
    }


}
