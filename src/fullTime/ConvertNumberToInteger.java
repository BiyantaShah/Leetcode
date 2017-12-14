package fullTime;

/**
 * Created by Biyanta on 13/12/17.
 */
public class ConvertNumberToInteger {

    String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static void main (String [] args) {
        ConvertNumberToInteger num = new ConvertNumberToInteger();

        int number = 1001;

        String result = num.numberToWords(number);

        System.out.println(result);


    }

    private String numberToWords(int number) {

        if (number == 0)
            return "Zero";

        int i = 0;
        String word = "";

        while (number > 0) {
            if ( number % 1000 != 0) {
                word = makeString(number % 1000) + THOUSANDS[i] + " " + word;
            }
            number = number/1000;
            i++;
        }
        return word;
    }

    private String makeString(int i) {

        if (i == 0)
            return "";

        else if (i < 20)
            return lessThan20[i] + " ";

        else if ( i < 100)
            return TENS[i/10] + " " + makeString(i%10);

        else
            return lessThan20[i/100] + " Hundred "+ makeString(i%100);
    }

}
