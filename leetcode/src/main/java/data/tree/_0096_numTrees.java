package data.tree;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-06-30 09:31
 * @Description:
 */
public class _0096_numTrees {

    public static void main(String[] args) {

    }

    public int numTrees(int n) {
        long C = 1;

        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }

        return (int) C;
    }
}
