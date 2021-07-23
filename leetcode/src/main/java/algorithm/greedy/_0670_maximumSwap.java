package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-22 18:50
 * @Description:
 */
public class _0670_maximumSwap {

    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();

        // 记录每个数字最后一次出现的下标
        int[] lastIndex = new int[10];
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            lastIndex[c - '0'] = i;
        }

        // 找到当前位置右边大于它，并且是最大的数字，交换
        for (int i = 0; i < arr.length; i++) {
            for (int j = 9; j > arr[i] - '0'; j--) {  // 找最大，所以倒着找
                int index = lastIndex[j];
                if (i < index) {
                    swap(arr, i, index);
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
