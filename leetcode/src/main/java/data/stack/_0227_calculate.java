package data.stack;

import java.util.*;

/**
 * @BelongsProject: ForOffer
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-13 07:05
 * @Description:
 */
public class _0227_calculate {

    public static void main(String[] args) {
        int i = 1 + 1 * 1 / 1 - (1 + (1 - 1)) + 1 % 1 + (int) Math.pow(1, 1);
        String s = "1 + 1 * 1 / 1 - (1 + (1 - 1)) + 1 % 1 + 1 ^ 1";
        _0227_calculate solution = new _0227_calculate();

        System.out.println(i);
        System.out.println(solution.calculate(s));
    }


    public int calculate(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('%', 2);
        map.put('^', 3);

        Deque<Integer> nums = new LinkedList<>();
        nums.push(0);
        Deque<Character> ops = new LinkedList<>();
        s = s.replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peek() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pop();
                        break;
                    }
                }
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                nums.push(num);
            } else {
                while (!ops.isEmpty()) {
                    if (ops.peek() == '(') {
                        break;
                    }
                    char prevOps = ops.peek();
                    if (map.get(prevOps) >= map.get(c)) {
                        calc(nums, ops);
                    } else {
                        break;
                    }
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) calc(nums, ops);
        return nums.pop();
    }

    private void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;

        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();
        int res = 0;

        if (op == '+') res = a + b;
        else if (op == '-') res = a - b;
        else if (op == '*') res = a * b;
        else if (op == '/') res = a / b;
        else if (op == '%') res = a % b;
        else if (op == '^') res = (int) Math.pow(a, b);

        nums.push(res);
    }
}






