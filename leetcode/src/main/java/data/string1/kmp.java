package data.string1;

import java.util.Arrays;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.string1
 * @Author: xuyifang
 * @CreateTime: 2021-07-02 21:10
 * @Description:
 */
public class kmp {

    public static void main(String[] args) {
        char[] T = {'a','c','t','g','p','a','c','y'};
        kmp kmp = new kmp();

        System.out.println(Arrays.toString(kmp.getNext(T)));
    }

    public int kmp(String s, String t){
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] next = getNext(tArr);

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if(j == -1 || sArr[i] == tArr[j]){
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length()) {
            return i - j;     //匹配成功返回下标
        }  else {
            return -1;
        }
    }

    public int[] getNext(char T[]) {
        int[] next = new int[T.length];
        next[0] = -1;

        int j = 0;
        int k = -1;

        while (j < T.length - 1) {
            if (k == - 1 || T[j] == T[k]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
