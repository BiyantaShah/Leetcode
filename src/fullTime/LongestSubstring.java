package fullTime;

/**
 * Created by Biyanta on 18/09/17.
 */
public class LongestSubstring {

    public static void main (String[] args) {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        LCSubStr(X.toCharArray(), Y.toCharArray(), m, n);
    }

    private static void LCSubStr(char[] x, char[] y, int m, int n) {

        int[][] lcs = new int[m+1][n+1];

        int result = 0;

        for(int i = 0; i <= m; i++) {
            for (int j = 0; j <=n; j++) {

                if (i ==0 || j==0)
                    lcs[i][j] = 0;

                else if (x[i-1] == y[j-1]) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                    result = Math.max(result, lcs[i][j]);
                }

                else
                    lcs[i][j] = 0;
            }
        }
        System.out.println(result);
    }
}
