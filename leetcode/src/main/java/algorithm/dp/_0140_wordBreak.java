package algorithm.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dp
 * @Author: xuyifang
 * @CreateTime: 2021-09-10 03:15
 * @Description:
 */
public class _0140_wordBreak {

    public static void main(String[] args) {
        _0140_wordBreak solution = new _0140_wordBreak();
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        System.out.println(solution.wordBreak(s, wordDict));
    }

    List<String> res = new ArrayList<>();
    int N;
    Set<String> set;
    boolean[] dp;

    public List<String> wordBreak(String s, List<String> wordDict) {
        N = s.length();
        set = new HashSet<>(wordDict);
        dp = new boolean[N + 1];
        dp[0] = true;

        for (int i = 0; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (dp[i] && set.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        dfs(s, 0, "");
        return res;
    }

    private void dfs(String s, int start, String path) {
        if (start == N) {
            res.add(path.substring(0, path.length() - 1));
        }
        for (int i = start; i < N; i++) {
            String word = s.substring(start, i + 1);
            if (dp[i + 1] && set.contains(word)) {
                dfs(s, i + 1, path + word + " ");
            }
        }
    }
}
