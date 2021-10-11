import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.beans.Transient;
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
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10 << 1));
        System.out.println(Integer.toBinaryString(-10 << 2));
        System.out.println();

        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10 >> 1));
        System.out.println(Integer.toBinaryString(-10 >> 2));
    }
}
