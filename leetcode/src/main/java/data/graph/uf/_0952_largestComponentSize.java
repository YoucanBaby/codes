package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-09-01 00:39
 * @Description:
 */
public class _0952_largestComponentSize {


    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        UnionFind uf = new UnionFind(max + 1);
        for (int num : nums) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }

        int[] freq = new int[max + 1];
        int res = 0;
        for (int num : nums) {
            freq[uf.find(num)]++;
            res = Math.max(res, freq[uf.find(num)]);
        }
        return res;
    }
}
