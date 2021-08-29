package odd._256;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._256
 * @Author: xuyifang
 * @CreateTime: 2021-08-29 10:43
 * @Description:
 */
public class _5855_kthLargestNumber {

    public static void main(String[] args) {
        String[] nums = {"683339452288515879","7846081062003424420","4805719838","4840666580043",
                "83598933472122816064","522940572025909479","615832818268861533","65439878015",
                "499305616484085","97704358112880133","23861207501102","919346676","60618091901581",
                "5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533",
                "55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530",
                "9567700","28449892665","2846386557790827231","53222591365177739","703029",
                "3280920242869904137","87236929298425799136","3103886291279"};

        _5855_kthLargestNumber solution = new _5855_kthLargestNumber();
        solution.kthLargestNumber(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {

            if (a.length() < b.length()) {
                return -1;
            } else if (a.length() > b.length()) {
                return 1;
            }

            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(i)) {
                    continue;
                } else if (a.charAt(i) < b.charAt(i)) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        });
        return nums[nums.length - k];
    }
}
