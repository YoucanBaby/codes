package algorithm.sort;

import java.util.Arrays;

/**
 * @BelongsProject: interview
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-06-23 15:50
 * @Description:
 */
public class _0973_kClosest {

    public static void main(String[] args) {
        int[][] mat = {{1,3},{-2,2}};
        int k = 1;
        _0973_kClosest solution = new _0973_kClosest();
        int[][] res = solution.kClosest(mat, k);

        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] kClosest(int[][] mat, int k) {
        return quickSort(mat, k - 1, 0, mat.length - 1);
    }

    public int[][] quickSort(int[][] mat, int k, int left, int right) {
        // 快排切分后，mid左边的点距离都小于等于mat[mid], mid右边的点的距离都大于等于mat[mid]。
        int mid = partition(mat, left, right);
        if (mid == k) {
            return Arrays.copyOf(mat, k + 1);
        } else if (mid < k) {
            return quickSort(mat, k, mid + 1, right);
        } else {
            return quickSort(mat, k, left, mid - 1);
        }
    }

    private int partition(int[][] mat, int left, int right) {
        int p1 = left;
        int p2 = right;
        int pivot = distance(mat[right]);
        while (p1 < p2) {
            while (p1 < p2 && distance(mat[p1]) <= pivot) p1++;
            while (p1 < p2 && distance(mat[p2]) >= pivot) p2--;
            swap(mat, p1, p2);
        }
        swap(mat, p1, right);
        return p1;
    }

    private void swap(int[][] mat, int i, int j) {
        int[] temp = mat[i];
        mat[i] = mat[j];
        mat[j] = temp;
    }

    private int distance(int[] nums) {
        return nums[0] * nums[0] + nums[1] * nums[1];
    }
}
