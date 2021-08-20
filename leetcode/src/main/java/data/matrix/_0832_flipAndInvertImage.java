package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 23:29
 * @Description:
 */
public class _0832_flipAndInvertImage {


    public int[][] flipAndInvertImage(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        for (int i = 0; i < M; i++) {
            reverse(mat[i], 0, N - 1);
        }
        return mat;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i ,j);
            nums[i] ^= 1;
            nums[j] ^= 1;
            i++;
            j--;
        }
        if (i == j) {
            nums[i] ^= 1;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
