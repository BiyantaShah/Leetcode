/**
 * Created by Biyanta Shah on 16/11/17.
 */
public class CountAndSay {

    public static void main (String[] args) {

        int n = 5;

        String[] arr = new String[n+1];
        arr[0] = "1";

        for (int i = 1; i <=n ; i++) {

            String str = arr[i-1];
            String res = new String();
            int j = 0;
            while (j < str.length()) {
                int count = 1;
                int integer = Character.getNumericValue(str.charAt(j));

                j++;
                while ( j < str.length()) {
                    if (Character.getNumericValue(str.charAt(j)) == integer)
                        count ++;
                    else {
                        break;
                    }
                    j++;
                }
                res += String.valueOf(count)+integer;
            }
            arr[i] = res;
        }
        System.out.println(arr[n]);

    }



}
