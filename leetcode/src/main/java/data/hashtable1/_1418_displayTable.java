package data.hashtable1;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.hashtable1
 * @Author: xuyifang
 * @CreateTime: 2021-07-06 01:31
 * @Description:
 */
public class _1418_displayTable {

    public List<List<String>> displayTable(List<List<String>> orders) {
        HashSet<String> foodSet = new HashSet<>();
        HashMap<Integer, HashMap<String, Integer>> idMap = new HashMap<>();

        // 从订单中获取餐品名称和桌号，统计每桌点餐数量
        for (List<String> order : orders) {
            int id = Integer.valueOf(order.get(1));
            String food = order.get(2);
            foodSet.add(food);

            HashMap<String, Integer> foodMap = idMap.getOrDefault(id, new HashMap<>());
            foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
            idMap.put(id, foodMap);
        }

        // 提取餐品名称，并按字母顺序排列
        List<String> foodList = new ArrayList<>(foodSet);
        Collections.sort(foodList);

        // 提取桌号，并按餐桌桌号升序排列
        List<Integer> idList = new ArrayList<>(idMap.keySet());
        Collections.sort(idList);

        // 点菜展示表
        List<List<String>> table = new ArrayList<>();
        // 填写表的第一行
        List<String> header = new ArrayList<>(foodList);
        header.add(0, "Table");
        table.add(header);
        // 填写表的下面几行
        for (int i = 0; i < idList.size(); i++) {
            int id = idList.get(i);
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(id));

            HashMap<String, Integer> foodMap = idMap.get(id);
            for (int j = 0; j < foodList.size(); j++) {
                int count = foodMap.getOrDefault(foodList.get(j), 0);
                row.add(String.valueOf(count));
            }
            table.add(row);
        }
        return table;
    }
}
