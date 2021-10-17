import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.beans.Transient;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @BelongsProject: interview
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 18:30
 * @Description:
 */


public class test <K, V> {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>(){
            public void test() {
                System.out.println("匿名内部类");
            }
        };

        System.out.println();
    }
}
