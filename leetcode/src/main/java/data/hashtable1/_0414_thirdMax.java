package data.hashtable1;

import java.util.TreeSet;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-10-06 17:20
 * @Description:
 */
public class _0414_thirdMax {


    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) set.remove(set.first());
        }
        return set.size() == 3 ? set.first() : set.last();
    }
}
