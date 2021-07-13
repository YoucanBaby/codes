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
        test t = new test();

        System.out.println(t.f(10));
    }

    public int f (int n) {
        if (n <= 2) {
            return n;
        }
        return f(n - 1) + f(n - 2);
    }

}
