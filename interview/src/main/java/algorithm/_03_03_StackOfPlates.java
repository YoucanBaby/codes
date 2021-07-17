package algorithm;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.*;

/**
 * @BelongsProject: interview
 * @BelongsPackage: data.stack
 * @Author: xuyifang
 * @CreateTime: 2021-06-25 05:22
 * @Description:
 */
public class _03_03_StackOfPlates {
    class StackOfPlates {

        private List<Deque<Integer>> list;
        private int cap;

        public StackOfPlates(int cap) {
            list = new ArrayList<>();

            this.cap = cap;
        }

        public void push(int val) {
            if (cap <= 0) {
                return;
            }

            if (list.isEmpty() || list.get(list.size() - 1).size() == cap) {
                Deque<Integer> deque = new ArrayDeque<>();
                deque.push(val);
                list.add(deque);
                return;
            }

            list.get(list.size() - 1).push(val);
        }

        public int pop() {
            return popAt(list.size() - 1);
        }

        public int popAt(int index) {
            if (index < 0 || index >= list.size()) {
                return -1;
            }

            Deque<Integer> deque = list.get(index);
            if (deque.isEmpty()) {
                return -1;
            }

            int res = deque.pop();

            if (deque.isEmpty()) {
                list.remove(index);
            }

            return res;
        }
    }
}



