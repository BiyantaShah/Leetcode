/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid
 How many possible unique paths are there?
 */
public class UniquePath {

    public static void main (String[] args) {
        int m = 3; int n =7;
         int[][] result = new int[m][n];

         for (int i = 0; i < m ; i++) {
             result[i][0] = 1;
         }
         for (int j = 0; j < n ; j++) {
             result[0][j] = 1;
         }

         for (int i = 1; i < m; i++) {
             for (int j = 1; j < n; j++) {
                 // either go down or go left hence coming from left or upstairs
                 // consider both the possibilities.
                 result[i][j] = result[i-1][j] + result[i][j-1];
             }
         }

        System.out.println("Unique Paths are "+ result[m-1][n-1]);
    }
}
