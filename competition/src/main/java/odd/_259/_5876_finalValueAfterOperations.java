package odd._259;

/**
 * @BelongsProject: codes
 * @BelongsPackage: odd._259
 * @Author: xuyifang
 * @CreateTime: 2021-09-19 10:30
 * @Description:
 */
public class _5876_finalValueAfterOperations {


    public int finalValueAfterOperations(String[] ops) {
        int res = 0;
        for (String op : ops) {
            if (op.equals("++X")) res++;
            if (op.equals("X++")) res++;
            if (op.equals("--X")) res--;
            if (op.equals("X--")) res--;
        }
        return res;
    }
}
