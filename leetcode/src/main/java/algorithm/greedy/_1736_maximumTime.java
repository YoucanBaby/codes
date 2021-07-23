package algorithm.greedy;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.greedy
 * @Author: xuyifang
 * @CreateTime: 2021-07-24 04:47
 * @Description:
 */
public class _1736_maximumTime {


    public String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            if ('4' <= arr[1] && arr[1] <= '9') {
                arr[0] = '1';
            } else {
                arr[0] = '2';
            }
        }
        if (arr[1] == '?') {
            if (arr[0] == '2') {
                arr[1] = '3';
            } else {
                arr[1] = '9';
            }
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);
    }
}
