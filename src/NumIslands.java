/**
 * Created by Biyanta on 17/11/17.
 */
public class NumIslands {

    public static void main (String[] args) {
        int [][]grid = {{1,1,0,0,0},
                        {1,1,0,0,0},
                        {0,0,1,0,0},
                        {0,0,0,1,1}};
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    countingIslands(grid, i, j);
                    count ++;
                }
            }
        }

        System.out.println(count);
    }

    private static void countingIslands(int[][] grid, int i, int j) {

        if ( i < 0 || j <0|| i >= grid.length|| j >= grid[0].length|| grid[i][j]!= 1)
            return;

        grid[i][j] = 0;
        countingIslands(grid, i+1, j);
        countingIslands(grid, i, j+1);
        countingIslands(grid, i-1, j);
        countingIslands(grid, i, j-1);

    }
}
