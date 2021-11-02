package even._064;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._064
 * @author: xuyifang
 * @CreateTime: 2021-10-30-22:26
 * @description:
 * @version: 1.0
 */
public class _1 {

    public static void main(String[] args) {

    }


    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : arr) {
            if (map.get(s) == 1) {
                k--;
            }
            if (k == 0) {
                return s;
            }
        }
        return "";
    }
}
