package nikhil_lohia;

public class ShuffleString {
    public String restoreString(String s, int[] indices){
        int len = indices.length;
        char[] resultArr = new char[len];
        for(int i =0; i<len; i++){
            resultArr[indices[i]] = s.charAt(i);
        }
        return  String.valueOf(resultArr);
    }
}
