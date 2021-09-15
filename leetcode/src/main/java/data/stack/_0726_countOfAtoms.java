package data.stack;

import java.util.*;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-07-05 10:01
 * @Description:
 */
public class _0726_countOfAtoms {

    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2";
        _0726_countOfAtoms solution = new _0726_countOfAtoms();

        System.out.println(solution.countOfAtoms(formula));
    }

    int i = 0;
    String formula;
    Deque<HashMap<String, Integer>> stack = new ArrayDeque<>();

    public String countOfAtoms(String formula) {
        this.formula = formula;
        int N = formula.length();

        while (i < N) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.addLast(new HashMap<String, Integer>());
                i++;
            } else if (c >= 'A' && c <= 'Z') {
                isAlpha();
            } else if (c == ')') {
                isRightP();
            }
        }

        // 最后栈里只有一个map了
        HashMap<String, Integer> map = stack.removeFirst();
        // HashMap转TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry: treeMap.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();

            sb.append(key);
            if (val > 1) {
                sb.append(val);
            }
        }
        return sb.toString();
    }

    // 如果是右括号
    public void isRightP() {
        // 取出栈顶的map
        HashMap<String, Integer> popMap = stack.removeLast();

        // 获得右括号后的数字
        i++;
        int num = 0;
        while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
            char c = formula.charAt(i);
            num = num * 10 + c - '0';
            i++;
        }
        if (num == 0) {
            num = 1;
        }

        // map里字母对应的数字都乘上num
        for (String key:  popMap.keySet()) {
            int value = popMap.get(key);
            popMap.put(key, value * num);
        }

        // 把这个map加到栈顶的map上
        if (stack.isEmpty()) {
            stack.addLast(popMap);
        } else {
            HashMap<String, Integer> topMap = stack.getLast();
            for (String key : popMap.keySet()) {
                int value = popMap.get(key);
                topMap.put(key, topMap.getOrDefault(key, 0) + value);
            }
        }
    }

    // 如果是字母
    public void isAlpha() {
        // 把一个元素对应的字母都找出来
        StringBuilder sb = new StringBuilder();
        sb.append(formula.charAt(i));
        i++;

        while (i < formula.length() && formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
            sb.append(formula.charAt(i));
            i++;
        }

        // 找出它的个数
        int num = 0;
        while (i < formula.length() && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
            char c = formula.charAt(i);
            num = num * 10 + c - '0';
            i++;
        }
        if (num == 0) {
            num = 1;
        }

        // 将原子及数字加入栈顶的哈希表中
        HashMap<String, Integer> map;
        if (stack.isEmpty()) {
            map = new HashMap<>();
        } else {
            map = stack.removeLast();
        }
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + num);
        stack.addLast(map);
    }
}
