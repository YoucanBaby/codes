package algorithm.puzzle;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.puzzle
 * @Author: xuyifang
 * @CreateTime: 2021-08-26 03:12
 * @Description:
 */
public class _0277_findCelebrity extends Relation {

    public int findCelebrity(int N) {
        int left = 0;
        int right = N - 1;
        while (left < right) {
            if (knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == left) {
                continue;
            }
            if (!knows(i, left) || knows(left, i)) {
                return -1;
            }
        }
        return left;
    }
}
