package codewithjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayUtils {
    public int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null");

        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    @Test
    public void testFindmaxWithPositiveNumber() {
        ArrayUtils utils = new ArrayUtils();
        int[] arr = {1, 2, 3, 4, 5};
        int result = utils.findMax(arr);
        assertEquals(5, result);
    }

}
