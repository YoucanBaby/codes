package base;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-09-27 02:54
 * @Description:
 */
public class Sort {

    public static void main(String[] args) {
        Sort test = new Sort();

        int[] nums = {2,4,9,0,1,3,5,7,6,8};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums) + "  api");
        Shuffle s = new Shuffle(nums);
        s.shuffle();

        test.bubbleSort(nums);
        System.out.println(Arrays.toString(nums) + "  bubble");
        s.shuffle();

        test.selectionSort(nums);
        System.out.println(Arrays.toString(nums) + "  selection");
        s.shuffle();

        test.insertionSort(nums);
        System.out.println(Arrays.toString(nums) + "  insertion");
        s.shuffle();

        test.shellSort(nums);
        System.out.println(Arrays.toString(nums) + "  shell");
        s.shuffle();

        test.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums) + "  merge");
        s.shuffle();

        test.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums) + "  quick");
        s.shuffle();

        int[] nums1 = {Integer.MAX_VALUE, 2,4,9,0,1,3,5,7,6,8};
        test.heapSort(nums1);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums1, 1, nums1.length)) + "  heap");
        s.shuffle();

        int[] nums2 = {2,2,3,3,6,4};
        test.countSort(nums2);
        System.out.println(Arrays.toString(nums2) + "  count");
        s.shuffle();
    }

    public void countSort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int N = max - min + 1;
        int[] freq = new int[N];
        for (int num : nums) {
            freq[num - min]++;
        }
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                nums[index++] = min + i;
                freq[i]--;
            }
        }
    }

    public void heapSort(int[] nums) {
        int N = nums.length - 1;
        for (int i = N / 2; i >= 0; i--) {
            down(nums, i, N);
        }
        while (N > 1) {
            swap(nums, 1, N);
            N--;
            down(nums, 1, N);
        }
    }

    // 当前节点比子节点小，就需要不断地向下进行比较和交换操作。父节点如果有两个子节点，应当与两个子节点中最大那个节点进行交换。
    private void down(int[] nums, int i, int N) {
        int max = i;
        if (i * 2 <= N && nums[max] < nums[i * 2]) max = i * 2;
        if (i * 2 + 1 <= N && nums[max] < nums[i * 2 + 1]) max = i * 2 + 1;
        if (max != i) {
            swap(nums, i, max);
            down(nums, max, N);
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int p1 = left;
        int p2 = right;
        int pivot = nums[right];
        while (p1 < p2) {
            while (p1 < p2 && nums[p1] <= pivot) p1++;
            while (p1 < p2 && nums[p2] >= pivot) p2--;
            swap(nums, p1, p2);
        }
        swap(nums, p1, right);
        return p1;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private void merge(int[] nums, int left, int right, int mid) {
        int p1 = left;
        int p2 = mid + 1;
        int[] temp = new int[nums.length];
        int i = left;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[i++] = nums[p1++];
            } else {
                temp[i++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[i++] = nums[p2++];
        }
        for (int j = left; j <= right; j++) {
            nums[j] = temp[j];
        }
    }

    public void shellSort(int[] nums) {
        int N = nums.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int j = h; j < N; j++) {
                for (int i = j; i >= h; i -= h) {
                    if (nums[i - h] < nums[i]) break;
                    swap(nums, i - h, i);
                }
            }
            h /= 3;
        }
    }

    public void insertionSort(int[] nums) {
        for (int j = 1; j < nums.length; j++) {
            for (int i = j; i >= 1; i--) {
                if (nums[i - 1] < nums[i]) break;
                swap(nums, i - 1, i);
            }
        }
    }

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            swap(nums, i, min);
        }
    }

    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
