import java.util.ArrayList;
import java.util.List;

/**
 * Created by Biyanta on 12/11/17.
 */
public class SpiralMatrix {

    public static void main (String[] args) {
        int[][]matrix = {{1,2,3, 4}, {5,6,7, 8}, {9,10,11,12}, {13,14,15,16}};

        List<Integer> spiral = new ArrayList<>();

        int rows = matrix.length-1;
        int cols = matrix[0].length-1;

        int rowsStart = 0;
        int colsStart = 0;

        while (rowsStart <= rows && colsStart <= cols) {

            for (int i = colsStart; i <=cols; i++) {
                spiral.add(matrix[rowsStart][i]);
            }
            rowsStart ++;

            for (int i = rowsStart; i <=rows; i++) {
                spiral.add(matrix[i][cols]);
            }
            cols --;

            if (rowsStart <= rows) {
                for (int i = cols; i >= colsStart; i--) {
                    spiral.add(matrix[rows][i]);
                }
            }
            rows --;

            if (colsStart <= cols) {
                for (int i = rows; i >= rowsStart; i--) {
                    spiral.add(matrix[i][colsStart]);
                }
            }
            colsStart++;
        }

        for (int i : spiral) {
            System.out.print( i + " ");
        }

    }
}
