package fullTime;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Biyanta on 01/12/17.
 * Given a sorted array of integers and a k value find the number pairs that have a difference of k.
 */
public class DifferenceOfKPairs {

    public static void main (String[] args) {

        int[] arr = {8, 12, 16, 4, 0, 20};
        int k =4;
        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int number1 = arr[i] - k;
            int number2 = k + arr[i];

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] == number1)
                    count ++;
                else if (arr[j] == number2)
                    count ++;
            }
        }

        System.out.println(count);
    }
}
