package fullTime;

import java.util.Arrays;

/**
 * Created by Biyanta on 12/11/17.
 */
public class ContinuousMaxProductArray {

    public static void main (String[] args) {
        int [] nums = {-4,-3,-2};

        int min = nums[0];
        int max = nums[1];
        int r = max;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(max, max* nums[i]);
            min = Math.min(min, min *nums[i]);

            r = Math.max(r, max);
        }

        System.out.println(r);


    }
}
