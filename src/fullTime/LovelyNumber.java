package fullTime;

import java.util.Arrays;

/**
 * Created by Biyanta on 08/12/17.
 */
public class LovelyNumber {

    public static void main(String[] args) {
        boolean[] arr = new boolean[10];

        Arrays.fill(arr, false);

        int n = 122;

        System.out.println(isLovely(n, arr));
    }

    private static boolean isLovely(int n, boolean[] arr) {

        while (n > 0) {
            int x = n%10;
            if (arr[x])
                return false;

            arr[x] = true;
            n = n/10;
        }
        return true;
    }
}
