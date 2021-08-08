package odd._253;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._253
 * @Author: xuyifang
 * @CreateTime: 2021-08-08 10:42
 * @Description:
 */
public class _5840_minSwaps {

    public int minSwaps(String str) {
        char[] s = str.toCharArray();
        int p1 = 0;
        int p2 = s.length - 1;
        int leftK = 0;
        int rightK = 0;
        int res = 0;

        while (p1 < p2) {
            while (p1 < p2) {
                if (s[p1] == '[') {
                    leftK++;
                    p1++;
                } else if (s[p1] == ']') {
                    if (leftK == 0) {
                        res++;
                        break;
                    } else {
                        p1++;
                        leftK--;
                    }
                }
            }
            while (p1 < p2) {
                if (s[p2] == ']') {
                    rightK++;
                    p2--;
                } else if (s[p2] == '[') {
                    if (rightK == 0) {
                        break;
                    } else {
                        p2--;
                        rightK--;
                    }
                }
            }
            swap(s, p1, p2);
        }
        return res;
    }

    private void swap(char[] s, int p1, int p2) {
        char temp = s[p1];
        s[p1] = s[p2];
        s[p2] = temp;
    }


    public int minSwaps1(String s) {
        int count = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res++;
                    count++;
                }
            }
        }
        return res;
    }
}
