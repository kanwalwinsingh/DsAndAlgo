package Gaana;

public class EquilibriumIndex {

    public static int findEquilibriumIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            // totalSum now is the sum of elements to the right of index i (including arr[i])
            totalSum -= arr[i];

            // Check if leftSum equals totalSum (which is now right sum)
            if (leftSum == totalSum) {
                return i;
            }

            leftSum += arr[i];
        }

        // If no equilibrium index found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int result = findEquilibriumIndex(arr);
        if (result != -1) {
            System.out.println("Equilibrium index found at: " + result);
        } else {
            System.out.println("No equilibrium index found");
        }
    }
}