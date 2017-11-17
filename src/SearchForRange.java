/**
 * Created by Biyanta on 17/11/17.
 */
public class SearchForRange {

    public static void main (String[] args) {
        int[] nums = {1,2,7,8,10,8};
        int target = 8;
        int [] res = new int[2];

        int left = 0;
        int right = nums.length-1;
        int index = Integer.MIN_VALUE;

        while ( left <= right) {

            int mid = (left+right)/2;

            if (nums[mid] == target) {
                index = mid;
                break;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid+1;
            }
        }

        if (index == Integer.MIN_VALUE)
        {
            res[0] = -1;
            res[1] = -1;

        }
        else {
            int first = index;
            int last = index;
            for (int i = last+1; i < nums.length; i++) {
                if (nums[i] == target) {
                    last ++;
                }
                else
                    break;
            }

            for (int i = first-1; i >= 0; i--) {
                if (nums[i] == target) {
                    first --;
                }
                else
                    break;
            }
            res[0] = first;
            res[1] = last;


        }

        System.out.println(res[0] + " " + res[1]);
    }
}
