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


    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (list[freq] == null) {
                list[freq] = new ArrayList();
            }
            list[freq].add(key);
        }

        // 从后向前遍历list，把所有非null的值都添加到新list中
        List<Integer> res = new ArrayList<>();
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) {
                continue;
            }
            res.addAll(list[i]);
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List[] list = new ArrayList[nums.length + 1];
        for (int key : freq.keySet()) {
            int val = freq.get(key);
            if (list[val] == null) list[val] = new ArrayList();
            list[val].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]);
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
