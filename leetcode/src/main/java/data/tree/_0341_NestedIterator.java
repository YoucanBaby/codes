package data.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 16:22
 * @Description:
 */
public class _0341_NestedIterator {


    public class NestedIterator implements Iterator<Integer> {

        Deque<Integer> deque = new ArrayDeque<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            dfs(nestedList);
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger item : nestedList) {
                if (item.isInteger()) {
                    deque.addLast(item.getInteger());
                } else {
                    dfs(item.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return deque.removeFirst();
        }

        @Override
        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }
}
