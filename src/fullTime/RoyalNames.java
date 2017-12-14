package fullTime;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Biyanta on 08/12/17.
 */
public class RoyalNames {

    public static void main(String[] args) {
        String[] names = {"Polo IV","Alexander V","Elizabeth XXV",
                "Albert XL","Polo XLVI","William IX","Edward XXXIX",
                "Elizabeth XIX", "Albert II"};

        Map<Character, Integer> romanToInt = new HashMap<>();

        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        Map<Integer, String> intToRoman = new HashMap<>();
        for (int j = 0; j < names.length; j++) {
            String[] nameArr = names[j].split(" ");
            String roman = nameArr[nameArr.length-1];
            int number = 0;
            for(int i = 0; i < roman.length(); i++) {

                int s1 = romanToInt.get(roman.charAt(i));

                if (i+1 < roman.length()) {

                    int s2 = romanToInt.get(roman.charAt(i+1));
                    if (s1 >= s2)
                        number += s1;
                    else {
                        number += s2 - s1;
                        i++;
                    }
                }
                else {
                    number += s1;
                    i++;
                }
            }
            String tempString = "";

            intToRoman.put(number, roman);
            for (int k = 0; k < nameArr.length-1; k++) {
                tempString += nameArr[k];
            }
            tempString += " " +number;
            names[j] = tempString;

        }


        Arrays.sort(names);


        for(String name : names) {
            String[] nameArr = name.split(" ");
            int num = Integer.valueOf(nameArr[nameArr.length-1]);
            String roman = intToRoman.get(num);

            String tempString = "";
            for (int k = 0; k < nameArr.length-1; k++) {
                tempString += nameArr[k];
            }
            tempString += " " +roman;
            System.out.println(tempString);
        }


    }
}
