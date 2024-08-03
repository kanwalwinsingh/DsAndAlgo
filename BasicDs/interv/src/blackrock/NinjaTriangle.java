package blackrock;

public class NinjaTriangle {
    public static int ninjaAndTriangle(int n) {
        int sum = n;
        int result = 0;
        for(int i =1; i<= n; i++){
            if(sum>=i){
                sum = sum-i;
                result = i;
            }else{
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ninjaAndTriangle(10));
    }
}
