package odd._252;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._252
 * @Author: xuyifang
 * @CreateTime: 2021-08-01 12:38
 * @Description:
 */
public class _5187_minimumPerimeter {

    public static void main(String[] args) {
        long neededApples = 1000000000;
        _5187_minimumPerimeter solution = new _5187_minimumPerimeter();

        System.out.println(solution.minimumPerimeter(neededApples));
    }

    public long minimumPerimeter(long neededApples) {
        long n = 0;
        long cir  = 0;
        long sum = 0;
        while (sum < neededApples) {
            n++;
            cir = n * 8;
            sum += 12 * n * n;
        }
        return cir;
    }
}
