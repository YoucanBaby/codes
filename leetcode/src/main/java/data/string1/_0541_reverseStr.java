package data.string1;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-08-20 12:31
 * @Description:
 */
public class _0541_reverseStr {


    public String reverseStr(String s, int k) {
        if (k == 1) {
            return s;
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (i + k - 1 < s.length()) {
                reverse(arr, i, i + k - 1);
            } else {
                reverse(arr, i, s.length() - 1);
            }
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
