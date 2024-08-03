package main.java.algorithms.divideandconquer;

public class PascalTriangel {

    public static int[] pascalTriangleRecursive(int lineNumber){
        int currentlineSize = lineNumber;
        int previousLineSize =  currentlineSize -1;
        int[] currentLine = new int[currentlineSize]; // create container for current line
        if(lineNumber == 1){
            currentLine[0] = 1;
            System.out.println(1);
            return currentLine;
        }else{
            int [] previousLine = pascalTriangleRecursive(lineNumber-1); //We will calculate current line based on previous one
            // Let's go through all elements of current line except the first and last one (since they were and will be filled with 1's) and calculate current coefficient based on previous line.
            for(int numIndex = 0; numIndex < currentlineSize; numIndex++){
                int leftCoefficient = (numIndex-1)>=0? previousLine[numIndex-1]:0;
                int rightCofficient = numIndex<previousLineSize? previousLine[numIndex]:0;
                currentLine[numIndex] = leftCoefficient+rightCofficient;
                System.out.print(leftCoefficient+rightCofficient+" ");
            }
            System.out.println();
            return currentLine;
        }
    }
    public static void main(String args[]) {

        int n = 5; // play around with this number to see how the triangle grows
        pascalTriangleRecursive(n);
    }

}
