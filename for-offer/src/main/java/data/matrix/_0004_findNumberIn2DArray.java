package data.matrix;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: com.yifang
 * @Author: xuyifang
 * @CreateTime: 2021-06-10 20:57
 * @Description:
 */
public class _0004_findNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = { {1,   4,  7, 11, 15},
                        {2,   5,  8, 12, 19},
                        {3,   6,  9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
        int target1 = 5;
        int target2 = 165156;

        _0004_findNumberIn2DArray solution = new _0004_findNumberIn2DArray();
        System.out.println(solution.findNumberIn2DArray(matrix, target1));
        System.out.println(solution.findNumberIn2DArray(matrix, target2));
    }

    private boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 从右上角的位置，向左下方移动，即当前元素的查找区间为左下角的所有元素。
        int r = 0;
        int c = cols - 1;
        // 小于它的数一定在其左边，大于它的数一定在其下边，
        while(r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;    // 查找成功
            } else if (target < matrix[r][c]) {
                c--;            // 朝左移动
            } else {
                r++;            // 朝下移动
            }
        }
        return false;
    }


}
