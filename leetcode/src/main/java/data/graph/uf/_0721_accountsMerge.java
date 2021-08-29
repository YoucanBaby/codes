package data.graph.uf;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.graph
 * @Author: xuyifang
 * @CreateTime: 2021-08-29 14:30
 * @Description:
 */
public class _0721_accountsMerge {


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int N = accounts.size();
        UnionFind uf = new UnionFind(N);

        Map<String, Integer> emailAndIndex = new HashMap<>();       // <邮箱，账户下标>
        for (int i = 0; i < N; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailAndIndex.containsKey(email)) {
                    uf.union(i, emailAndIndex.get(email));
                }
                emailAndIndex.put(email, i);
            }
        }

        Map<Integer, Set<String>> indexAndEmails = new HashMap<>();   // <账户下标，邮箱集合>
        for (int i = 0; i < N; i++) {
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());

            int index = uf.find(i);
            if (!indexAndEmails.containsKey(index)) {
                indexAndEmails.put(index, new TreeSet<>());
            }
            indexAndEmails.get(index).addAll(emails);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry: indexAndEmails.entrySet()) {
            List<String> list = new ArrayList<>();
            int index = entry.getKey();
            String name = accounts.get(index).get(0);
            list.add(name);
            list.addAll(entry.getValue());
            res.add(list);
        }
        return res;
    }
}
