package data.hashtable1;

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

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        List<Integer>[] freqList = new ArrayList[nums.length + 1];
        // 创建一个freqList数组，将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标即可
        for (Map.Entry<Integer, Integer> entrySet: map.entrySet()) {
            int num = entrySet.getKey();
            int freq = entrySet.getValue();
            if (freqList[freq] == null) {
                freqList[freq] = new ArrayList();
            }
            freqList[freq].add(num);
        }

        // 从后向前遍历freqList数组，把所有非null的值都添加到新list中
        List<Integer> list = new ArrayList<>();
        for (int i = freqList.length - 1; i >= 0; i--) {
            if (freqList[i] != null) {
                list.addAll(freqList[i]);
            }
            if (list.size() >= k) {
                break;
            }
        }

        // list转int数组
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
