package fullTime;

/**
 * Write a program that prints the temperature closest to 0 among input data
 */
public class ClosestToZero {

    public static void main (String[] args) {

        int[] arr = {5,6,7,8,-4,-3};

        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                closest = arr[i];

            else if (closest == Integer.MAX_VALUE || Math.abs(closest) > Math.abs(arr[i]) ||
                    (Math.abs(closest) == Math.abs(arr[i]) &&
                    closest < arr[i]))
                closest = arr[i];
        }

        System.out.println(closest);

    }
}
