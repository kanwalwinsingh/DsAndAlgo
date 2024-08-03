package blackrock;

public class ReverseAstring {
    public static void main(String[] args) {
        String str = "Geeks";
        String nstr = "";
        char ch;

        for (int i = 0; i<str.length(); i++){
            ch = str.charAt(i);
            nstr = ch+nstr;
        }
        System.out.println(nstr);

        //Second way using byteArray
        byte [] strAsByteArray = str.getBytes();
        byte [] result = new byte[strAsByteArray.length];
        for(int i =0; i<strAsByteArray.length; i++){
            result[i] = strAsByteArray[strAsByteArray.length-i-1];
        }
        System.out.println(new String(result));

        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder.reverse().toString());

        System.out.println(reverse(str));
    }

    public static String reverse(String str){
        if(str.isEmpty()){
            return str;
        }else {
            return reverse(str.substring(1))+str.charAt(0);
        }
    }
}
