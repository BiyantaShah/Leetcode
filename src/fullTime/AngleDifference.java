package fullTime;

/**
 * Created by Biyanta on 25/09/17.
 */
public class AngleDifference {


    public static void main (String[] args) {
        String time = "10:45";

        calculateAngle(time);
    }

    private static void calculateAngle(String time) {
        String [] arr = time.split(":");
        int hour = Integer.valueOf(arr[0]);
        int minute = Integer.valueOf(arr[1]);

        int minuteConversion = hour * 5;

        int difference = Math.abs(minute - minuteConversion);

        int absAngle = difference*6;

        double minuteDiff = 60.0/minute;
        double minus = 30.0/minuteDiff;

        if (hour > 6)
            System.out.println(absAngle+minus);
        else
            System.out.println(absAngle-minus);
    }
}
