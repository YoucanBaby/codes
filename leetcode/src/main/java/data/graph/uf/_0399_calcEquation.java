package data.graph.uf;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph.uf
 * @Author: xuyifang
 * @CreateTime: 2021-08-28 07:51
 * @Description:
 */
public class _0399_calcEquation {


    public static void main(String[] args) {
        _0399_calcEquation solution = new _0399_calcEquation();

        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>());
        equations.add(new ArrayList<>());
        equations.get(0).add("a");
        equations.get(0).add("b");
        equations.get(1).add("b");
        equations.get(1).add("c");
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>());
        queries.add(new ArrayList<>());
        queries.get(0).add("a");
        queries.get(0).add("c");
        queries.get(1).add("b");
        queries.get(1).add("a");

        double[] res = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind(equations.size() * 2);

        Map<String, Integer> valAndId = new HashMap<>();        // <等式的变量，id>
        int id = 0;
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);

            if (!valAndId.containsKey(var1)) {
                valAndId.put(var1, id++);
            }
            if (!valAndId.containsKey(var2)) {
                valAndId.put(var2, id++);
            }
            uf.union(valAndId.get(var1), valAndId.get(var2), values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = valAndId.get(var1);
            Integer id2 = valAndId.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0;
                continue;
            }

            if (uf.find(id1) == uf.find(id2)) {
                res[i] = uf.weight[id1] / uf.weight[id2];
            } else {
                res[i] = -1.0;
            }
        }
        return res;
    }

    class UnionFind {
        int[] parent;       // 节点i的父节点是parent[i]
        double[] weight;    // 指向父节点的权值

        public UnionFind(int N) {
            parent = new int[N];
            weight = new double[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int x, int y,double val) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * val / weight[x];
        }

        public int find(int x) {
            if (x != parent[x]) {
                int temp = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[temp];
            }
            return parent[x];
        }
    }
}
