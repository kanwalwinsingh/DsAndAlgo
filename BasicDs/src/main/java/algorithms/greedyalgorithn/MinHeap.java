package main.java.algorithms.greedyalgorithn;

class MinHeap {
    int[] heaparr;
    int hSize;
    int capacity;

    public MinHeap(int pipes[], int size) {
        hSize = size;
        capacity = size;
        heaparr = pipes;
        int i = (hSize - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < hSize && heaparr[l] < heaparr[i])
            smallest = l;
        if (r < hSize && heaparr[r] < heaparr[smallest])
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            MinHeapify(smallest);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }


    int left(int i) {
        return (2 * i + 1);
    }


    int right(int i) {
        return (2 * i + 2);
    }


    int extractMin() {
        if (hSize <= 0)
            return Integer.MAX_VALUE;
        if (hSize == 1) {
            hSize--;
            return heaparr[0];
        }


        int root = heaparr[0];
        heaparr[0] = heaparr[hSize - 1];
        hSize--;
        MinHeapify(0);

        return root;
    }


    void insertKey(int x) {
        if (hSize == capacity) {
            System.out.println("Could not insertKey");
            return;
        }


        hSize++;
        int i = hSize - 1;
        heaparr[i] = x;


        while (i != 0 && heaparr[parent(i)] > heaparr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }


    boolean SizeIsOne() {
        return (hSize == 1);
    }


    void swap(int x, int y) {
        int temp = heaparr[x];
        heaparr[x] = heaparr[y];
        heaparr[y] = temp;
    }
}
