import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @BelongsProject: interview
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 18:30
 * @Description:
 */

public class test {
    public static void main(String[] args) {
        test test = new test();

        int n = -4;
        System.out.println(test.abs(n));

        int a = 6;
        System.out.println(a & ~(1 << 1));
        System.out.println(a | (1 << 3));
    }

    int abs(int n) {
        System.out.println(n >> 31);
        System.out.println((n ^ (n >> 31)));
        return (n ^ (n >> 31)) - (n >> 31);
    }
}
