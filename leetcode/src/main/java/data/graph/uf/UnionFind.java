package data.graph.uf;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-28 04:57
 * @Description:
 */
class UnionFind {
    int count;      // 连通分量个数
    int[] parent;   // 节点i的父节点是parent[i]

    public UnionFind(int N) {
        this.count = N;         // n为图的节点总数
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;      // 父节点指针初始指向自己
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;          // x成为y的子树
        count--;
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
