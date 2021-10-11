package algorithm.math;

import java.util.Iterator;

/**
 * @BelongsProject: codes
 * @BelongsPackage: algorithm.math
 * @Author: xuyifang
 * @CreateTime: 2021-10-05 21:23
 * @Description:
 */
class PeekingIterator <E> implements Iterator<E> {

    Iterator<E> iterator;
    E next;

    public PeekingIterator(Iterator<E> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) next = iterator.next();
    }

    public E peek() {
        return next;
    }

    @Override
    public E next() {
        E ans = next;
        next = iterator.hasNext() ? iterator.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}

