import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-09-19 14:02
 * @Description:
 */
class DetectSquares {

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.test();
    }

    public void test() {
        int[] p1 = {1,1};
        int[] p2 = {1,1};

        location l1 = new location(p1[0], p1[1]);
        location l2 = new location(p2[0], p2[1]);

        Map<location, Integer> map = new HashMap<>();
        map.put(l1, 1);
        System.out.println(map.toString());
        map.put(l2, map.getOrDefault(l2, 0) + 1);
        System.out.println(map.toString());
    }

    class location {
        int x;
        int y;

        public location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            location l = (location) obj;
            return x == l.x && y == l.y;
        }

        @Override
        public int hashCode() {
            return x * 10000 + 10;
        }
    }
}

