/**
 * Created by Biyanta on 15/11/17.
 */
public class SortColors {

    public static void main (String[] args) {
        int[] nums = {0,1,1,2,1,0,2};

        int zeroIndex = 0, twoIndex = nums.length-1;

        int index = 0;

        while (index <= twoIndex) {

            if (nums[index] == 0) {
                nums[index] = nums[zeroIndex];
                nums[zeroIndex] = 0;
                zeroIndex ++;
            }
            else if (nums[index] == 2) {
                nums[index] = nums[twoIndex];
                nums[twoIndex] = 2;
                twoIndex --;
                index --;
            }
            index ++;
        }
        

        for (int i : nums) {
            System.out.print(i +" ");
        }
    }


}
