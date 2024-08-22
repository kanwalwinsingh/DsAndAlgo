package expedia;

public class ConcatinateTwoStringsInterleved {
    public static String interleaveTwoString(String s1, String s2){
        if(s1.isEmpty() && s2.isEmpty()){
            return "";
        }
        if(s1.isEmpty()){
            return s2;
        }
        if(s2.isEmpty()){
            return s1;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int s1Length = s1.length();
        int s2Length = s2.length();
        int i = 0, j = 0;
        int k = 0;
        char[] c3 = new char[s1Length+s2Length];
        while (i<s1Length && j<s2Length){
            c3[k++] = c1[i++];
            c3[k++] = c2[j++];
        }
        while (i<s1Length){
            c3[k++] = c1[i++];
        }
        while (j<s2Length){
            c3[k++] = c2[j++];
        }
        return new String(c3);
    }

    public static void main(String[] args) {
        System.out.println(interleaveTwoString("abc","pqrst"));
    }
}
