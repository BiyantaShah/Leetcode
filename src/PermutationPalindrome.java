import java.util.HashMap;
import java.util.Map;

/**
 * Created by Biyanta on 08/12/17.
 */
public class PermutationPalindrome {

    public static void main (String[] args) {

        String str = "geeksogeeks";

        System.out.println(palindromePermute(str));


    }

    private static boolean palindromePermute(String str) {
        Map<Character, Integer> countChar = new HashMap<>();

        for (int i = 0; i <str.length(); i++) {
            countChar.put(str.charAt(i), countChar.getOrDefault(str.charAt(i), 0)+1);
        }

        if (str.length() % 2 == 0) {
            // all of characters should be even
            for (Character ch : countChar.keySet()) {
                if (countChar.get(ch) % 2 != 0) {
                    return false;
                }

            }
            return true;

        }
        else {
            // one char odd, rest all even
            int count  = 0;
            for (Character ch : countChar.keySet()) {
                if (count > 1)
                    return false;
                if (countChar.get(ch) % 2 != 0) {
                    count ++;
                }
            }
            return true;
        }
    }
}
