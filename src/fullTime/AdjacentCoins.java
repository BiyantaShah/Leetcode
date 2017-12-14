package fullTime;

/**
 * Created by Biyanta on 08/12/17.
 */
public class AdjacentCoins {

    public static void main(String[] args) {
        int [] coins = {1,1,0,1,0,0,1,1};

        int pairs = findAjacency(coins);

        System.out.println(pairs);
    }

    private static int findAjacency(int[] coins) {
        for (int i = 1; i < coins.length; i++) {

            if (coins[i-1] != coins[i] && coins[i+1] != coins[i] )
            {
                coins[i] = (coins[i] == 1) ? 0:1;
                return adjacency(coins);
            }
        }

        for (int i = 1; i < coins.length; i++) {
            if (coins[i-1] == coins[i] && coins[i+1] != coins[i]) {
                coins[i+1] = (coins[i+1] == 1) ? 0:1;
                return adjacency(coins);
            }
            else if (coins[i-1] != coins[i] && coins[i+1] == coins[i]) {
                coins[i-1] = (coins[i-1] == 1)?0:1;
                return adjacency(coins);
            }
        }

        coins[0] = (coins[0] == 1) ? 0:1;
        return adjacency(coins);
    }

    private static int adjacency(int[] coins) {
        int count = 0;
        for (int i = 1; i < coins.length; i++) {

            if (coins[i-1] == coins[i])
                count++;
        }
        return count;
    }

}
