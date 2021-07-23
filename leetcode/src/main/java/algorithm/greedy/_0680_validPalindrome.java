package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-23 01:31
 * @Description:
 */
public class _0680_validPalindrome {

    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return valid(arr, left + 1, right) || valid(arr, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean valid(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
