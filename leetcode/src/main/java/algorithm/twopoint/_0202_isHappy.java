package algorithm.twopoint;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.twopoint
 * @Author: xuyifang
 * @CreateTime: 2021-08-19 20:23
 * @Description:
 */
public class _0202_isHappy {


    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int slow = n;
        int fast = getNext(n);
        while (slow != fast) {
            if (slow == 1 || fast == 1) return true;
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1 || fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
