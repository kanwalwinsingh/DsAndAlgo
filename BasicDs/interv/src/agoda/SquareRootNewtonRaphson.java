package agoda;

public class SquareRootNewtonRaphson {
    public static double sqrt(double number, double tolerance){
        if (number<0){
            throw new IllegalArgumentException("Cannot compute sqrt of negative number");
        }
        // inital guess
        double x = number;

        //Iterative improve the guess using the Newton-Raphson formula
        while (true){
            double nextX = 0.5 *(x+ number/x);
            // check for covergence
            if(Math.abs(x-nextX)< tolerance){
                break;
            }
            x= nextX;
        }
        return x;
    }
        public static void main(String[] args) {
            double number = 25.0;
            double tolerance = 1e-7;

            double sqrt = sqrt(number, tolerance);

            System.out.println("The square root of " + number + " is approximately: " + sqrt);
        }
}
