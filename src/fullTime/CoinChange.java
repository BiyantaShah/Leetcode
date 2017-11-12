package fullTime;

import java.util.Arrays;

/**
 * Created by Biyanta on 08/11/17.
 */
public class CoinChange {

    public static void main (String[] args) {
        int[] coins = {2};
        int target = 1;

        int [] arr = new int[target+1];
//        int[] minCoins = new int[target+1];

        Arrays.fill(arr, Integer.MAX_VALUE-1);
//        Arrays.fill(minCoins, -1);

        arr[0] = 0;

        for (int i = 0; i <coins.length; i++) {
            for (int j = 0; j <arr.length; j++) {
                if (j >= coins[i]) {
                    int y = arr[j - coins[i]];
                    int x=  Math.min(y + 1, arr[j]);
                    arr[j]=x;
                }
            }
        }

        System.out.println(arr[target]);
    }
}
