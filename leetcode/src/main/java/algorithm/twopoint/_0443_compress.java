package algorithm.twopoint;

import sun.java2d.pipe.RegionIterator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 22:32
 * @Description:
 */
public class _0443_compress {


    public int compress(char[] arr) {
        int N = arr.length;
        int left = 0;
        int right = 0;
        while (right < N) {
            char c = arr[right];
            int count = 0;
            while (right < N && arr[right] == c) {
                count++;
                right++;
            }
            arr[left++] = c;
            if (count >= 2) {
                String s = String.valueOf(count);
                for (char temp : s.toCharArray()) {
                    arr[left++] = temp;
                }
            }
        }
        return left;
    }
}
