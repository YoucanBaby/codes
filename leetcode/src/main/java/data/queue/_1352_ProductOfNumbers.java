package data.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.queue
 * @Author: xuyifang
 * @CreateTime: 2021-09-16 17:25
 * @Description:
 */
public class _1352_ProductOfNumbers {


    class ProductOfNumbers {
        List<Integer> list;

        public ProductOfNumbers() {
            list = new ArrayList<>();
            list.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                list = new ArrayList<>();
                list.add(1);
            } else {
                list.add(list.get(list.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            if (k >= list.size()) {
                return 0;
            } else {
                return list.get(list.size() - 1) / list.get(list.size() - k - 1);
            }
        }
    }
}
