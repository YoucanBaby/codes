package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-28 05:34
 * @Description:
 */
public class _0990_equationsPossible {


    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                int x = e.charAt(0);
                int y = e.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!') {
                int x = e.charAt(0);
                int y = e.charAt(3);
                if (uf.find(x - 'a') == uf.find(y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
