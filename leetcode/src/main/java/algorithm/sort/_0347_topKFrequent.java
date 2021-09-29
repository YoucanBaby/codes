package algorithm.sort;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-06-18 19:16
 * @Description:
 */
public class _0347_topKFrequent {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 2;
        _0347_topKFrequent solution = new _0347_topKFrequent();

        int[] ret = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(ret));
    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int N = nums.length;
        List[] list = new ArrayList[N + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (list[freq] == null) list[freq] = new ArrayList();
            list[freq].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = N; i >= 0; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]);
            if (res.size() >= k) break;
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
