package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-29 23:44
 * @Description:
 */
public class _0839_numSimilarGroups {


    public int numSimilarGroups(String[] arr) {
        int N = arr.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isSameWord(arr[i], arr[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    private boolean isSameWord(String word1, String word2) {
        if (word1.equals(word2)) {
            return true;
        }
        int count = 0;          // 字母不相同的个数
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        return true;
    }
}
