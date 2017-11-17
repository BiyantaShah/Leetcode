/**
 * Created by Biyanta on 12/11/17.
 */
public class RotateArray {

    public static void main (String[] args) {
        int [] nums = {1,2,3,4};
        int k = 1;
        k = k%nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start ++;
            end --;
        }
    }
}

