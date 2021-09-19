package data.matrix;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.matrix
 * @Author: xuyifang
 * @CreateTime: 2021-09-17 00:12
 * @Description:
 */
public class _0036_isValidSudoku {


    public boolean isValidSudoku(char[][] mat) {
        boolean[][] col = new boolean[9][9];
        boolean[][] row = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] == '.') {
                    continue;
                }
                int num = mat[i][j] - '1';
                int boxNum = (i / 3) * 3 + j / 3;

                if (col[i][num]) return false;
                else col[i][num] = true;

                if (row[num][j]) return false;
                else row[num][j] = true;

                if (box[boxNum][num]) return false;
                else box[boxNum][num] = true;
            }
        }
        return true;
    }
}
