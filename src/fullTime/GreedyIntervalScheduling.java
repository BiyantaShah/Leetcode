package fullTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Biyanta on 13/09/17.
 */
public class GreedyIntervalScheduling {

    public static void main (String[] args) {

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        // sort the end times by first finish
        for (int i  = 0;i < end.length; i++) {
            for (int j = 1; j < end.length - i ; j++) {
                if (end[j-1] > end [j]) {
                    swap (j-1, j, end);
                    swap(j-1, j, start);
                }
            }
        }

        List<String> finalSchedule = new ArrayList<>();

        finalSchedule.add(start[0] + " " +end[0]);
        int counter = 0;

        for (int i = 1; i < end.length; i++) {
            if (start[i] >= end[counter]) {
                finalSchedule.add(start[i] + " " + end[i]);
                counter = i;
            }
        }

        for (String time : finalSchedule) {
            System.out.println(time);
        }

    }

    private static void swap(int i, int j, int[] end) {

        int temp = end[i];
        end[i] = end[j];
        end[j] = temp;
    }
}
