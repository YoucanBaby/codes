package algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.sort
 * @Author: xuyifang
 * @CreateTime: 2021-08-01 14:28
 * @Description:
 */
public class _1337_kWeakestRows {

    // 暴力
    public int[] kWeakestRows(int[][] mat, int k) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] temp = new int[M][2];  // {下标，军人出现次数}

        for (int i = 0; i < M; i++) {
            temp[i][0] = i;
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1) {
                    temp[i][1]++;
                }
            }
        }

        Arrays.sort(temp, (o1, o2) -> o1[1] - o2[1]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = temp[i][0];
        }
        return res;
    }

    public static void main(String[] args) {
//        int k = 3;
//        int[][] mat = {
//                {1,1,0,0,0},
//                {1,1,1,1,0},
//                {1,0,0,0,0},
//                {1,1,0,0,0},
//                {1,1,1,1,1}
//        };

        int k = 2;
        int[][] mat = {
                {1,0},
                {0,0},
                {1,0}
        };
        _1337_kWeakestRows solution = new _1337_kWeakestRows();

        int[] res = solution.kWeakestRows1(mat, k);
        System.out.println(Arrays.toString(res));
    }

    // 二分查找 + 优先队列
    public int[] kWeakestRows1(int[][] mat, int k) {
        int M = mat.length;
        // {下标，军人出现次数}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });

        for (int i = 0; i < M; i++) {
            int num = binarySearch(mat[i]);
            pq.add(new int[] {i, num});
        }

        while (pq.size() > k) {
            pq.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll()[0];
        }
        return res;
    }

    public int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == 1 ? left + 1 : left;
    }


}
