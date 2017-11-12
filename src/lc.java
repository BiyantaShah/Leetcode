import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Biyanta on 28/10/17.
 */
public class lc {

    public static void main (String[] args) throws FileNotFoundException {

        int n = 10;
        int [] cost = {6,3,4,2};
        int[] quantities = {30,14,16,9};

        System.out.println(budgetShopping(n, quantities, cost));




    }

    private static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {

        int maxBooks = 0;

        for (int i = 0; i < bundleQuantities.length; i++) {
            int amountLeft = 0;

            if ( n < bundleCosts[i])
                continue;

            int books = (n/bundleCosts[i]) * bundleQuantities[i];
            amountLeft = n % bundleCosts[i];

            if (amountLeft > 0)
                books += budgetShopping(amountLeft, bundleQuantities, bundleCosts);

            if (books> maxBooks)
                maxBooks = books;
        }


        return maxBooks;
    }

    private static String substring(String big, String small) {
        int i = 0;
        int j = 0;

        while (i < big.length() && j < small.length()) {
            if (big.charAt(i) == small.charAt(j)) {
                i++;
                j++;
            }
            else {
                break;
            }

        }

        return big.substring(0,i);
    }

    private static  void createBrackets(String s, Set<String> brackets, int open, int close, int n) {
        if (s.length() == n*2) {
            brackets.add(s);
            return;
        }

        if (open < n) {
            createBrackets(s+"(", brackets, open+1,close, n );
        }
        if (close < open) {
            createBrackets(s+")", brackets, open,close+1, n);
        }

    }

    private static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E'
                || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        else
            return false;
    }


}
