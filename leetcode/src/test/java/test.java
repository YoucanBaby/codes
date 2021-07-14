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
        int n = 1;
        while (n < Integer.MAX_VALUE / 4) {
            n = n * 4;
        }
        System.out.println(n);
    }


}
