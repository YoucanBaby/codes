package algorithm.recursion.base;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.recursion.base
 * @Author: xuyifang
 * @CreateTime: 2021-07-13 15:10
 * @Description:
 */
public class HanoiTower {

    public static void main(String[] args) {
        HanoiTower solution = new HanoiTower();
        solution.hanoi(6, "左", "右", "中");
    }

    public void hanoi(int n, String start, String end, String other) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            System.out.println("移动1从" + start + "到" + end);
        } else {
            hanoi(n - 1, start, other, end);
            System.out.println("移动" + n + "从" + start + "到" + end);
            hanoi(n - 1, other, end, start);
        }
    }
}
