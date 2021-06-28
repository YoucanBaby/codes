package odd._247;

import java.util.Arrays;

/**
 * @BelongsProject: interview
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-06-27 10:57
 * @Description:
 */
public class _5799_wonderfulSubstrings {

    public static void main(String[] args) {
        String word = "abacc";
        _5799_wonderfulSubstrings solution = new _5799_wonderfulSubstrings();

        System.out.println(solution.wonderfulSubstrings(word));
        System.out.println(solution.wonderfulSubstrings1(word));
    }

    public long wonderfulSubstrings(String word) {
        long res = 0;
        int mask = 0;

        // 长度为2^10
        long[] freq = new long[1 << 10];
        freq[0] = 1;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            // 用异或更新mask
            mask ^= (1 << index);
            res += freq[mask];

            // 遍历mask的10个二进制位
            for (int i = 0; i < 10; i++) {
                res += freq[mask ^ (1 << i)];
            }

            freq[mask]++;
        }

        return res;
    }


    // 暴力
    public long wonderfulSubstrings1(String word) {
        int N = word.length();
        char[] arr = word.toCharArray();
        long res = N;

        for (int i = 0; i < N - 1; i++) {
            int[] count = new int[10];
            count[arr[i] - 'a']++;

            for (int j = i + 1; j < N; j++) {
                count[arr[j] - 'a']++;

                int flag = 0;
                for (int cnt: count) {
                    if (cnt % 2 == 1) {
                        flag++;
                    }
                }
                if (flag <= 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
