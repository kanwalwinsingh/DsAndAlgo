package agoda;

public class NumberToWord {
    private static final String[] BELOW_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num){
        if(num == 0) return "Zero";

        String result = "";
        int i = 0;
        while (num >0){
            if(num % 1000 != 0){
                result = helper(num%1000) + THOUSANDS[i] + " "+ result;
            }
            num /= 1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int num){
        if(num == 0) return "";
        else if (num < 20) return BELOW_TWENTY[num] + " ";
        else if (num < 100) return TENS[num/10] + " " + helper(num % 10 );
        else return BELOW_TWENTY[num/100] + " Hundred "+ helper(num % 100);
    }

    public static void main(String[] args) {
        NumberToWord converter = new NumberToWord();
        System.out.println(converter.numberToWords(47)); // Output: Forty Seven
        System.out.println(converter.numberToWords(123)); // Output: One Hundred Twenty Three
    }


}
