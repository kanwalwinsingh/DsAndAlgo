package main.java.algorithms.sorting.mergesort;

public class MergeSort {
    public static void merge(int arr[], int left, int mid, int right) {
        int i, j, k;
        //Initialize the sizes of the temporary arrays
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        //Initializing temporary arrays
        int leftArr[] = new int[sizeLeft];
        int rightArr[] = new int[sizeRight];

        //Copying the given array into the temporary arrays
        for (i = 0; i < sizeLeft; i++) {
            leftArr[i] = arr[left + i];
        }
        for (j = 0; i < sizeRight; j++) {
            rightArr[j] = arr[mid + 1 + j];

        }

        //Merging the temporary arrays back into the given array
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second array
        k = left; // Initial index of the given array

        //This is the main part of the algorithm iterate over both arrays and copy the element that is smaller to the given array
        while (i < sizeLeft && j < sizeRight) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        //Copying the remaining elements of leftArr[], if there are any
        while (i < sizeLeft) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        //copying the remainig elements of rightArr[], if there are any
        while (j < sizeRight) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int leftIndex, int rightIndex) {
        //Sanity check
        if (leftIndex < 0 || rightIndex < 0) {
            return;
        }
        if (rightIndex > leftIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;

            // sorting the first and second half of the array
            mergeSort(arr, leftIndex, mid);
            mergeSort(arr, mid, rightIndex);

            //Merging the array
            merge(arr, leftIndex, mid, rightIndex);
        }
    }
}
