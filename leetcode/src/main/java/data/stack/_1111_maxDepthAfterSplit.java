package data.stack;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-09-15 19:43
 * @Description:
 */
public class _1111_maxDepthAfterSplit {


    public int[] maxDepthAfterSplit(String s) {
        int N = s.length();
        int[] res = new int[N];
        int depth = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '(') {
                depth++;
                res[i] = depth % 2;
            } else {
                res[i] = depth % 2;
                depth--;
            }
        }
        return res;
    }
}
