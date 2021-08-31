package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-07-12 05:50
 * @Description:
 */
public class _0765_minSwapsCouples {


    public int minSwapsCouples(int[] nums) {
        int N = nums.length / 2;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < nums.length; i += 2) {
            uf.union(nums[i] / 2, nums[i + 1] / 2);
        }
        return N - uf.count;
    }
}
