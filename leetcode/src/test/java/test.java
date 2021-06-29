import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @BelongsProject: interview
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 18:30
 * @Description:
 */

public class test {

    public static void main(String[] args) {
        int a = 10;
        List<Integer> list = new ArrayList<>();
        list.add(10);

        test1(a, list);

        System.out.println(a);
        System.out.println(list);
    }

    public static void test1(int a, List<Integer> list) {
        a = 0;
        list.set(0, 0);
    }
}
