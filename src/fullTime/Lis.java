package fullTime;

/**
 * Created by Biyanta on 18/09/17.
 */
public class Lis {

    public static void main(String[] args) {
        int  arr[] = {1,2,-1,4,6,2,2,8};

        lis(arr);
    }

    private static void lis(int[] arr) {
        int [] lis = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                if (arr [i] > arr[j] && lis[i] < lis[j]+1) {
                    lis[i] = lis[j]+1;
                }
            }

        }

        int max = 0;
        for (int i = 0; i < lis.length; i++) {
            if (max < lis[i])
                max = lis[i];
        }

//        int k = max - 1;
//        int number = max;
//        int toReturn = 0;
//
//        for (int i = lis.length-1; i >=0; i--) {
//
//            if (number == lis[i]) {
//                number = number - 1;
//                if (k == 0)
//                    toReturn = i;
//                k--;
//            }
//        }
        System.out.println(max);

//        int [] subsequence = new int[max];
//        int k = subsequence.length-1;
//        int number = max;
//
//        for (int i = lis.length-1; i >=0; i--) {
//
//            if (number == lis[i]) {
//                number = number-1;
//                subsequence[k] = arr[i];
//                k--;
//            }
//        }
//        for (int i : subsequence) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        System.out.println(max);
    }
}
