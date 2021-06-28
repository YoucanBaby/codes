package data.array;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.array
 * @Author: xuyifang
 * @CreateTime: 2021-06-12 04:27
 * @Description:
 */
public class _0565_arrayNesting {

    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        _0565_arrayNesting solution = new _0565_arrayNesting();

        System.out.println(solution.arrayNesting(nums));
        System.out.println(solution.arrayNesting2(nums));
    }

    public int arrayNesting2(int[] nums) {
        int N = nums.length;
        int ret = 0;

        for (int i = 0; i < N; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = i;
                int cnt = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = nums[start];
                    nums[start] = Integer.MAX_VALUE;
                    start = temp;
                    cnt++;
                }
                ret = Math.max(ret, cnt);
            }
        }
        return ret;
    }

    public int arrayNesting(int[] nums) {
        int N = nums.length;
        int ret = 0;
        // 标记访问过的节点
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int start = i;      // 起始点
                int cnt = 0;        // 环的长度
                do{
                    visited[start] = true;      // 标记访问过的节点
                    cnt++;
                    start = nums[start];
                } while (start != i);     // 计算环的长度
                ret = Math.max(ret, cnt);
            }
        }
        return ret;
    }
}
