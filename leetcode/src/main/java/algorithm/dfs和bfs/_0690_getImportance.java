package algorithm.dfs和bfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.dfs和bfs
 * @Author: xuyifang
 * @CreateTime: 2021-09-02 22:45
 * @Description:
 */
public class _0690_getImportance {

    int res = 0;

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idAndInfo = new HashMap<>();
        for (Employee e : employees) {
            idAndInfo.put(e.id, e);
        }

        dfs(idAndInfo, id);
        return res;
    }

    private void dfs(Map<Integer, Employee> idAndInfo, int id) {
        Employee e = idAndInfo.get(id);
        res += e.importance;
        for (Integer subId : e.subordinates) {
            dfs(idAndInfo, subId);
        }
    }
}
