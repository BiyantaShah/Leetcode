package fullTime;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Biyanta on 18/09/17.
 */
public class SubsetSumProblemDP {

    public static void main (String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};

        int target = 4;

        checkIfSubset(arr, target);
    }

    private static void checkIfSubset(int[] arr, int target) {

        Set<Integer> hashset = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            int n = arr[i];
            if (hashset.contains(target-n)) {
                System.out.println("true");
                System.exit(0);
            }

            else {
                hashset.add(n);
            }
        }

        if (hashset.contains(target))
        {
            System.out.println("true");
            System.exit(0);
        }

        System.out.println("false");
    }
}
