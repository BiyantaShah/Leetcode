package fullTime;

/**
 * Created by Biyanta on 18/09/17.
 */
public class lcs {

    public static void main (String[] args) {

        String a = "ABCDGH";
        String b = "AEDFHR";

        commonSubsequence(a.toCharArray(), b.toCharArray());
    }

    private static void commonSubsequence(char[] a, char[] b) {

        int [][] lcs = new int[a.length+1][b.length+1];

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {

                if (i == 0 || j == 0)
                    lcs[i][j] = 0;

                else if (a[i-1] == b[j-1]) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }

        System.out.println(lcs[a.length][b.length]);
    }
}
