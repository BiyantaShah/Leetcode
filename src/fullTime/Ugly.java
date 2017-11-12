package fullTime;

/**
 * Created by Biyanta on 18/09/17.
 */
public class Ugly {

    public static void main (String[] args) {

        uglyNumber(10);
    }

    private static void uglyNumber(int n) {

        int [] ugly = new int[n];

        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        int nextMulitple2 = 2;
        int nextMultiple3 = 3;
        int nextMuliple5 = 5;
        int nextUgs = 1;

        for (int i = 1; i < n ; i++) {

            nextUgs = Min(nextMulitple2, nextMultiple3, nextMuliple5);
            ugly[i] = nextUgs;

            if (nextUgs == nextMulitple2) {
                i2 += 1;
                nextMulitple2 = 2 * ugly[i2];
            }
            if (nextUgs == nextMultiple3) {
                i3 += 1;
                nextMultiple3 = 3 * ugly[i3];
            }
            if (nextUgs == nextMuliple5) {
                i5 += 1;
                nextMuliple5 = 5 * ugly[i5];
            }
        }

        System.out.println(nextUgs);
//        int ugly[] = new int[n];  // To store ugly numbers
//        int i2 = 0, i3 = 0, i5 = 0;
//        int next_multiple_of_2 = 2;
//        int next_multiple_of_3 = 3;
//        int next_multiple_of_5 = 5;
//        int next_ugly_no = 1;
//
//        ugly[0] = 1;
//
//        for(int i = 1; i < n; i++)
//        {
//            next_ugly_no = Min(next_multiple_of_2,
//                    next_multiple_of_3,
//                            next_multiple_of_5);
//
//            ugly[i] = next_ugly_no;
//            if (next_ugly_no == next_multiple_of_2)
//            {
//                i2 = i2+1;
//                next_multiple_of_2 = ugly[i2]*2;
//            }
//            if (next_ugly_no == next_multiple_of_3)
//            {
//                i3 = i3+1;
//                next_multiple_of_3 = ugly[i3]*3;
//            }
//            if (next_ugly_no == next_multiple_of_5)
//            {
//                i5 = i5+1;
//                next_multiple_of_5 = ugly[i5]*5;
//            }
//        } /*End of for loop (i=1; i<n; i++) */
//        System.out.println( next_ugly_no);
    }

    private static int Min(int nextMulitple2, int nextMultiple3, int nextMuliple5) {

        int min = Integer.MAX_VALUE;

        if (min > nextMulitple2)
            min = nextMulitple2;
        if (min > nextMultiple3)
            min = nextMultiple3;
        if (min > nextMuliple5)
            min = nextMuliple5;

        return min;
    }
}
