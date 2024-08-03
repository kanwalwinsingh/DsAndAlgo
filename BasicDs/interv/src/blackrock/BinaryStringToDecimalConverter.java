package blackrock;

public class BinaryStringToDecimalConverter {
    public static void main(String[] args) {
        System.out.println(binaryToDecimalAnotherWay("1101"));
    }
    public static int binaryToDecimal(String s){
        s= s.trim();
        int sum = 0;
        int length = s.length();
        for (int j =0; j<length;j++){
           sum += (int) (Math.pow(2,j)*(s.charAt(length-j-1)-48));
        }
        return sum;
    }

    static int binaryToDecimalAnotherWay(String n){
        String num = n;
        int dec_value =0;
        //Initialize base value to 1
        int base = 1;
        int len = num.length();
        for (int i = len-1; i>=0; i--){
            if(num.charAt(i) == '1'){
                dec_value +=base;
            }
            base = base *2;
        }
        return dec_value;
    }
}
