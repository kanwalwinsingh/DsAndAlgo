package Codility;

import java.util.Arrays;

public class Flags {
    public static int solution(int[] A) {
        int n = A.length, peaksCount = 0;
        if (n < 3) return 0;

        int[] peaks = new int[n];
        for (int i = 1; i < n - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[peaksCount] = i;
                peaksCount++;
            }
        }

        if (peaksCount == 0) return 0;

        peaks = Arrays.copyOfRange(peaks, 0, peaksCount);

        for (int sliceSize = 1; sliceSize < n; sliceSize++) {
            if (n % sliceSize != 0) continue;

            int slices = n / sliceSize;
            boolean containsPeaks = true;
            int peakFound = 0;

            for (int peak : peaks) {
                if (peak / sliceSize > peakFound) {
                    containsPeaks = false;
                    break;
                } else if (peak / sliceSize == peakFound) {
                    peakFound++;
                }
            }

            if (peakFound != slices) containsPeaks = false;

            if (containsPeaks) return slices;
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] A = {1, 2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(solution(A));
    }
}
