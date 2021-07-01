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
        Deque<String> deque = new LinkedList<>();
        deque.addFirst(null);

        System.out.println(deque);

        String s = "1";
        s = "2";
        System.out.println(s);
    }


}
