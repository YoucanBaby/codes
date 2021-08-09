package algorithm.sort.base;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort.base
 * @Author: xuyifang
 * @CreateTime: 2021-08-08 05:46
 * @Description:
 */
public class Heap {
    int[] heap;
    int N = 0;

    public Heap() {
        heap = new int[N + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j + 1 <= N && heap[j] < heap[j + 1])
                j++;
            if (heap[k] > heap[j])
                break;
            swap(k, j);
            k = j;
        }
    }

    public void swim(int k) {
        while (k > 1 && heap[k / 2] < heap[k]) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    public void insert(int v) {
        N++;
        heap[N] = v;
        swim(N);
    }

    public int delMax() {
        int max = heap[1];
        swap(1, N--);
        heap[N + 1] = Integer.MIN_VALUE;
        sink(1);
        return max;
    }
}
