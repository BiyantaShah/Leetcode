/**
 * Created by Biyanta on 14/11/17.
 */
public class LargestNumber {
    // create the largest number from this array
    public static void main (String[] args) {
        int [] nums = {3,30,34, 5,9};

        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                String str1 = arr[i] + arr[j];
                String str2 = arr[j] + arr[i];

                if (str2.compareTo(str1) > 0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        System.out.println(result.toString());
    }
}
