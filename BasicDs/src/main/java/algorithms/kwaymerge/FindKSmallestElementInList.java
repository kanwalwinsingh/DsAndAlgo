package main.java.algorithms.kwaymerge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKSmallestElementInList {
    public static int kSmallestNumber(List<List<Integer>> list, int k) {
        int listLength = list.size();
        PriorityQueue<int[]> kthSmallest = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int index = 0; index < listLength; index++) {
            if (list.get(index).size() == 0) {
                continue;
            } else {
                kthSmallest.offer(new int[]{list.get(index).get(0), index, 0});
            }
        }
        int numbersChecked = 0, smalllestNumber = 0;
        while (!kthSmallest.isEmpty()) {
            int[] smallest = kthSmallest.poll();
            smalllestNumber = smallest[0];
            int listIndex = smallest[1];
            int numIndex = smallest[2];
            numbersChecked++;

            if (numbersChecked == k) {
                break;
            }
            if (numIndex + 1 < list.get(listIndex).size()) {
                kthSmallest.offer(new int[]{list.get(listIndex).get(numIndex + 1), listIndex, numIndex + 1});
            }
        }
        return smalllestNumber;
    }
    // Driver code
    public static void main(String[] args) {

        List<List<List<Integer>>> lists = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(2, 6, 8),
                        Arrays.asList(3, 6, 10),
                        Arrays.asList(5, 8, 11)
                ),
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5),
                        Arrays.asList(6, 7, 8, 15),
                        Arrays.asList(10, 11, 12, 13),
                        Arrays.asList(5, 10)
                ),
                Arrays.asList(
                        Arrays.asList(),
                        Arrays.asList(),
                        Arrays.asList()
                ),
                Arrays.asList(
                        Arrays.asList(1, 1, 3, 8),
                        Arrays.asList(5, 5, 7, 9),
                        Arrays.asList(3, 5, 8, 12)
                ),
                Arrays.asList(
                        Arrays.asList(5, 8, 9, 17),
                        Arrays.asList(),
                        Arrays.asList(8, 17, 23, 24)
                )
        );

        int[] k = {5, 50, 7, 4, 8};

        for (int i = 0; i < k.length; i++) {
            System.out.println(i + 1 + ".\t Input lists: " + lists.get(i) +
                    "\n\t K = " + k[i] +
                    "\n\t " + k[i] + "th smallest number from the given lists is: " +
                    kSmallestNumber(lists.get(i), k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
