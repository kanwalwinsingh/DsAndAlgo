package leetCodeTopInterview;

import java.util.*;

public class CountOfSmallerNumberAfterSelf {
    class BinaryIndexedTree {
        private int n;
        private int[] c;

        public BinaryIndexedTree(int n) {
            this.n = n;
            c = new int[n + 1];
        }

        public void update(int x, int delta) {
            while (x <= n) {
                c[x] += delta;
                x += lowbit(x);
            }
        }

        private int lowbit(int x) {
            return x & -x;
        }

        public int query(int x) {
            int s = 0;
            while (x > 0) {
                s += c[x];
                x -= lowbit(x);
            }
            return s;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        List<Integer> alls = new ArrayList<>(s);
        alls.sort(Comparator.comparingInt(a -> a));
        int n = alls.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(alls.get(i), i + 1);
        }
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = nums.length - 1; i > 0; i--) {
            int x = map.get(nums[i]);
            tree.update(x, 1);
            ans.addFirst(tree.query(x - 1));
        }
        return ans;
    }

   private int[] count;

    public List<Integer> countSmallerOptimal(int[] nums){
        int n = nums.length;
        count = new int[n];
        int[] indexes = new int[n];
        for(int i =0; i<n; i++){
            indexes[i] = i;
        }
        mergeSort(nums,indexes,0,n-1);
        List<Integer> result = new ArrayList<>();
        for(int i =0; i<n; i++){
            result.add(count[i]);
        }
        return result;
    }

    private void mergeSort(int[] nums, int[] indexes, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left +(right-left)/2;
        mergeSort(nums,indexes,left,mid);
        mergeSort(nums,indexes,mid+1,right);
        merge(nums,indexes,left,mid,right);
    }

    private void merge(int[] nums, int[] indexes, int left, int mid, int right){
        int[] tempIndexes = new int[right-left + 1];
        int i = left, j = mid+1, k =0;
        int rightCount = 0;
        while (i<= mid && j<= right){
            if(nums[indexes[j]] <nums[indexes[i]]){
                rightCount++;
                tempIndexes[k] = indexes[j];
                j++;
            }else{
                count[indexes[i]] +=rightCount;
                tempIndexes[k] = indexes[i];
                i++;
            }
            k++;
        }
        while (i<= mid){
            count[indexes[i]] +=rightCount;
            tempIndexes[k++] = indexes[i++];
        }
        while (j<=right){
            tempIndexes[k++]= indexes[j++];
        }
        for(int p =0; p<tempIndexes.length; p++){
            indexes[left+p] = tempIndexes[p];
        }
    }


    public static void main(String[] args) {
        CountOfSmallerNumberAfterSelf solution = new CountOfSmallerNumberAfterSelf();

        int[] nums = {5, 2, 6, 1};
        List<Integer> result = solution.countSmallerOptimal(nums);

        System.out.println("Counts of smaller elements to the right:");
        System.out.println(result); // Output: [2, 1, 1, 0]
    }
}
