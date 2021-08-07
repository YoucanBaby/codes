package even._058;

/**
 * @BelongsProject: codes
 * @BelongsPackage: even._058
 * @Author: xuyifang
 * @CreateTime: 2021-08-07 22:35
 * @Description:
 */
public class _5827_checkMove {

    int[][] dirs = {
            {-1,-1},    {-1, 0},    {-1,1},
            {0,-1},                 {0,1},
            {1,-1},     {1, 0},     {1,1}
    };

    public boolean checkMove(char[][] mat, int row, int col, char color) {
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            int count = 0;
            // 如果没有越界
            while (isValid(newRow, newCol)) {
                if (mat[newRow][newCol] == '.') {
                    break;
                }
                if (mat[newRow][newCol] == color) {
                    if (count >= 1) {
                        return true;
                    }
                    break;
                }
                count++;
                newRow += dir[0];
                newCol += dir[1];
            }
        }
        return false;
    }

    private boolean isValid(int newRow, int newCol) {
        return newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8;
    }
}
