package javaeightexample;

public class NullPrintExample {
    public static void main(String[] args) {
        Object s = null;
       //  System.out.println(null); // Prints: null
        NullPrintExample nullPrintExample = new NullPrintExample();
        nullPrintExample.process(null);
    }
    public void process(String s) {
        System.out.println("String method called");
    }

//    public void process(StringBuffer sb) {
//        System.out.println("StringBuffer method called");
//    }

    public void process(Object o) {
        System.out.println("Object method called");
    }
}