package even._064;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._064
 * @author: xuyifang
 * @CreateTime: 2021-10-30-22:26
 * @description:
 * @version: 1.0
 */
public class _2 {

    public static void main(String[] args) {
        TreeSet<int[]> treeSet = new TreeSet<>((a, b) -> {
            if (b[2] != a[2]) {
                return b[2] - a[2];
            } else if (b[0] != a[0]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });
    }


    public int maxTwoEvents(int[][] events) {
        int max = 0;
        for (int[] e : events) {
            max = Math.max(max, e[2]);
        }

        return 0;

    }
}
