package fullTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Biyanta on 08/12/17.
 *
 * Find how many letters a second word is away from being an anagram of the first word
 */
public class DifferentLetters {

    public static void main(String[] args) {

        String word1 = "healt";
        String word2 = "hhe";

        Map<Character, Integer> countChar = new HashMap<>();
        int diffLetters = 0;

        for (char ch : word1.toCharArray()) {
            countChar.put(ch, countChar.getOrDefault(ch, 0)+1);
        }

        for(char ch : word2.toCharArray()) {
            if (!countChar.containsKey(ch))
                diffLetters ++;

            else if (countChar.containsKey(ch)) {
                if (countChar.get(ch) <= 0)
                    diffLetters ++;
                else
                    countChar.put(ch, countChar.get(ch)-1);
            }

        }

        for (Character ch : countChar.keySet()) {
            if (countChar.get(ch) > 0)
                diffLetters += countChar.get(ch);
        }

        System.out.println(diffLetters);
    }
}
